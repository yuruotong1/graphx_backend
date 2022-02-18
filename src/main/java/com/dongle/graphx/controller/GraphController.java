package com.dongle.graphx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongle.graphx.Domain.Edge;
import com.dongle.graphx.Domain.Node;
import com.dongle.graphx.antlr.GraphxVisitor;
import com.dongle.graphx.antlr.code.GraphxGrammarLexer;
import com.dongle.graphx.antlr.code.GraphxGrammarParser;
import com.dongle.graphx.utils.Command;
import com.dongle.graphx.utils.Constant;
import com.dongle.graphx.utils.LogUtil;
import com.dongle.graphx.utils.TempFile;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import static com.dongle.graphx.utils.ConvertSvg2Png.convertHttpSvg2Png;
import static com.dongle.graphx.utils.TempFile.deleteDir;

@RestController
@RequestMapping("/graph")
public class GraphController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphController.class);

    @RequestMapping("/parse")
    @PostMapping
    public JSONObject getParseResult(@RequestBody String requestDataString) {
        JSONObject requestDataObj = JSON.parseObject(requestDataString);
        String rawData = (String) requestDataObj.get(Constant.RAWDATA);
        LogUtil.info(LOGGER, "receive data", requestDataObj.toJSONString());
        CharStream codePointCharStream = CharStreams.fromString(rawData);
        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
        GraphxGrammarParser.StatContext tree = parser.stat();
        JSONObject requestGraphData = requestDataObj.getJSONObject(Constant.JSON_DATA);
        JSONArray requestNodes = (JSONArray) requestGraphData.get(Constant.NODE_LIST);
        GraphxVisitor eval = new GraphxVisitor(requestNodes);
        JSONObject res = new JSONObject();
        Object graphData;
        try {
            graphData = eval.visit(tree);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e);
            res.put("success", false);
            return res;
        }
        if (graphData == null) {
            res.put("success", false);
            return res;

        }
        res.put(Constant.GRAPH_DATA, graphData);
        res.put("success", true);
        return res;
    }


    @RequestMapping(value = "/getPng", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void getPargh(@RequestBody String requestDataString, HttpServletResponse response) {
        JSONObject requestDataObj = JSON.parseObject(requestDataString);
        LogUtil.info(LOGGER, "receive data", requestDataObj.toJSONString());
        JSONArray edges = requestDataObj.getJSONArray("edgeList");
        JSONArray nodes = requestDataObj.getJSONArray("nodeList");
        File tempDir = TempFile.createDir();
        Map<String, Object> result = createGraphviz(edges, nodes, tempDir);
        String base = "digraph G {\n charset=\"UTF-8\" rankdir=\"LR\"\n"+ result.get(Constant.GRAPHVIZ_NODE_EDGE) + "\n}";
        try {
            File file = TempFile.createFile(tempDir, "tmp.dot", base);
            String outPath = tempDir.getPath() + "/outfile.png";
            String command = "cmd.exe /C dot.exe -Kdot -Tpng " + file.getAbsolutePath() + " -o " + outPath;
            Command.run(command);
            OutputStream outputStream = response.getOutputStream();
            LogUtil.info(LOGGER, "Run command", command);
            response.setContentType("image/png");
            ImageIO.write(ImageIO.read(new File(outPath)), "PNG", outputStream);
        } catch (IOException e) {
            LogUtil.error(LOGGER, e);
        }
        deleteDir(tempDir);
    }

    public Map<String, Object> createGraphviz(JSONArray edges, JSONArray nodes, File tempDir) {
        Map<String, Object> res = new HashMap<>();
        StringBuilder nodeDefine = new StringBuilder();
        for (Object nodeObj : nodes) {
            Node node = JSON.parseObject(JSON.toJSONString(nodeObj), Node.class);
            File file = convertHttpSvg2Png(node.getAvatar(), tempDir);
            assert file != null;
            String nodeString = node.getId() + " [shape=\"none\", label=<<TABLE BORDER=\"0\" >\n" +
                    "<TR><TD PORT=\"f1\" FIXEDSIZE=\"TRUE\" WIDTH=\"75\" HEIGHT=\"75\"><IMG  SRC=\"" + file.getAbsolutePath() + "\"/></TD></TR>\n" +
                    "<TR><TD>" + node.getId() + "</TD></TR>\n" +
                    "</TABLE>> fontname=\"Dengxian\"]";
            nodeDefine.append(nodeString).append("\n");
        }
        StringBuilder edgeDefine = new StringBuilder();
        for (Object edgeObj : edges) {
            Edge edge = JSON.parseObject(JSON.toJSONString(edgeObj), Edge.class);
            Node sourceNode = edge.getSourceNode();
            Node targetNode = edge.getTargetNode();
            String arrow = edge.getType().endsWith("_ARROW") ? Constant.ARROW_NORMAL : Constant.ARROW_NONE;
            LogUtil.info(LOGGER, "arrow type", arrow);
            String edgeString = sourceNode.getId() + ":f1 -> " + targetNode.getId() +":f1" +
                    String.format(" [arrowhead=\"%s\" label=\"%s\" fontname=\"Dengxian\"]", arrow, edge.getText());
            edgeDefine.append(edgeString).append("\n");
        }
        String defineNodeEdge = nodeDefine + "\n" + edgeDefine;
        res.put(Constant.GRAPHVIZ_NODE_EDGE, defineNodeEdge);
        return res;
    }
}
