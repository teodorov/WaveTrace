// Generated from TraceGrammar.g4 by ANTLR 4.0
package org.cte.PetitWaveTrace.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TraceGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CHANNELS=1, VIOLATEDASSERTS=2, NONE=3, TRUE=4, FALSE=5, LCURLY=6, RCURLY=7, 
		LSQUARE=8, RSQUARE=9, LPAREN=10, RPAREN=11, TICK=12, EQ=13, COMMA=14, 
		AT=15, MINUS=16, DQUOTE=17, COLON=18, TransitionDetail=19, Number=20, 
		Identifier=21, WS=22;
	public static final String[] tokenNames = {
		"<INVALID>", "'Channels'", "'Violated asserts:'", "'none'", "'true'", 
		"'false'", "'{'", "'}'", "'['", "']'", "'('", "')'", "'''", "'='", "','", 
		"'@'", "'-'", "'\"'", "':'", "TransitionDetail", "Number", "Identifier", 
		"WS"
	};
	public static final int
		RULE_identifier = 0, RULE_instanceName = 1, RULE_fiInstanceName = 2, RULE_field = 3, 
		RULE_fieldValue = 4, RULE_booleanValue = 5, RULE_numberValue = 6, RULE_arrayElements = 7, 
		RULE_arrayValue = 8, RULE_recordElements = 9, RULE_recordValue = 10, RULE_stateName = 11, 
		RULE_processState = 12, RULE_process = 13, RULE_channels = 14, RULE_violatedAsserts = 15, 
		RULE_configurationElement = 16, RULE_configuration = 17, RULE_transition = 18, 
		RULE_traceFile = 19;
	public static final String[] ruleNames = {
		"identifier", "instanceName", "fiInstanceName", "field", "fieldValue", 
		"booleanValue", "numberValue", "arrayElements", "arrayValue", "recordElements", 
		"recordValue", "stateName", "processState", "process", "channels", "violatedAsserts", 
		"configurationElement", "configuration", "transition", "traceFile"
	};

	@Override
	public String getGrammarFileName() { return "TraceGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public TraceGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(TraceGrammarParser.COLON); }
		public TerminalNode Identifier(int i) {
			return getToken(TraceGrammarParser.Identifier, i);
		}
		public TerminalNode COLON(int i) {
			return getToken(TraceGrammarParser.COLON, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(TraceGrammarParser.Identifier); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(Identifier);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON) {
				{
				{
				setState(41); match(COLON);
				setState(42); match(Identifier);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceNameContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(TraceGrammarParser.LCURLY, 0); }
		public TerminalNode Number() { return getToken(TraceGrammarParser.Number, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(TraceGrammarParser.RCURLY, 0); }
		public InstanceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterInstanceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitInstanceName(this);
		}
	}

	public final InstanceNameContext instanceName() throws RecognitionException {
		InstanceNameContext _localctx = new InstanceNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instanceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(LCURLY);
			setState(49); identifier();
			setState(50); match(RCURLY);
			setState(51); match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FiInstanceNameContext extends ParserRuleContext {
		public List<TerminalNode> TICK() { return getTokens(TraceGrammarParser.TICK); }
		public InstanceNameContext instanceName() {
			return getRuleContext(InstanceNameContext.class,0);
		}
		public TerminalNode TICK(int i) {
			return getToken(TraceGrammarParser.TICK, i);
		}
		public FiInstanceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fiInstanceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterFiInstanceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitFiInstanceName(this);
		}
	}

	public final FiInstanceNameContext fiInstanceName() throws RecognitionException {
		FiInstanceNameContext _localctx = new FiInstanceNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fiInstanceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(TICK);
			setState(54); instanceName();
			setState(55); match(TICK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public FieldValueContext fieldValue() {
			return getRuleContext(FieldValueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(TraceGrammarParser.EQ, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); identifier();
			setState(58); match(EQ);
			setState(59); fieldValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldValueContext extends ParserRuleContext {
		public ArrayValueContext arrayValue() {
			return getRuleContext(ArrayValueContext.class,0);
		}
		public NumberValueContext numberValue() {
			return getRuleContext(NumberValueContext.class,0);
		}
		public RecordValueContext recordValue() {
			return getRuleContext(RecordValueContext.class,0);
		}
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public FieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitFieldValue(this);
		}
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldValue);
		try {
			setState(65);
			switch (_input.LA(1)) {
			case LSQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(61); arrayValue();
				}
				break;
			case LCURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); recordValue();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(63); numberValue();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(64); booleanValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(TraceGrammarParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(TraceGrammarParser.TRUE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitBooleanValue(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberValueContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(TraceGrammarParser.Number, 0); }
		public NumberValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterNumberValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitNumberValue(this);
		}
	}

	public final NumberValueContext numberValue() throws RecognitionException {
		NumberValueContext _localctx = new NumberValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_numberValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayElementsContext extends ParserRuleContext {
		public TerminalNode COMMA(int i) {
			return getToken(TraceGrammarParser.COMMA, i);
		}
		public List<FieldValueContext> fieldValue() {
			return getRuleContexts(FieldValueContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(TraceGrammarParser.COMMA); }
		public FieldValueContext fieldValue(int i) {
			return getRuleContext(FieldValueContext.class,i);
		}
		public ArrayElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterArrayElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitArrayElements(this);
		}
	}

	public final ArrayElementsContext arrayElements() throws RecognitionException {
		ArrayElementsContext _localctx = new ArrayElementsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); fieldValue();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(72); match(COMMA);
				setState(73); fieldValue();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayValueContext extends ParserRuleContext {
		public ArrayElementsContext arrayElements() {
			return getRuleContext(ArrayElementsContext.class,0);
		}
		public TerminalNode LSQUARE() { return getToken(TraceGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(TraceGrammarParser.RSQUARE, 0); }
		public ArrayValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitArrayValue(this);
		}
	}

	public final ArrayValueContext arrayValue() throws RecognitionException {
		ArrayValueContext _localctx = new ArrayValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(LSQUARE);
			setState(81);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LCURLY) | (1L << LSQUARE) | (1L << Number))) != 0)) {
				{
				setState(80); arrayElements();
				}
			}

			setState(83); match(RSQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordElementsContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(TraceGrammarParser.COMMA, i);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TraceGrammarParser.COMMA); }
		public RecordElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterRecordElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitRecordElements(this);
		}
	}

	public final RecordElementsContext recordElements() throws RecognitionException {
		RecordElementsContext _localctx = new RecordElementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recordElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); field();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86); match(COMMA);
				setState(87); field();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordValueContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(TraceGrammarParser.LCURLY, 0); }
		public RecordElementsContext recordElements() {
			return getRuleContext(RecordElementsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(TraceGrammarParser.RCURLY, 0); }
		public RecordValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterRecordValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitRecordValue(this);
		}
	}

	public final RecordValueContext recordValue() throws RecognitionException {
		RecordValueContext _localctx = new RecordValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_recordValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(LCURLY);
			setState(94); recordElements();
			setState(95); match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateNameContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(TraceGrammarParser.AT, 0); }
		public TerminalNode COMMA() { return getToken(TraceGrammarParser.COMMA, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterStateName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitStateName(this);
		}
	}

	public final StateNameContext stateName() throws RecognitionException {
		StateNameContext _localctx = new StateNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stateName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(97); match(AT);
				}
			}

			setState(100); identifier();
			setState(102);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(101); match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcessStateContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public TerminalNode MINUS(int i) {
			return getToken(TraceGrammarParser.MINUS, i);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TraceGrammarParser.MINUS); }
		public StateNameContext stateName() {
			return getRuleContext(StateNameContext.class,0);
		}
		public ProcessStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processState; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterProcessState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitProcessState(this);
		}
	}

	public final ProcessStateContext processState() throws RecognitionException {
		ProcessStateContext _localctx = new ProcessStateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_processState);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if (_la==AT || _la==Identifier) {
				{
				setState(104); stateName();
				}
			}

			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MINUS) {
				{
				{
				setState(107); match(MINUS);
				setState(108); field();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcessContext extends ParserRuleContext {
		public InstanceNameContext instanceName() {
			return getRuleContext(InstanceNameContext.class,0);
		}
		public TerminalNode LSQUARE() { return getToken(TraceGrammarParser.LSQUARE, 0); }
		public FiInstanceNameContext fiInstanceName() {
			return getRuleContext(FiInstanceNameContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(TraceGrammarParser.RSQUARE, 0); }
		public ProcessStateContext processState() {
			return getRuleContext(ProcessStateContext.class,0);
		}
		public ProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_process; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitProcess(this);
		}
	}

	public final ProcessContext process() throws RecognitionException {
		ProcessContext _localctx = new ProcessContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_process);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			switch (_input.LA(1)) {
			case TICK:
				{
				setState(114); fiInstanceName();
				}
				break;
			case LCURLY:
				{
				setState(115); instanceName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(118); match(LSQUARE);
			setState(119); processState();
			setState(120); match(RSQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChannelsContext extends ParserRuleContext {
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(TraceGrammarParser.COMMA, i);
		}
		public TerminalNode CHANNELS() { return getToken(TraceGrammarParser.CHANNELS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(TraceGrammarParser.COMMA); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public ChannelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterChannels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitChannels(this);
		}
	}

	public final ChannelsContext channels() throws RecognitionException {
		ChannelsContext _localctx = new ChannelsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_channels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(CHANNELS);
			setState(123); identifier();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(124); match(COMMA);
				setState(125); identifier();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViolatedAssertsContext extends ParserRuleContext {
		public InstanceNameContext instanceName(int i) {
			return getRuleContext(InstanceNameContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(TraceGrammarParser.COMMA, i);
		}
		public List<InstanceNameContext> instanceName() {
			return getRuleContexts(InstanceNameContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(TraceGrammarParser.COMMA); }
		public TerminalNode NONE() { return getToken(TraceGrammarParser.NONE, 0); }
		public TerminalNode VIOLATEDASSERTS() { return getToken(TraceGrammarParser.VIOLATEDASSERTS, 0); }
		public ViolatedAssertsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_violatedAsserts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterViolatedAsserts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitViolatedAsserts(this);
		}
	}

	public final ViolatedAssertsContext violatedAsserts() throws RecognitionException {
		ViolatedAssertsContext _localctx = new ViolatedAssertsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_violatedAsserts);
		int _la;
		try {
			setState(141);
			switch (_input.LA(1)) {
			case VIOLATEDASSERTS:
				enterOuterAlt(_localctx, 1);
				{
				setState(131); match(VIOLATEDASSERTS);
				setState(132); match(NONE);
				}
				break;
			case LCURLY:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(133); instanceName();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(134); match(COMMA);
					setState(135); instanceName();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConfigurationElementContext extends ParserRuleContext {
		public ProcessContext process() {
			return getRuleContext(ProcessContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(TraceGrammarParser.MINUS, 0); }
		public ChannelsContext channels() {
			return getRuleContext(ChannelsContext.class,0);
		}
		public ViolatedAssertsContext violatedAsserts() {
			return getRuleContext(ViolatedAssertsContext.class,0);
		}
		public ConfigurationElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_configurationElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterConfigurationElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitConfigurationElement(this);
		}
	}

	public final ConfigurationElementContext configurationElement() throws RecognitionException {
		ConfigurationElementContext _localctx = new ConfigurationElementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_configurationElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(MINUS);
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(144); process();
				}
				break;

			case 2:
				{
				setState(145); channels();
				}
				break;

			case 3:
				{
				setState(146); violatedAsserts();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConfigurationContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(TraceGrammarParser.LCURLY, 0); }
		public List<ConfigurationElementContext> configurationElement() {
			return getRuleContexts(ConfigurationElementContext.class);
		}
		public TerminalNode Number() { return getToken(TraceGrammarParser.Number, 0); }
		public ConfigurationElementContext configurationElement(int i) {
			return getRuleContext(ConfigurationElementContext.class,i);
		}
		public TerminalNode RCURLY() { return getToken(TraceGrammarParser.RCURLY, 0); }
		public ConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_configuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterConfiguration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitConfiguration(this);
		}
	}

	public final ConfigurationContext configuration() throws RecognitionException {
		ConfigurationContext _localctx = new ConfigurationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_configuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); match(Number);
			setState(150); match(LCURLY);
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151); configurationElement();
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MINUS );
			setState(156); match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionContext extends ParserRuleContext {
		public TerminalNode RPAREN() { return getToken(TraceGrammarParser.RPAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(TraceGrammarParser.COMMA, i);
		}
		public List<TerminalNode> Number() { return getTokens(TraceGrammarParser.Number); }
		public TerminalNode TransitionDetail() { return getToken(TraceGrammarParser.TransitionDetail, 0); }
		public List<TerminalNode> COMMA() { return getTokens(TraceGrammarParser.COMMA); }
		public TerminalNode LPAREN() { return getToken(TraceGrammarParser.LPAREN, 0); }
		public TerminalNode Number(int i) {
			return getToken(TraceGrammarParser.Number, i);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(LPAREN);
			setState(159); match(Number);
			setState(160); match(COMMA);
			setState(161); match(TransitionDetail);
			setState(162); match(COMMA);
			setState(163); match(Number);
			setState(164); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TraceFileContext extends ParserRuleContext {
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public TraceFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traceFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).enterTraceFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TraceGrammarListener ) ((TraceGrammarListener)listener).exitTraceFile(this);
		}
	}

	public final TraceFileContext traceFile() throws RecognitionException {
		TraceFileContext _localctx = new TraceFileContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_traceFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Number) {
				{
				{
				setState(166); configuration();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAREN) {
				{
				{
				setState(172); transition();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\30\u00b5\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\7\2"+
		".\n\2\f\2\16\2\61\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\5\6D\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\7\tM\n\t\f\t"+
		"\16\tP\13\t\3\n\3\n\5\nT\n\n\3\n\3\n\3\13\3\13\3\13\7\13[\n\13\f\13\16"+
		"\13^\13\13\3\f\3\f\3\f\3\f\3\r\5\re\n\r\3\r\3\r\5\ri\n\r\3\16\5\16l\n"+
		"\16\3\16\3\16\7\16p\n\16\f\16\16\16s\13\16\3\17\3\17\5\17w\n\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0081\n\20\f\20\16\20\u0084\13"+
		"\20\3\21\3\21\3\21\3\21\3\21\7\21\u008b\n\21\f\21\16\21\u008e\13\21\5"+
		"\21\u0090\n\21\3\22\3\22\3\22\3\22\5\22\u0096\n\22\3\23\3\23\3\23\6\23"+
		"\u009b\n\23\r\23\16\23\u009c\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\7\25\u00aa\n\25\f\25\16\25\u00ad\13\25\3\25\7\25\u00b0\n"+
		"\25\f\25\16\25\u00b3\13\25\3\25\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(\2\3\3\6\7\u00b4\2*\3\2\2\2\4\62\3\2\2\2\6\67\3\2\2\2\b;\3"+
		"\2\2\2\nC\3\2\2\2\fE\3\2\2\2\16G\3\2\2\2\20I\3\2\2\2\22Q\3\2\2\2\24W\3"+
		"\2\2\2\26_\3\2\2\2\30d\3\2\2\2\32k\3\2\2\2\34v\3\2\2\2\36|\3\2\2\2 \u008f"+
		"\3\2\2\2\"\u0091\3\2\2\2$\u0097\3\2\2\2&\u00a0\3\2\2\2(\u00ab\3\2\2\2"+
		"*/\7\27\2\2+,\7\24\2\2,.\7\27\2\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\3\3\2\2\2\61/\3\2\2\2\62\63\7\b\2\2\63\64\5\2\2\2\64\65\7"+
		"\t\2\2\65\66\7\26\2\2\66\5\3\2\2\2\678\7\16\2\289\5\4\3\29:\7\16\2\2:"+
		"\7\3\2\2\2;<\5\2\2\2<=\7\17\2\2=>\5\n\6\2>\t\3\2\2\2?D\5\22\n\2@D\5\26"+
		"\f\2AD\5\16\b\2BD\5\f\7\2C?\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\13"+
		"\3\2\2\2EF\t\2\2\2F\r\3\2\2\2GH\7\26\2\2H\17\3\2\2\2IN\5\n\6\2JK\7\20"+
		"\2\2KM\5\n\6\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\21\3\2\2\2PN\3"+
		"\2\2\2QS\7\n\2\2RT\5\20\t\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\13\2\2V"+
		"\23\3\2\2\2W\\\5\b\5\2XY\7\20\2\2Y[\5\b\5\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2"+
		"\2\2\\]\3\2\2\2]\25\3\2\2\2^\\\3\2\2\2_`\7\b\2\2`a\5\24\13\2ab\7\t\2\2"+
		"b\27\3\2\2\2ce\7\21\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fh\5\2\2\2gi\7\20"+
		"\2\2hg\3\2\2\2hi\3\2\2\2i\31\3\2\2\2jl\5\30\r\2kj\3\2\2\2kl\3\2\2\2lq"+
		"\3\2\2\2mn\7\22\2\2np\5\b\5\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"r\33\3\2\2\2sq\3\2\2\2tw\5\6\4\2uw\5\4\3\2vt\3\2\2\2vu\3\2\2\2wx\3\2\2"+
		"\2xy\7\n\2\2yz\5\32\16\2z{\7\13\2\2{\35\3\2\2\2|}\7\3\2\2}\u0082\5\2\2"+
		"\2~\177\7\20\2\2\177\u0081\5\2\2\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2"+
		"\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\37\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0086\7\4\2\2\u0086\u0090\7\5\2\2\u0087\u008c\5\4\3\2\u0088"+
		"\u0089\7\20\2\2\u0089\u008b\5\4\3\2\u008a\u0088\3\2\2\2\u008b\u008e\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0085\3\2\2\2\u008f\u0087\3\2\2\2\u0090!\3\2\2\2"+
		"\u0091\u0095\7\22\2\2\u0092\u0096\5\34\17\2\u0093\u0096\5\36\20\2\u0094"+
		"\u0096\5 \21\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2"+
		"\2\2\u0096#\3\2\2\2\u0097\u0098\7\26\2\2\u0098\u009a\7\b\2\2\u0099\u009b"+
		"\5\"\22\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\t\2\2\u009f%\3"+
		"\2\2\2\u00a0\u00a1\7\f\2\2\u00a1\u00a2\7\26\2\2\u00a2\u00a3\7\20\2\2\u00a3"+
		"\u00a4\7\25\2\2\u00a4\u00a5\7\20\2\2\u00a5\u00a6\7\26\2\2\u00a6\u00a7"+
		"\7\r\2\2\u00a7\'\3\2\2\2\u00a8\u00aa\5$\23\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b1\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\5&\24\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2)\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\23/CNS\\dhkqv\u0082\u008c\u008f\u0095\u009c\u00ab"+
		"\u00b1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}