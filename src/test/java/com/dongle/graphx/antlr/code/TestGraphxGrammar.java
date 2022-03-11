package com.dongle.graphx.antlr.code;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongle.graphx.antlr.GraphxVisitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedHashMap;


@SpringBootTest
public class TestGraphxGrammar {
    @Test
    public void TestParse() {
        String a = "ooo-abc->ccc-->d\nccc-->ddd";
        CharStream codePointCharStream = CharStreams.fromString(a);
        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
        GraphxGrammarParser.StatContext tree = parser.stat();
        GraphxVisitor eval = new GraphxVisitor(new JSONArray());
        eval.visit(tree);
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
