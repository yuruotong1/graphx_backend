package com.dongle.graphx.antlr.code;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestGraphxGrammar {
    @Test
    public void TestParse() {
//        String a = "ooo-->ccc-->d\nccc-->ddd";
//        CharStream codePointCharStream = CharStreams.fromString(a);
//        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
//        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
//        GraphxGrammarParser.StatContext tree = parser.stat();
//        GraphxVisitor eval = new GraphxVisitor(new JSONArray());
//        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) eval.visit(tree);

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
