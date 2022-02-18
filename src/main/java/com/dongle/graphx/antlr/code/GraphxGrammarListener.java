// Generated from D:/develop/project/java/graphx/src/main/java/com/dongle/graphx/antlr\GraphxGrammar.g4 by ANTLR 4.9.2

package com.dongle.graphx.antlr.code;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphxGrammarParser}.
 */
public interface GraphxGrammarListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by the {@code node}
     * labeled alternative in {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void enterNode(GraphxGrammarParser.NodeContext ctx);

    /**
     * Exit a parse tree produced by the {@code node}
     * labeled alternative in {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void exitNode(GraphxGrammarParser.NodeContext ctx);

    /**
     * Enter a parse tree produced by the {@code statExpr}
     * labeled alternative in {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void enterStatExpr(GraphxGrammarParser.StatExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code statExpr}
     * labeled alternative in {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void exitStatExpr(GraphxGrammarParser.StatExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code statNewLine}
     * labeled alternative in {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void enterStatNewLine(GraphxGrammarParser.StatNewLineContext ctx);

    /**
     * Exit a parse tree produced by the {@code statNewLine}
     * labeled alternative in {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void exitStatNewLine(GraphxGrammarParser.StatNewLineContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExpr(GraphxGrammarParser.ExprContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExpr(GraphxGrammarParser.ExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code lineLine}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLineLine(GraphxGrammarParser.LineLineContext ctx);

    /**
     * Exit a parse tree produced by the {@code lineLine}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLineLine(GraphxGrammarParser.LineLineContext ctx);

    /**
     * Enter a parse tree produced by the {@code lineStringLine}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLineStringLine(GraphxGrammarParser.LineStringLineContext ctx);

    /**
     * Exit a parse tree produced by the {@code lineStringLine}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLineStringLine(GraphxGrammarParser.LineStringLineContext ctx);

    /**
     * Enter a parse tree produced by the {@code lineLineArrow}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLineLineArrow(GraphxGrammarParser.LineLineArrowContext ctx);

    /**
     * Exit a parse tree produced by the {@code lineLineArrow}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLineLineArrow(GraphxGrammarParser.LineLineArrowContext ctx);

    /**
     * Enter a parse tree produced by the {@code lineStringLineArrow}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLineStringLineArrow(GraphxGrammarParser.LineStringLineArrowContext ctx);

    /**
     * Exit a parse tree produced by the {@code lineStringLineArrow}
     * labeled alternative in {@link GraphxGrammarParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLineStringLineArrow(GraphxGrammarParser.LineStringLineArrowContext ctx);
}