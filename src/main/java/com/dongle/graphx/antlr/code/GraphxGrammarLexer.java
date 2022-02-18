// Generated from D:/develop/project/java/graphx/src/main/java/com/dongle/graphx/antlr\GraphxGrammar.g4 by ANTLR 4.9.2

package com.dongle.graphx.antlr.code;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GraphxGrammarLexer extends Lexer {
	public static final int
			STRING = 1, LINE = 2, ARROW = 3, COLON = 4, NEWLINE = 5, WS = 6;
	public static final String[] ruleNames = makeRuleNames();
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b&\b\1\4\2\t\2\4" +
					"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\21\n\2\r\2\16\2\22\3\3" +
					"\3\3\3\4\3\4\3\5\3\5\3\6\5\6\34\n\6\3\6\3\6\3\7\6\7!\n\7\r\7\16\7\"\3" +
					"\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\4\7\2\62;C\\aac|\u4e02\u9fa7" +
					"\4\2\13\13\"\"\2(\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13" +
					"\3\2\2\2\2\r\3\2\2\2\3\20\3\2\2\2\5\24\3\2\2\2\7\26\3\2\2\2\t\30\3\2\2" +
					"\2\13\33\3\2\2\2\r \3\2\2\2\17\21\t\2\2\2\20\17\3\2\2\2\21\22\3\2\2\2" +
					"\22\20\3\2\2\2\22\23\3\2\2\2\23\4\3\2\2\2\24\25\7/\2\2\25\6\3\2\2\2\26" +
					"\27\7@\2\2\27\b\3\2\2\2\30\31\7<\2\2\31\n\3\2\2\2\32\34\7\17\2\2\33\32" +
					"\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\f\2\2\36\f\3\2\2\2\37!\t" +
					"\3\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\b\7\2" +
					"\2%\16\3\2\2\2\6\2\22\33\"\3\b\2\2";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
	public static String[] channelNames = {
			"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};
	public static String[] modeNames = {
			"DEFAULT_MODE"
	};

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

	public GraphxGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{
				"STRING", "LINE", "ARROW", "COLON", "NEWLINE", "WS"
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
	public String[] getChannelNames() {
		return channelNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}
}