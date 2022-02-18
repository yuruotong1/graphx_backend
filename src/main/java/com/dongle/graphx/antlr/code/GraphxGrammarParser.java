// Generated from D:/develop/project/java/graphx/src/main/java/com/dongle/graphx/antlr\GraphxGrammar.g4 by ANTLR 4.9.2

package com.dongle.graphx.antlr.code;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GraphxGrammarParser extends Parser {
	public static final int
			STRING = 1, LINE = 2, ARROW = 3, COLON = 4, NEWLINE = 5, WS = 6;
	public static final int
			RULE_stat = 0, RULE_expr = 1, RULE_line = 2;
	public static final String[] ruleNames = makeRuleNames();
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b<\4\2\t\2\4\3\t" +
					"\3\4\4\t\4\3\2\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\2\7\2\21\n\2\f\2\16\2\24" +
					"\13\2\3\2\7\2\27\n\2\f\2\16\2\32\13\2\3\2\6\2\35\n\2\r\2\16\2\36\5\2!" +
					"\n\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\3\4\3\4\3" +
					"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\4\2\2\5\2\4\6\2\2\2B\2 \3\2" +
					"\2\2\4\"\3\2\2\2\69\3\2\2\2\b!\7\3\2\2\t\22\5\4\3\2\n\f\7\7\2\2\13\n\3" +
					"\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\17\3\2\2\2\17\21\5\4\3" +
					"\2\20\13\3\2\2\2\21\24\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\30\3\2\2" +
					"\2\24\22\3\2\2\2\25\27\7\7\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2" +
					"\2\30\31\3\2\2\2\31!\3\2\2\2\32\30\3\2\2\2\33\35\7\7\2\2\34\33\3\2\2\2" +
					"\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \b\3\2\2\2 \t\3" +
					"\2\2\2 \34\3\2\2\2!\3\3\2\2\2\"#\7\3\2\2#$\5\6\4\2$*\7\3\2\2%&\5\6\4\2" +
					"&\'\7\3\2\2\')\3\2\2\2(%\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\5\3\2" +
					"\2\2,*\3\2\2\2-.\7\4\2\2.:\7\4\2\2/\60\7\4\2\2\60\61\7\3\2\2\61:\7\4\2" +
					"\2\62\63\7\4\2\2\63\64\7\4\2\2\64:\7\5\2\2\65\66\7\4\2\2\66\67\7\3\2\2" +
					"\678\7\4\2\28:\7\5\2\29-\3\2\2\29/\3\2\2\29\62\3\2\2\29\65\3\2\2\2:\7" +
					"\3\2\2\2\t\r\22\30\36 *9";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	static {
		RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
	}

	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}

	public GraphxGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{
				"stat", "expr", "line"
		};
	}

	private static String[] makeLiteralNames() {
		return new String[]{
				null, null, "'-'", "'>'", "':'"
		};
	}

	private static String[] makeSymbolicNames() {
		return new String[]{
				null, "STRING", "LINE", "ARROW", "COLON", "NEWLINE", "WS"
		};
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() {
		return "GraphxGrammar.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(30);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
				case 1:
					_localctx = new NodeContext(_localctx);
					enterOuterAlt(_localctx, 1);
				{
					setState(6);
					match(STRING);
				}
				break;
				case 2:
					_localctx = new StatExprContext(_localctx);
					enterOuterAlt(_localctx, 2);
				{
					setState(7);
					expr();
					setState(16);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
					while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
						if (_alt == 1) {
							{
								{
									setState(9);
									_errHandler.sync(this);
									_la = _input.LA(1);
									do {
										{
											{
												setState(8);
												match(NEWLINE);
											}
										}
										setState(11);
										_errHandler.sync(this);
										_la = _input.LA(1);
									} while (_la == NEWLINE);
									setState(13);
									expr();
								}
							}
						}
						setState(18);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
					}
					setState(22);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == NEWLINE) {
						{
							{
								setState(19);
								match(NEWLINE);
							}
						}
						setState(24);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
				break;
				case 3:
					_localctx = new StatNewLineContext(_localctx);
					enterOuterAlt(_localctx, 3);
				{
					setState(26);
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
							{
								setState(25);
								match(NEWLINE);
							}
						}
						setState(28);
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while (_la == NEWLINE);
				}
				break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(32);
				match(STRING);
				setState(33);
				line();
				setState(34);
				match(STRING);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == LINE) {
					{
						{
							setState(35);
							line();
							setState(36);
							match(STRING);
						}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
				case 1:
					_localctx = new LineLineContext(_localctx);
					enterOuterAlt(_localctx, 1);
				{
					setState(43);
					match(LINE);
					setState(44);
					match(LINE);
				}
				break;
				case 2:
					_localctx = new LineStringLineContext(_localctx);
					enterOuterAlt(_localctx, 2);
				{
					setState(45);
					match(LINE);
					setState(46);
					match(STRING);
					setState(47);
					match(LINE);
				}
				break;
				case 3:
					_localctx = new LineLineArrowContext(_localctx);
					enterOuterAlt(_localctx, 3);
				{
					setState(48);
					match(LINE);
					setState(49);
					match(LINE);
					setState(50);
					match(ARROW);
				}
				break;
				case 4:
					_localctx = new LineStringLineArrowContext(_localctx);
					enterOuterAlt(_localctx, 4);
				{
					setState(51);
					match(LINE);
					setState(52);
					match(STRING);
					setState(53);
					match(LINE);
					setState(54);
					match(ARROW);
				}
				break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public StatContext() {
		}

		@Override
		public int getRuleIndex() {
			return RULE_stat;
		}

		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class NodeContext extends StatContext {
		public NodeContext(StatContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode STRING() {
			return getToken(GraphxGrammarParser.STRING, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterNode(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitNode(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class StatExprContext extends StatContext {
		public StatExprContext(StatContext ctx) {
			copyFrom(ctx);
		}

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public List<TerminalNode> NEWLINE() {
			return getTokens(GraphxGrammarParser.NEWLINE);
		}

		public TerminalNode NEWLINE(int i) {
			return getToken(GraphxGrammarParser.NEWLINE, i);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterStatExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitStatExpr(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitStatExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class StatNewLineContext extends StatContext {
		public StatNewLineContext(StatContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> NEWLINE() {
			return getTokens(GraphxGrammarParser.NEWLINE);
		}

		public TerminalNode NEWLINE(int i) {
			return getToken(GraphxGrammarParser.NEWLINE, i);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterStatNewLine(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitStatNewLine(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitStatNewLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<TerminalNode> STRING() {
			return getTokens(GraphxGrammarParser.STRING);
		}

		public TerminalNode STRING(int i) {
			return getToken(GraphxGrammarParser.STRING, i);
		}

		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i) {
			return getRuleContext(LineContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitExpr(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public LineContext() {
		}

		@Override
		public int getRuleIndex() {
			return RULE_line;
		}

		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class LineStringLineContext extends LineContext {
		public LineStringLineContext(LineContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> LINE() {
			return getTokens(GraphxGrammarParser.LINE);
		}

		public TerminalNode LINE(int i) {
			return getToken(GraphxGrammarParser.LINE, i);
		}

		public TerminalNode STRING() {
			return getToken(GraphxGrammarParser.STRING, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterLineStringLine(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitLineStringLine(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineStringLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LineStringLineArrowContext extends LineContext {
		public LineStringLineArrowContext(LineContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> LINE() {
			return getTokens(GraphxGrammarParser.LINE);
		}

		public TerminalNode LINE(int i) {
			return getToken(GraphxGrammarParser.LINE, i);
		}

		public TerminalNode STRING() {
			return getToken(GraphxGrammarParser.STRING, 0);
		}

		public TerminalNode ARROW() {
			return getToken(GraphxGrammarParser.ARROW, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener)
				((GraphxGrammarListener) listener).enterLineStringLineArrow(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener)
				((GraphxGrammarListener) listener).exitLineStringLineArrow(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineStringLineArrow(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LineLineContext extends LineContext {
		public LineLineContext(LineContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> LINE() {
			return getTokens(GraphxGrammarParser.LINE);
		}

		public TerminalNode LINE(int i) {
			return getToken(GraphxGrammarParser.LINE, i);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterLineLine(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitLineLine(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LineLineArrowContext extends LineContext {
		public LineLineArrowContext(LineContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> LINE() {
			return getTokens(GraphxGrammarParser.LINE);
		}

		public TerminalNode LINE(int i) {
			return getToken(GraphxGrammarParser.LINE, i);
		}

		public TerminalNode ARROW() {
			return getToken(GraphxGrammarParser.ARROW, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterLineLineArrow(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitLineLineArrow(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GraphxGrammarVisitor)
				return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineLineArrow(this);
			else return visitor.visitChildren(this);
		}
	}
}