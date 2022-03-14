// Generated from D:/develop/project/java/graphx/src/main/java/com/dongle/graphx/antlr\GraphxGrammar.g4 by ANTLR 4.9.2

package com.dongle.graphx.antlr.code;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphxGrammarParser}.
 */
public interface GraphxGrammarListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void enterStat(GraphxGrammarParser.StatContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     */
    void exitStat(GraphxGrammarParser.StatContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(GraphxGrammarParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(GraphxGrammarParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#structDefile}.
     *
     * @param ctx the parse tree
     */
    void enterStructDefile(GraphxGrammarParser.StructDefileContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#structDefile}.
     *
     * @param ctx the parse tree
     */
    void exitStructDefile(GraphxGrammarParser.StructDefileContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#structBody}.
     *
     * @param ctx the parse tree
     */
    void enterStructBody(GraphxGrammarParser.StructBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#structBody}.
     *
     * @param ctx the parse tree
     */
    void exitStructBody(GraphxGrammarParser.StructBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#lineExpression}.
     *
     * @param ctx the parse tree
     */
    void enterLineExpression(GraphxGrammarParser.LineExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#lineExpression}.
     *
     * @param ctx the parse tree
     */
    void exitLineExpression(GraphxGrammarParser.LineExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#lineStatement}.
     *
     * @param ctx the parse tree
     */
    void enterLineStatement(GraphxGrammarParser.LineStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#lineStatement}.
     *
     * @param ctx the parse tree
     */
    void exitLineStatement(GraphxGrammarParser.LineStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#lineText}.
     *
     * @param ctx the parse tree
     */
    void enterLineText(GraphxGrammarParser.LineTextContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#lineText}.
     *
     * @param ctx the parse tree
     */
    void exitLineText(GraphxGrammarParser.LineTextContext ctx);

    /**
     * Enter a parse tree produced by {@link GraphxGrammarParser#nodeId}.
     *
     * @param ctx the parse tree
     */
    void enterNodeId(GraphxGrammarParser.NodeIdContext ctx);

    /**
     * Exit a parse tree produced by {@link GraphxGrammarParser#nodeId}.
     *
     * @param ctx the parse tree
     */
    void exitNodeId(GraphxGrammarParser.NodeIdContext ctx);
}