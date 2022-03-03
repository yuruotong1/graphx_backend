package com.dongle.graphx.utils;

public class GraphvizDot {
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
