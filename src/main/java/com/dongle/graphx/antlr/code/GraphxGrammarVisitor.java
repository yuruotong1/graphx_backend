// Generated from D:/develop/project/java/graphx/src/main/java/com/dongle/graphx/antlr\GraphxGrammar.g4 by ANTLR 4.9.2

package com.dongle.graphx.antlr.code;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GraphxGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GraphxGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GraphxGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(GraphxGrammarParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link GraphxGrammarParser#lineExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(GraphxGrammarParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression}
	 * labeled alternative in {@link GraphxGrammarParser#lineExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GraphxGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphxGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GraphxGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphxGrammarParser#structDefile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefile(GraphxGrammarParser.StructDefileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphxGrammarParser#structBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructBody(GraphxGrammarParser.StructBodyContext ctx);
}