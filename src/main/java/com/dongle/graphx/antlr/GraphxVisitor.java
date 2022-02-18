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
import org.antlr.v4.runtime.tree.TerminalNode;
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
    ArrayList<Node> nodeList = new ArrayList<>();
    ArrayList<Edge> edgeList = new ArrayList<>();
    Map<String, Node> requestNodeMap = new HashMap<>();
    Map<String, Object> res = new HashMap<>();

    public GraphxVisitor(JSONArray requestNodeList) {
        for (Object requestNodeObj : requestNodeList) {
            Node requestNode = JSON.parseObject(requestNodeObj.toString(), Node.class);
            requestNodeMap.put(requestNode.getId(), requestNode);
        }
    }

    @Override
    public Map<String, Object> visitNode(GraphxGrammarParser.NodeContext ctx) {
        LogUtil.info(LOGGER, "create node", ctx.STRING().getText());
        getNode(ctx.STRING().getText());
        res.put("edgeList", edgeList);
        res.put("nodeList", nodeList);
        return res;
    }

    @Override
    public Map<String, Object> visitStatExpr(GraphxGrammarParser.StatExprContext ctx) {
        for (GraphxGrammarParser.ExprContext expr : ctx.expr()) {
            visit(expr);
        }
        res.put("edgeList", edgeList);
        res.put("nodeList", nodeList);
        return res;
    }

    @Override
    public Edge visitLineLine(GraphxGrammarParser.LineLineContext ctx) {
        return createEdge(Constant.LINE_LINE);
    }

    @Override
    public Edge visitLineStringLine(GraphxGrammarParser.LineStringLineContext ctx) {
        return createEdge(Constant.LINE_STRING_LINE, ctx.STRING().getText());
    }

    @Override
    public Edge visitLineLineArrow(GraphxGrammarParser.LineLineArrowContext ctx) {
        return createEdge(Constant.LINE_LINE_ARROW);
    }

    @Override
    public Edge visitLineStringLineArrow(GraphxGrammarParser.LineStringLineArrowContext ctx) {
        return createEdge(Constant.LINE_STRING_LINE_ARROW, ctx.STRING().getText());
    }

    /*
     * 创建边
     * */
    public Edge createEdge(String type, String text) {
        Edge edge = new Edge();
        edge.setType(type);
        edge.setText(text);
        return edge;
    }

    public Edge createEdge(String type) {
        return createEdge(type, "");
    }

    @Override
    public Void visitExpr(GraphxGrammarParser.ExprContext ctx) {
        for (int i = 0; i < ctx.children.size() - 1; i += 2) {
            TerminalNode sourceTerminalNode = (TerminalNode) ctx.getChild(i);
            GraphxGrammarParser.LineContext line = (GraphxGrammarParser.LineContext) ctx.getChild(i + 1);
            TerminalNode targetTerminalNode = (TerminalNode) ctx.getChild(i + 2);
            Node sourceNode = getNode(sourceTerminalNode.getText());
            Node targetNode = getNode(targetTerminalNode.getText());
            Edge edge = (Edge) visit(line);
            edge.setSourceNode(sourceNode);
            edge.setTargetNode(targetNode);
            edgeList.add(edge);
        }
        return null;
    }

    /*
     * 根据 id 获取 node，若不存在，创建一个 node
     * */
    public Node getNode(String id) {
        for (Node node : nodeList) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        return createNode(id);
    }


    /*
     * 解析 antlr 中的结点信息，组合成符合 logicflow 的 node
     * */
    public Node createNode(String id) {
        Node res;
        if (requestNodeMap.containsKey(id)) {
            res = requestNodeMap.get(id);
        } else {
            res = new Node();
            res.setId(id);
            res.setText(id);
            // 根据节点名称，使用网络图片
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("https://iconsapi.com/api/search?appkey=620271bee4b06f79691875ea&query=" + res.getText());
            try {
                CloseableHttpResponse response = client.execute(httpGet);
                HttpEntity responseEntity = response.getEntity();
                String responseString = EntityUtils.toString(responseEntity);
                JSONObject responseJson = JSON.parseObject(responseString);
                JSONObject page = responseJson.getJSONObject(Constant.PAGES);
                JSONArray elements = page.getJSONArray(Constant.ELEMENTS);
                JSONObject element = elements.getJSONObject(0);
                res.setAvatar(element.getString(Constant.URL));
            } catch (IOException e) {
                LogUtil.error(LOGGER, e, "request error");
            }

        }
        nodeList.add(res);
        return res;
    }


}
