package com.dongle.graphx.antlr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongle.graphx.Domain.Edge;
import com.dongle.graphx.Domain.Node;
import com.dongle.graphx.antlr.code.GraphxGrammarBaseVisitor;
import com.dongle.graphx.antlr.code.GraphxGrammarParser;
import com.dongle.graphx.utils.Constant;
import com.dongle.graphx.utils.GraphvizDot;
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
import java.util.LinkedHashMap;
import java.util.Map;


public class GraphxVisitor extends GraphxGrammarBaseVisitor<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphxVisitor.class);
    JSONArray requestNodeArray;
    Map<String, Node> nodeMap = new LinkedHashMap<>();
    JSONObject res = new JSONObject();
    GraphvizDot graphvizDot;

    public GraphxVisitor(JSONArray requestNodeArray, GraphvizDot graphvizDot) {
        this.requestNodeArray = requestNodeArray;
        this.graphvizDot = graphvizDot;

    }

    @Override
    public JSONObject visitStat(GraphxGrammarParser.StatContext ctx) {
        for (GraphxGrammarParser.StatementContext statementContext : ctx.statement()) {
            String statement = (String) visit(statementContext);
            graphvizDot.addStatement(statement);
        }
        res.put(Constant.NODE_LIST, new ArrayList<>(nodeMap.values()));
        return res;
    }

    @Override
    public String visitLineExpression(GraphxGrammarParser.LineExpressionContext ctx) {
        int nodeSize = ctx.nodeId().size();
        StringBuilder res = new StringBuilder();
        if (nodeSize == 1) {
            getNode(res, ctx.nodeId(0).getText());
            return res.toString();
        }
        for (int i = 0; i < nodeSize - 1; i += 1) {
            String sourceNodeId = ctx.nodeId(i).getText();
            Node sourceNode = getNode(res, sourceNodeId);
            String targetNodeId = ctx.nodeId(i + 1).getText();
            Node targetNode = getNode(res, targetNodeId);
            Edge edge = (Edge) visit(ctx.lineStatement(i));
            edge.setSourceNode(sourceNode);
            edge.setTargetNode(targetNode);
            res.append(graphvizDot.createEdge(edge));
        }
        return res.toString();
    }

    private Node getNode(StringBuilder res, String sourceNodeId) {
        Node sourceNode;
        if (!nodeMap.containsKey(sourceNodeId)) {
            sourceNode = getNodeFromRequestNodeArray(sourceNodeId);
            nodeMap.put(sourceNodeId, sourceNode);
            res.append(graphvizDot.createNode(sourceNode));
        } else {
            // 如果已经创建过结点则不创建
            sourceNode = nodeMap.get(sourceNodeId);
        }
        return sourceNode;
    }

    @Override
    public Edge visitLineStatement(GraphxGrammarParser.LineStatementContext ctx) {
        String edgeType = ctx.Arrow() != null && ">".equals(ctx.Arrow().getText()) ? Constant.ARROW_NORMAL : Constant.ARROW_NONE;
        String edgeText = ctx.lineText() == null ? "" : ctx.lineText().getText();
        Edge edge = new Edge();
        edge.setType(edgeType);
        edge.setText(edgeText);
        return edge;
    }


    @Override
    public Void visitStructDefile(GraphxGrammarParser.StructDefileContext ctx) {
        System.out.println(123);
        return null;
    }

    /*
     * 根据 id 获取 node，若不存在，创建一个 node
     * */
    public Node getNodeFromRequestNodeArray(String id) {
        for (Object nodeObj : requestNodeArray) {
            Node node = JSON.parseObject(JSON.toJSONString(nodeObj), Node.class);
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
        JSONObject responseJson = null;
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
        if (responseJson != null &&
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
        nodeMap.put(res.getId(), res);
        return res;
    }


}
