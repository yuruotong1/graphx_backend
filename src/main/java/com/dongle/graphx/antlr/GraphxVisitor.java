package com.dongle.graphx.antlr;

import com.dongle.graphx.Domain.Edge;
import com.dongle.graphx.Domain.Node;
import com.dongle.graphx.antlr.code.GraphxGrammarBaseVisitor;
import com.dongle.graphx.antlr.code.GraphxGrammarParser;
import com.dongle.graphx.utils.Constant;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphxVisitor extends GraphxGrammarBaseVisitor<Object> {
    ArrayList<Node> nodeList = new ArrayList<>();
    ArrayList<Edge> edgeList = new ArrayList<>();

    @Override
    public Map<String, Object> visitStatExpr(GraphxGrammarParser.StatExprContext ctx) {
        for (GraphxGrammarParser.ExprContext expr : ctx.expr()) {
            visit(expr);
        }
        Map<String, Object> res = new HashMap<>();
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
        Node res = new Node();
        res.setId(id);
        res.setText(id);
        nodeList.add(res);
        return res;
    }

    public void connectNode() {

    }


}
