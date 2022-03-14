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
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, Identifier = 3, Line = 4, Arrow = 5, WS = 6;
    public static final int
            RULE_stat = 0, RULE_statement = 1, RULE_structDefile = 2, RULE_structBody = 3,
            RULE_lineExpression = 4, RULE_lineStatement = 5, RULE_lineText = 6, RULE_nodeId = 7;

    private static String[] makeRuleNames() {
        return new String[]{
                "stat", "statement", "structDefile", "structBody", "lineExpression",
                "lineStatement", "lineText", "nodeId"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'{'", "'}'", null, "'-'", "'>'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, "Identifier", "Line", "Arrow", "WS"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

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

    public GraphxGrammarParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class StatContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(GraphxGrammarParser.EOF, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public StatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterStat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitStat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitStat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatContext stat() throws RecognitionException {
        StatContext _localctx = new StatContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_stat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(19);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Identifier) {
                    {
                        {
                            setState(16);
                            statement();
                        }
                    }
                    setState(21);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(22);
                match(EOF);
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

    public static class StatementContext extends ParserRuleContext {
        public StructDefileContext structDefile() {
            return getRuleContext(StructDefileContext.class, 0);
        }

        public LineExpressionContext lineExpression() {
            return getRuleContext(LineExpressionContext.class, 0);
        }

        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statement);
        try {
            setState(26);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(24);
                    structDefile();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(25);
                    lineExpression();
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

    public static class StructDefileContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(GraphxGrammarParser.Identifier, 0);
        }

        public StructBodyContext structBody() {
            return getRuleContext(StructBodyContext.class, 0);
        }

        public StructDefileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structDefile;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterStructDefile(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitStructDefile(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitStructDefile(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StructDefileContext structDefile() throws RecognitionException {
        StructDefileContext _localctx = new StructDefileContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_structDefile);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(28);
                match(Identifier);
                setState(29);
                structBody();
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

    public static class StructBodyContext extends ParserRuleContext {
        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public StructBodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structBody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterStructBody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitStructBody(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitStructBody(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StructBodyContext structBody() throws RecognitionException {
        StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_structBody);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                match(T__0);
                setState(35);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Identifier) {
                    {
                        {
                            setState(32);
                            statement();
                        }
                    }
                    setState(37);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(38);
                match(T__1);
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

    public static class LineExpressionContext extends ParserRuleContext {
        public List<NodeIdContext> nodeId() {
            return getRuleContexts(NodeIdContext.class);
        }

        public NodeIdContext nodeId(int i) {
            return getRuleContext(NodeIdContext.class, i);
        }

        public List<LineStatementContext> lineStatement() {
            return getRuleContexts(LineStatementContext.class);
        }

        public LineStatementContext lineStatement(int i) {
            return getRuleContext(LineStatementContext.class, i);
        }

        public LineExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lineExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterLineExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitLineExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LineExpressionContext lineExpression() throws RecognitionException {
        LineExpressionContext _localctx = new LineExpressionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_lineExpression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(40);
                nodeId();
                setState(46);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Line) {
                    {
                        {
                            setState(41);
                            lineStatement();
                            setState(42);
                            nodeId();
                        }
                    }
                    setState(48);
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

    public static class LineStatementContext extends ParserRuleContext {
        public List<TerminalNode> Line() {
            return getTokens(GraphxGrammarParser.Line);
        }

        public TerminalNode Line(int i) {
            return getToken(GraphxGrammarParser.Line, i);
        }

        public LineTextContext lineText() {
            return getRuleContext(LineTextContext.class, 0);
        }

        public TerminalNode Arrow() {
            return getToken(GraphxGrammarParser.Arrow, 0);
        }

        public LineStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lineStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterLineStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitLineStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LineStatementContext lineStatement() throws RecognitionException {
        LineStatementContext _localctx = new LineStatementContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_lineStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                match(Line);
                setState(51);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Identifier) {
                    {
                        setState(50);
                        lineText();
                    }
                }

                setState(53);
                match(Line);
                setState(55);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Arrow) {
                    {
                        setState(54);
                        match(Arrow);
                    }
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

    public static class LineTextContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(GraphxGrammarParser.Identifier, 0);
        }

        public LineTextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lineText;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterLineText(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitLineText(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitLineText(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LineTextContext lineText() throws RecognitionException {
        LineTextContext _localctx = new LineTextContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_lineText);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(57);
                match(Identifier);
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

    public static class NodeIdContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(GraphxGrammarParser.Identifier, 0);
        }

        public NodeIdContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nodeId;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).enterNodeId(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphxGrammarListener) ((GraphxGrammarListener) listener).exitNodeId(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GraphxGrammarVisitor)
                return ((GraphxGrammarVisitor<? extends T>) visitor).visitNodeId(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NodeIdContext nodeId() throws RecognitionException {
        NodeIdContext _localctx = new NodeIdContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_nodeId);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(59);
                match(Identifier);
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

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b@\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2" +
                    "\16\2\27\13\2\3\2\3\2\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\5\3\5\7\5$\n\5" +
                    "\f\5\16\5\'\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6/\n\6\f\6\16\6\62\13\6\3\7" +
                    "\3\7\5\7\66\n\7\3\7\3\7\5\7:\n\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f" +
                    "\16\20\2\2\2=\2\25\3\2\2\2\4\34\3\2\2\2\6\36\3\2\2\2\b!\3\2\2\2\n*\3\2" +
                    "\2\2\f\63\3\2\2\2\16;\3\2\2\2\20=\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2" +
                    "\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2" +
                    "\30\31\7\2\2\3\31\3\3\2\2\2\32\35\5\6\4\2\33\35\5\n\6\2\34\32\3\2\2\2" +
                    "\34\33\3\2\2\2\35\5\3\2\2\2\36\37\7\5\2\2\37 \5\b\5\2 \7\3\2\2\2!%\7\3" +
                    "\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'" +
                    "%\3\2\2\2()\7\4\2\2)\t\3\2\2\2*\60\5\20\t\2+,\5\f\7\2,-\5\20\t\2-/\3\2" +
                    "\2\2.+\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\13\3\2\2\2\62" +
                    "\60\3\2\2\2\63\65\7\6\2\2\64\66\5\16\b\2\65\64\3\2\2\2\65\66\3\2\2\2\66" +
                    "\67\3\2\2\2\679\7\6\2\28:\7\7\2\298\3\2\2\29:\3\2\2\2:\r\3\2\2\2;<\7\5" +
                    "\2\2<\17\3\2\2\2=>\7\5\2\2>\21\3\2\2\2\b\25\34%\60\659";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}