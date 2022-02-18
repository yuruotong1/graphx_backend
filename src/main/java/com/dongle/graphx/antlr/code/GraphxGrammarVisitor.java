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
	 * Visit a parse tree produced by the {@code node}
	 * labeled alternative in {@link GraphxGrammarParser#stat}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(GraphxGrammarParser.NodeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link GraphxGrammarParser#stat}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExpr(GraphxGrammarParser.StatExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code statNewLine}
	 * labeled alternative in {@link GraphxGrammarParser#stat}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatNewLine(GraphxGrammarParser.StatNewLineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GraphxGrammarParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GraphxGrammarParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code lineLine}
	 * labeled alternative in {@link GraphxGrammarParser#line}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineLine(GraphxGrammarParser.LineLineContext ctx);

	/**
	 * Visit a parse tree produced by the {@code lineStringLine}
	 * labeled alternative in {@link GraphxGrammarParser#line}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringLine(GraphxGrammarParser.LineStringLineContext ctx);

	/**
	 * Visit a parse tree produced by the {@code lineLineArrow}
	 * labeled alternative in {@link GraphxGrammarParser#line}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineLineArrow(GraphxGrammarParser.LineLineArrowContext ctx);

	/**
	 * Visit a parse tree produced by the {@code lineStringLineArrow}
	 * labeled alternative in {@link GraphxGrammarParser#line}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringLineArrow(GraphxGrammarParser.LineStringLineArrowContext ctx);
}