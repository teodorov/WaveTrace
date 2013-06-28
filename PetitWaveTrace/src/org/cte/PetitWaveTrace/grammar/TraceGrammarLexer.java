// Generated from TraceGrammar.g4 by ANTLR 4.0
package org.cte.PetitWaveTrace.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TraceGrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CHANNELS=1, VIOLATEDASSERTS=2, NONE=3, TRUE=4, FALSE=5, LCURLY=6, RCURLY=7, 
		LSQUARE=8, RSQUARE=9, LPAREN=10, RPAREN=11, TICK=12, EQ=13, COMMA=14, 
		AT=15, MINUS=16, DQUOTE=17, COLON=18, TransitionDetail=19, Number=20, 
		Identifier=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'Channels'", "'Violated asserts:'", "'none'", "'true'", "'false'", "'{'", 
		"'}'", "'['", "']'", "'('", "')'", "'''", "'='", "','", "'@'", "'-'", 
		"'\"'", "':'", "TransitionDetail", "Number", "Identifier", "WS"
	};
	public static final String[] ruleNames = {
		"CHANNELS", "VIOLATEDASSERTS", "NONE", "TRUE", "FALSE", "LCURLY", "RCURLY", 
		"LSQUARE", "RSQUARE", "LPAREN", "RPAREN", "TICK", "EQ", "COMMA", "AT", 
		"MINUS", "DQUOTE", "COLON", "TransitionDetail", "Number", "Identifier", 
		"WS"
	};


	public TraceGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TraceGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 21: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\30\u0093\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\7\24w\n\24\f\24\16\24z\13\24\3\24\3\24\3\25"+
		"\5\25\177\n\25\3\25\6\25\u0082\n\25\r\25\16\25\u0083\3\26\3\26\7\26\u0088"+
		"\n\26\f\26\16\26\u008b\13\26\3\27\6\27\u008e\n\27\r\27\16\27\u008f\3\27"+
		"\3\27\3x\30\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1"+
		"\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\1)\26\1+\27\1-\30\2\3\2\7\4--//\3\62;\4C\\c|\7//\62;C\\aac|\5\13\f\17"+
		"\17\"\"\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\3/\3\2\2\2\58\3\2\2\2\7J\3\2\2\2\tO\3\2\2\2\13T\3\2\2\2\rZ\3\2\2\2"+
		"\17\\\3\2\2\2\21^\3\2\2\2\23`\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31f\3\2"+
		"\2\2\33h\3\2\2\2\35j\3\2\2\2\37l\3\2\2\2!n\3\2\2\2#p\3\2\2\2%r\3\2\2\2"+
		"\'t\3\2\2\2)~\3\2\2\2+\u0085\3\2\2\2-\u008d\3\2\2\2/\60\7E\2\2\60\61\7"+
		"j\2\2\61\62\7c\2\2\62\63\7p\2\2\63\64\7p\2\2\64\65\7g\2\2\65\66\7n\2\2"+
		"\66\67\7u\2\2\67\4\3\2\2\289\7X\2\29:\7k\2\2:;\7q\2\2;<\7n\2\2<=\7c\2"+
		"\2=>\7v\2\2>?\7g\2\2?@\7f\2\2@A\7\"\2\2AB\7c\2\2BC\7u\2\2CD\7u\2\2DE\7"+
		"g\2\2EF\7t\2\2FG\7v\2\2GH\7u\2\2HI\7<\2\2I\6\3\2\2\2JK\7p\2\2KL\7q\2\2"+
		"LM\7p\2\2MN\7g\2\2N\b\3\2\2\2OP\7v\2\2PQ\7t\2\2QR\7w\2\2RS\7g\2\2S\n\3"+
		"\2\2\2TU\7h\2\2UV\7c\2\2VW\7n\2\2WX\7u\2\2XY\7g\2\2Y\f\3\2\2\2Z[\7}\2"+
		"\2[\16\3\2\2\2\\]\7\177\2\2]\20\3\2\2\2^_\7]\2\2_\22\3\2\2\2`a\7_\2\2"+
		"a\24\3\2\2\2bc\7*\2\2c\26\3\2\2\2de\7+\2\2e\30\3\2\2\2fg\7)\2\2g\32\3"+
		"\2\2\2hi\7?\2\2i\34\3\2\2\2jk\7.\2\2k\36\3\2\2\2lm\7B\2\2m \3\2\2\2no"+
		"\7/\2\2o\"\3\2\2\2pq\7$\2\2q$\3\2\2\2rs\7<\2\2s&\3\2\2\2tx\7$\2\2uw\13"+
		"\2\2\2vu\3\2\2\2wz\3\2\2\2xy\3\2\2\2xv\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7"+
		"$\2\2|(\3\2\2\2}\177\t\2\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2"+
		"\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084*\3\2\2\2\u0085\u0089\t\4\2\2\u0086"+
		"\u0088\t\5\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a,\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e"+
		"\t\6\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\27\2\2\u0092.\3\2\2\2"+
		"\b\2x~\u0083\u0089\u008f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}