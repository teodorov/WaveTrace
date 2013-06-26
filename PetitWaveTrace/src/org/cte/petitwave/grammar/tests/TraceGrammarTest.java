package org.cte.petitwave.grammar.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.cte.petitwave.grammar.TraceGrammar;
import org.junit.Test;
import org.petitparser.buffer.StringToken;
import org.petitparser.buffer.Token;
import org.petitparser.context.Context;
import org.petitparser.context.Result;
import org.petitparser.parser.Parser;

public class TraceGrammarTest {
	private final TraceGrammar parser = new TraceGrammar();
	private String currentRule = null;
	
	@Test
	public void testNumber() {
		String result = assertValidToken("1234", "number");
		
		assertTrue(result == "1234");
		
		result = assertValidToken("298", "number");
		assertTrue(result == "298");
		
		assertInvalid("abc", "number");
	}
	
	@Test
	public void testIdentifier() {
		setCurrentRule("identifier");
		
		assertEquals("abc", assertValidToken("abc"));
		assertEquals("abcd", assertValidToken("abcd"));
		assertEquals("pty_Env_recv_result_2_4_8_10_14", assertValidToken("pty_Env_recv_result_2_4_8_10_14"));
	}
	
	@Test
	public void testInstanceName() {
		setCurrentRule("instanceName");
		
		List<Token> res = assertValid("{pty_sync_Acq_Comput}1").get();
		assertEquals("pty_sync_Acq_Comput", res.get(1).getValue());
		assertEquals("1", res.get(3).getValue());
		
		res = assertValid("{pty_sync_Acq_Comput}1234").get();
		assertEquals("pty_sync_Acq_Comput", res.get(1).getValue());
		assertEquals("1234", res.get(3).getValue());
	
		res = assertValid("{ pty_sync_Acq-Comput } 1234").get();
		assertEquals("pty_sync_Acq-Comput", res.get(1).getValue());
		assertEquals("1234", res.get(3).getValue());
	}
	
	@Test
	public void testfiInstanceName() {
		setCurrentRule("fiInstanceName");
		
		List<List<Token>> res = assertValid("'{pty_sync_Acq_Comput}1'").get();
		assertEquals("pty_sync_Acq_Comput", res.get(1).get(1).getValue());
		assertEquals("1", res.get(1).get(3).getValue());
		
		res = assertValid("'{pty_sync_Acq_Comput}1234'").get();
		assertEquals("pty_sync_Acq_Comput", res.get(1).get(1).getValue());
		assertEquals("1234", res.get(1).get(3).getValue());
	
		res = assertValid("'{ pty_sync_Acq-Comput } 1234'").get();
		assertEquals("pty_sync_Acq-Comput", res.get(1).get(1).getValue());
		assertEquals("1234", res.get(1).get(3).getValue());
	}
	
	@Test
	public void testBooleanValue() {
		setCurrentRule("booleanValue");
		
		assertEquals("true", assertValidToken("true"));
		assertEquals("false", assertValidToken("false"));
		assertInvalid("False");
		assertInvalid("TRUE");
		assertInvalid("trueb");
		assertInvalid("abc");
	}
	
	@Test
	public void testArrayValue() {
		List<List<Token>> res;
		setCurrentRule("arrayValue");
		
		res = assertValid("[false, false]").get();
		assertEquals("false", res.get(1).get(0).getValue());
		assertEquals("false", res.get(1).get(2).getValue());
		
		res = assertValid("[]").get();
		assertNull(res.get(1));
		
		res = assertValid("[2, 4]").get();
		assertEquals("2", res.get(1).get(0).getValue());
	}
	
	@Test
	public void testField() {
		List<Token> res;
		setCurrentRule("field");
		
		res = assertValid("abc=2").get();
	    assertEquals(3, res.size());
	    assertEquals("abc", res.get(0).getValue());
	    assertEquals("2", res.get(2).getValue());
		
		res = assertValid("Data_Enable=[false, false]").get();
	    assertEquals(3, res.size());
	    assertEquals("Data_Enable", res.get(0).getValue());
	}
	
	@Test
	public void testRecordValue() {
		List<List<List<Token>>> res;
		setCurrentRule("recordValue");
		
		res = assertValid("{abc=2, cde=true}").get();
		assertEquals(3, res.size());
		assertEquals("abc", res.get(1).get(0).get(0).getValue());
		assertEquals("2", res.get(1).get(0).get(2).getValue());
		assertEquals("cde", res.get(1).get(2).get(0).getValue());
		assertEquals("true", res.get(1).get(2).get(2).getValue());
		
		res = assertValid("{must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}").get();
		assertEquals(11, res.get(1).size()); //6 fields + 5 commas
	}
	
	@Test
	public void testArrayOfRecord() {
		setCurrentRule("arrayValue");
		assertValid("[{must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}, {must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}, {must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}, {must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}, {must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}, {must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}, {must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}]");
	}
	
	@Test
	public void testStateName() {
		setCurrentRule("stateName");
		assertValid("@run1,");
		assertValid("start,");
		assertValid("@s_inter_w,");
		assertValid("start");
	}
	
	@Test
	public void testProcessState() {
		List<List<List<Token>>> res;
		setCurrentRule("processState");
		
		assertValid("start");
		res = assertValid("@Start, - v=0 - nbDataLues=0 - readData=false - data1=0  - data2=0 - result=0").get();
		assertEquals(6, res.get(1).size());
	}
	
	private String assertValidToken(String input) {
		return ((StringToken)(assertValid(input, null).get())).getValue();
	}
	
	private String assertValidToken(String input, String rule) {
		return ((StringToken)(assertValid(input, rule).get())).getValue();
	}
	
	private Result assertValid(String input) {
		return assertValid(input, null);
	}

	private Result parseWithRule(String input, String rule) {
		String theRule = rule != null ? rule : (currentRule != null ? currentRule : null);
		if (theRule == null) {
			return parser.parse(new Context(input));
		}
		return parser.parserAt(theRule).end().parse(new Context(input));
	}
	
	private Result assertValid(String input, String rule) {
		Result result = parseWithRule(input, rule);
		assertTrue(result.isSuccess());
		return result;
	}
	
	private Result assertInvalid(String input) {
		return assertInvalid(input, null);
	}
	private Result assertInvalid(String input, String rule) {
		Result result = parseWithRule(input, rule);
		assertTrue(result.isFailure());
		return result;
	}

	public String getCurrentRule() {
		return currentRule;
	}

	public void setCurrentRule(String currentRule) {
		this.currentRule = currentRule;
	}
}
