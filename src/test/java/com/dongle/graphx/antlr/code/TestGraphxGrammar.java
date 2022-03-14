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

    public List<Node> TestParseCreateSimpleDotNodeData(){
        Node nodeOOO= new Node();
        nodeOOO.setId("ooo");
        nodeOOO.setAvatar("https://iconsapi.com/5ee262cde4b0b788a932ab9f.svg");
        nodeOOO.setText("ooo");
        nodeOOO.setSearchPictureName("ooo");
        Node nodeCCC= new Node();
        nodeCCC.setId("ccc");
        nodeCCC.setAvatar("https://iconsapi.com/5ee26511e4b0b788a9330a04.svg");
        nodeCCC.setText("ccc");
        nodeCCC.setSearchPictureName("ccc");
        List<Node> expectNodeList = new ArrayList<>();
        expectNodeList.add(nodeOOO);
        expectNodeList.add(nodeCCC);
        return expectNodeList;
    }

    public String TestParseCreateSimpleDotDotData(){
        return "digraph G {\n" +
                " charset=\"UTF-8\" rankdir=\"LR\"\n" +
                " \"ooo\" [shape=\"none\", label=<<TABLE BORDER=\"0\" >\n" +
                "<TR><TD PORT=\"f1\" FIXEDSIZE=\"TRUE\" WIDTH=\"75\" HEIGHT=\"75\"><IMG  SRC=\"C:\\Users\\yuruo\\AppData\\Local\\Temp\\graphxTemp\\7bddc93e-252f-4615-8a4c-93c5aabe2f20\\tmp7115898769623486283.png\"/></TD></TR>\n" +
                "<TR><TD>ooo</TD></TR>\n" +
                "</TABLE>> fontname=\"simfang\"]\n" +
                "\n" +
                "\"ccc\" [shape=\"none\", label=<<TABLE BORDER=\"0\" >\n" +
                "<TR><TD PORT=\"f1\" FIXEDSIZE=\"TRUE\" WIDTH=\"75\" HEIGHT=\"75\"><IMG  SRC=\"C:\\Users\\yuruo\\AppData\\Local\\Temp\\graphxTemp\\7bddc93e-252f-4615-8a4c-93c5aabe2f20\\tmp5073014957256688350.png\"/></TD></TR>\n" +
                "<TR><TD>ccc</TD></TR>\n" +
                "</TABLE>> fontname=\"simfang\"]\n" +
                "\n" +
                "\"ooo\" -> \"ccc\" [arrowhead=\"normal\" label=\"abc\" fontname=\"simfang\"]\n" +
                "\n" +
                "\n" +
                " \n" +
                "}";
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
        for(int i =0; i<nodeList.size(); i++) {
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
    public void TestGraphviz() {

//        Graphviz.useEngine(new GraphvizCmdLineEngine());
////        Graphviz.useEngine(new GraphvizV8Engine());
////        File file = convertHttpSvg2Png("https://iconsapi.com/5ee261ede4b0b788a932a2eb.svg");
//        assert file != null;
//        final String url = file.getAbsolutePath();
//        System.out.println(url);
//
//        final Graphviz g = Graphviz.fromGraph(graph().with(
//                node(Label.of("hello")).with(Shape.NONE, Label.html("<TABLE BORDER=\"0\" >\n" +
//                                "                                       <TR><TD FIXEDSIZE=\"TRUE\" WIDTH=\"75\" HEIGHT=\"75\"><IMG  SRC=\"D:/develop/project/java/graphx/tmp.png\"/></TD></TR>\n" +
//                                "                                       <TR><TD>caption</TD></TR>\n" +
//                                "                                     </TABLE>"))
//                        .link(to(node(Label.of("xxxccc")).with(Shape.NONE)).with(Arrow.NONE))));
//        final File out = new File("img-http.png");
//        try {
//            g.render(Format.PNG).toFile(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
////            boolean res = file.delete();
//        }
    }
}
