// Generated from D:/develop/project/java/graphx/src/main/java/com/dongle/graphx/antlr\GraphxGrammar.g4 by ANTLR 4.9.2

package com.dongle.graphx.antlr.code;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GraphxGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface GraphxGrammarVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#stat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat(GraphxGrammarParser.StatContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(GraphxGrammarParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#structDefile}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStructDefile(GraphxGrammarParser.StructDefileContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#structBody}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStructBody(GraphxGrammarParser.StructBodyContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#lineExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLineExpression(GraphxGrammarParser.LineExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#lineStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLineStatement(GraphxGrammarParser.LineStatementContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#lineText}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLineText(GraphxGrammarParser.LineTextContext ctx);

    /**
     * Visit a parse tree produced by {@link GraphxGrammarParser#nodeId}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNodeId(GraphxGrammarParser.NodeIdContext ctx);
}