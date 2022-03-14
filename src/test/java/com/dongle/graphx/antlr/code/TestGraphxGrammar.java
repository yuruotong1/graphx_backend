package com.dongle.graphx.antlr.code;

import com.alibaba.fastjson.JSONArray;
import com.dongle.graphx.Domain.Node;
import com.dongle.graphx.antlr.GraphxVisitor;
import com.dongle.graphx.utils.Constant;
import com.dongle.graphx.utils.GraphvizDot;
import com.dongle.graphx.utils.TempFile;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class TestGraphxGrammar {
    static File tempDir;

    @BeforeEach
    public void before() {
        tempDir = TempFile.createDir();
    }

    @AfterEach
    public void after() {
        TempFile.deleteDir(tempDir);
    }

    public List<Node> TestParseCreateSimpleDotNodeData() {
        Node nodeOOO = new Node();
        nodeOOO.setId("ooo");
        nodeOOO.setAvatar("https://iconsapi.com/5ee262cde4b0b788a932ab9f.svg");
        nodeOOO.setText("ooo");
        nodeOOO.setSearchPictureName("ooo");
        Node nodeCCC = new Node();
        nodeCCC.setId("ccc");
        nodeCCC.setAvatar("https://iconsapi.com/5ee26511e4b0b788a9330a04.svg");
        nodeCCC.setText("ccc");
        nodeCCC.setSearchPictureName("ccc");
        List<Node> expectNodeList = new ArrayList<>();
        expectNodeList.add(nodeOOO);
        expectNodeList.add(nodeCCC);
        return expectNodeList;
    }

    @Test
    public void TestParseCreateSimpleDot() {
        String a = "ooo-abc->ccc";
        CharStream codePointCharStream = CharStreams.fromString(a);
        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
        GraphxGrammarParser.StatContext tree = parser.stat();
        GraphvizDot graphvizDot = new GraphvizDot(tempDir);
        GraphxVisitor eval = new GraphxVisitor(new JSONArray(), graphvizDot);
        List<Node> expectNodeList = TestParseCreateSimpleDotNodeData();
        Map<?, ?> res = (Map<?, ?>) eval.visit(tree);
        List<?> nodeList = (List<?>) res.get(Constant.NODE_LIST);
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = (Node) nodeList.get(i);
            assert node.equals(expectNodeList.get(i));
        }

    }

    @Test
    public void TestParse() {
        String a = "ooo-abc->ccc-->d\nccc--ddd";
        CharStream codePointCharStream = CharStreams.fromString(a);
        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
        GraphxGrammarParser.StatContext tree = parser.stat();
        GraphvizDot graphvizDot = new GraphvizDot(tempDir);
        GraphxVisitor eval = new GraphxVisitor(new JSONArray(), graphvizDot);
        Map<?, ?> res = (Map<?, ?>) eval.visit(tree);
        List<?> nodeList = (List<?>) res.get(Constant.NODE_LIST);
        for (Object nodeObj : nodeList) {
            Node node = (Node) nodeObj;
        }
    }


    @Test
    public void TestParseStruct() {
        String a = "l--d\nc{d--f}";
        CharStream codePointCharStream = CharStreams.fromString(a);
        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
        GraphxGrammarParser.StatContext tree = parser.stat();
        GraphvizDot graphvizDot = new GraphvizDot(tempDir);
        GraphxVisitor eval = new GraphxVisitor(new JSONArray(), graphvizDot);
        Map<?, ?> res = (Map<?, ?>) eval.visit(tree);

        List<?> nodeList = (List<?>) res.get(Constant.NODE_LIST);
    }
}

