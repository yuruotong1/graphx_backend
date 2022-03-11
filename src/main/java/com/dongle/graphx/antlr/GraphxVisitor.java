package com.dongle.graphx.antlr;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongle.graphx.Domain.Edge;
import com.dongle.graphx.Domain.Node;
import com.dongle.graphx.antlr.code.GraphxGrammarBaseVisitor;
import com.dongle.graphx.antlr.code.GraphxGrammarParser;
import com.dongle.graphx.utils.Constant;
import com.dongle.graphx.utils.LogUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GraphxVisitor extends GraphxGrammarBaseVisitor<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphxVisitor.class);
    ArrayList<Edge> edgeList = new ArrayList<>();
    ArrayList<Node> nodeList = new ArrayList<>();

    JSONObject res = new JSONObject();

    public GraphxVisitor(JSONArray requestNodeList) {
        for (Object requestNodeObj : requestNodeList) {
            Node requestNode = JSON.parseObject(requestNodeObj.toString(), Node.class);
            nodeList.add(requestNode);
        }
    }

    @Override
    public JSONObject visitStat(GraphxGrammarParser.StatContext ctx) {
        for (GraphxGrammarParser.StatementContext statementContext : ctx.statement()) {
            visit(statementContext);
        }
        res.put("edgeList", edgeList);
        res.put("nodeList", nodeList);
        return res;
    }

    /*
     * 创建边
     * */
    public Edge createEdge(String type, String text, Node sourceNode, Node targetNode) {
        Edge edge = new Edge();
        edge.setType(type);
        edge.setText(text);
        edge.setSourceNode(sourceNode);
        edge.setTargetNode(targetNode);
        return edge;
    }

    @Override
    public Node visitExpression(GraphxGrammarParser.ExpressionContext ctx) {
        Node left = (Node) visit(ctx.lineExpression(0));
        Node right = (Node) visit(ctx.lineExpression(1));
        String edgeType =  ctx.opLineArrow != null && ctx.opLineArrow.getText().equals(">") ? Constant.ARROW_NORMAL : Constant.ARROW_NONE;
        String edgeText =  ctx.opLineString == null ? "" : ctx.opLineString.getText();
        Edge edge = createEdge(edgeType, edgeText, left, right);
        edgeList.add(edge);
        return right;
    }

    @Override
    public Node visitIdentifier(GraphxGrammarParser.IdentifierContext ctx)  {
        return getNode(ctx.getText());
    }

    /*
     * 根据 id 获取 node，若不存在，创建一个 node
     * */
    public Node getNode(String id) {
        for(Node node: nodeList) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        return createNode(id);


    }

    // 获取第一张图片
    public String getSvgFromIconsApi(String searchName) {
        // 根据节点名称，使用网络图片
        CloseableHttpClient client = HttpClientBuilder.create().build();
        JSONObject responseJson=null;
        try {
            HttpGet httpGet = new HttpGet(Constant.SEARCH_SVG_URL + searchName);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            responseJson = JSON.parseObject(responseString);
        } catch (IllegalArgumentException | IOException e) {
            LogUtil.error(LOGGER, e, "request error");
        }
            // 如果没搜索到图片，则使用默认图片
            if(responseJson != null &&
                    !(responseJson.containsKey(Constant.RESULT) &&
                    !responseJson.getString(Constant.RESULT).equals(Constant.ERROR))) {
                JSONObject page = responseJson.getJSONObject(Constant.PAGES);
                JSONArray elements = page.getJSONArray(Constant.ELEMENTS);
                if (elements.size() != 0) {
                    JSONObject element = elements.getJSONObject(0);
                    return element.getString(Constant.URL);
                }
            }
            return Constant.DEFAULT_SVG_URL;
    }
    /*
     * 解析 antlr 中的结点信息，创建结点
     * */
    public Node createNode(String id) {
        Node res = new Node();
        res.setId(id);
        res.setText(id);
        res.setSearchPictureName(res.getText());
        res.setAvatar(getSvgFromIconsApi(res.getSearchPictureName()));
        LogUtil.info(LOGGER, "create node", res.getId(), res.getAvatar());
        nodeList.add(res);
        return res;
    }


}
