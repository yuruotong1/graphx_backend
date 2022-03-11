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
	 * @param ctx the parse tree
	 */
	void enterStat(GraphxGrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphxGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(GraphxGrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link GraphxGrammarParser#lineExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(GraphxGrammarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link GraphxGrammarParser#lineExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(GraphxGrammarParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression}
	 * labeled alternative in {@link GraphxGrammarParser#lineExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GraphxGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression}
	 * labeled alternative in {@link GraphxGrammarParser#lineExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GraphxGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphxGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GraphxGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphxGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GraphxGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphxGrammarParser#structDefile}.
	 * @param ctx the parse tree
	 */
	void enterStructDefile(GraphxGrammarParser.StructDefileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphxGrammarParser#structDefile}.
	 * @param ctx the parse tree
	 */
	void exitStructDefile(GraphxGrammarParser.StructDefileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphxGrammarParser#structBody}.
	 * @param ctx the parse tree
	 */
	void enterStructBody(GraphxGrammarParser.StructBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphxGrammarParser#structBody}.
	 * @param ctx the parse tree
	 */
	void exitStructBody(GraphxGrammarParser.StructBodyContext ctx);
}