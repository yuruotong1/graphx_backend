package com.dongle.graphx.utils;

import com.dongle.graphx.Domain.Edge;
import com.dongle.graphx.Domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

import static com.dongle.graphx.utils.ConvertSvg2Png.convertHttpSvg2Png;

public class GraphvizDot {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphvizDot.class);
    String base = "digraph G {\n charset=\"UTF-8\" rankdir=\"LR\"\n %s\n}";
    ArrayList<String> statements;
    File tempDir;

    public GraphvizDot(File tempDir) {
        this.tempDir = tempDir;
        statements = new ArrayList<>();
    }

    public void addStatement(String statement) {
        statements.add(statement);
    }

    public String getDot() {
        return String.format(base, String.join("\n", statements));
    }

    public String generateImg() {
        File file = TempFile.createFile(tempDir, "tmp.dot", getDot());
        String outPath = tempDir.getPath() + "/outfile.png";
        String command = "dot -Kdot -Tpng " + file.getAbsolutePath() + " -o " + outPath;
        Command.run(command);
        LogUtil.info(LOGGER, "Run command", command);
        return outPath;
    }

    public byte[] getPngBytes(){
        String imgPath = generateImg();
        try {
            FileInputStream fileInputStream = new FileInputStream(imgPath);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len;
            while((len = fileInputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, len);
            }
            byte[] res = byteArrayOutputStream.toByteArray();
            fileInputStream.close();
            return res;
        } catch (IOException e) {
            LogUtil.error(LOGGER, e);
        }
        return null;
    }

    public String getBase64() {
        return Base64.getEncoder().encodeToString(getPngBytes());
    }


    public String createNode(Node node) {
        File file = convertHttpSvg2Png(node.getAvatar(), tempDir);
        assert file != null;
        return getName(node.getId()) + " [shape=\"none\", label=<<TABLE BORDER=\"0\" >\n" +
                "<TR><TD PORT=\"f1\" FIXEDSIZE=\"TRUE\" WIDTH=\"75\" HEIGHT=\"75\"><IMG  SRC=\"" + file.getAbsolutePath() + "\"/></TD></TR>\n" +
                "<TR><TD>" + handleSymbol(node.getText()) + "</TD></TR>\n" +
                "</TABLE>> fontname=\"" + Constant.FONT_SIM_FANG + "\"]\n";
    }

    public String createStruct(String structName, String structBody) {
        return String.format("subgraph cluster_%s {\n label=%s; \n%s \n}\n", structName,structName, structBody);

    }

    public String createEdge(Edge edge) {
        return GraphvizDot.getName(edge.getSourceNode().getId()) + " -> " + GraphvizDot.getName(edge.getTargetNode().getId()) +
                String.format(" [arrowhead=\"%s\" label=\"%s\" fontname=\"" + Constant.FONT_SIM_FANG + "\"]\n", edge.getType(), edge.getText());
    }

    public static String getName(String name) {
        name = handleSymbol(name);
        return String.format("\"%s\"", name);
    }

    /*
     * 处理转义符号
     * */
    public static String handleSymbol(String str) {
        return str.replaceAll("\\\\-", "-")
                .replaceAll("\\\\>", "&gt;");
    }

}
