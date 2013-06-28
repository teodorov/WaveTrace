package org.cte.petitwave.grammar.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.cte.petitwave.grammar.TraceParser;
import org.cte.petitwave.model.Configuration;
import org.cte.petitwave.model.InstanceName;
import org.cte.petitwave.model.TrProcess;
import org.cte.petitwave.model.Value;
import org.junit.Test;
import org.petitparser.buffer.Token;
import org.petitparser.context.Context;
import org.petitparser.context.Result;

public class TraceParserTest {
	private final TraceParser parser = new TraceParser();
	String currentRule = null;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testNumber() {
		Result result = assertValid("1234", "number");
		assertTrue(1234 == ((Value<Integer>)result.get()).getData());
		
		result = assertValid("298", "number");
		assertTrue(298 == ((Value<Integer>)result.get()).getData());
	}
	
	@Test
	public void testIdentifier() {
		setCurrentRule("identifier");
		
		assertEquals("abc", assertValid("abc").get());
		assertEquals("abcd", assertValid("abcd").get());
		assertEquals("pty_Env_recv_result_2_4_8_10_14", assertValid("pty_Env_recv_result_2_4_8_10_14").get());
	}
	
	@Test
	public void testInstanceName() {
		setCurrentRule("instanceName");
		
		InstanceName res = assertValid("{pty_sync_Acq_Comput}1").get();
		assertEquals("pty_sync_Acq_Comput", res.getName());
		assertTrue(1 == res.getId());
		
		res = assertValid("{pty_sync_Acq_Comput}1234").get();
		assertEquals("pty_sync_Acq_Comput", res.getName());
		assertTrue(1234 == res.getId());
	
		res = assertValid("{ pty_sync_Acq-Comput } 1234").get();
		assertEquals("pty_sync_Acq-Comput", res.getName());
		assertTrue(1234 == res.getId());
	}
	
	@Test
	public void testfiInstanceName() {
		setCurrentRule("fiInstanceName");
		
		InstanceName res = assertValid("'{pty_sync_Acq_Comput}1'").get();
		assertEquals("pty_sync_Acq_Comput", res.getName());
		assertTrue(1 == res.getId());
		
		res = assertValid("'{pty_sync_Acq_Comput}1234'").get();
		assertEquals("pty_sync_Acq_Comput", res.getName());
		assertTrue(1234 == res.getId());
	
		res = assertValid("'{ pty_sync_Acq-Comput } 1234'").get();
		assertEquals("pty_sync_Acq-Comput", res.getName());
		assertTrue(1234 == res.getId());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testBooleanValue() {
		setCurrentRule("booleanValue");
		
		assertTrue(((Value<Boolean>)assertValid("true").get()).getData());
		assertFalse(((Value<Boolean>)assertValid("false").get()).getData());
	}
	
	@Test
	public void testArrayValue() {
		Value<List<Value<?>>> res;
		setCurrentRule("arrayValue");
		
		res = assertValid("[false, false]").get();
		assertEquals(2, res.getData().size());
		assertFalse((Boolean)res.getData().get(0).getData());
		assertFalse((Boolean)res.getData().get(1).getData());
		
		res = assertValid("[]").get();
		assertTrue(res.getData().isEmpty());
		
		res = assertValid("[2, 4]").get();
		assertEquals(2, res.getData().size());
		assertTrue(2 == (Integer)res.getData().get(0).getData());
		assertTrue(4 == (Integer)res.getData().get(1).getData());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testField() {
		List<Object> res;
		setCurrentRule("field");
		
		res = assertValid("abc=2").get();
	    assertEquals(2, res.size());
	    assertEquals("abc", ((String)res.get(0)));
	    assertTrue(2 == ((Value<Integer>)res.get(1)).getData());
		
		res = assertValid("Data_Enable=[false, false]").get();
	    assertEquals(2, res.size());
	    assertEquals("Data_Enable", ((String)res.get(0)));
	}
	
	@Test
	public void testRecordValue() {
		Value<Map<String, Value<?>>> res;
		setCurrentRule("recordValue");
		
		res = assertValid("{abc=2, cde=true}").get();
		assertEquals(2, res.getData().size());
		assertTrue((Integer)res.getData().get("abc").getData() == 2);
		assertTrue((Boolean)res.getData().get("cde").getData());
		
		res = assertValid("{must_tick=false,act_tick=false,cannot_tick=false,dead=false,nb_tick=0,preced=false}").get();
		assertEquals(6, res.getData().size()); //6 fields + 5 commas
	}
	
	@Test
	public void testProcessState() {
		TrProcess res;
		setCurrentRule("processState");
		
		res = assertValid("start").get();
		assertEquals("start", res.getState());
		res = assertValid("@Start, - v=0 - nbDataLues=0 - readData=false - data1=0  - data2=0 - result=0").get();
		assertEquals("Start", res.getState());
		assertEquals(6, res.getFields().size());
		res = assertValid("- v=0 - nbDataLues=0 - readData=false - data1=0  - data2=0 - result=0").get();
		assertNull(res.getState());
		assertEquals(6, res.getFields().size());
	}
	
	@Test
	public void testFields() {
		List<Object> res;
		setCurrentRule("fields");
		
		res = assertValid("- v=0 - nbDataLues=0 - readData=false - data1=0  - data2=0 - result=0").get();
		assertEquals(6, res.size());
	}
	
	@Test
	public void testProcess() {
		TrProcess res;
		setCurrentRule("process");
		
		res = assertValid("'{toto}1' [@Start, - v=0 - nbDataLues=0 - readData=false - data1=0  - data2=0 - result=0]").get();
		assertEquals("toto", res.getName().getName());
		assertTrue(1 == res.getName().getId());
		assertEquals("Start", res.getState());
		assertEquals(6, res.getFields().size());
	}
	@Test
	public void testProcessOnlyState() {
		TrProcess res;
		setCurrentRule("process");
		res = assertValid(
				"'{AlternatesWith}1' [@s1,\n" +
				"]").get();
		assertEquals("AlternatesWith", res.getName().getName());
		assertTrue(1 == res.getName().getId());
		assertEquals("s1", res.getState());
		assertTrue(res.getFields().isEmpty());
	}
	
	@Test
	public void testProcessOnlyFields() {
		TrProcess res;
		setCurrentRule("process");
		res = assertValid(
				"'{Comp}1' [ - ckRead1=0 - ckWrite1=1 - ckRead2=2 ]").get();
		assertEquals("Comp", res.getName().getName());
		assertTrue(1 == res.getName().getId());
		assertNull(res.getState());
		assertTrue(res.getFields().size() == 3);
	}
	
	@Test
	public void testChannels() {
		List<String> res;
		setCurrentRule("channels");
		
		res = assertValid("Channels startAlt1, startAlt2, startStrictPrec1, startStrictPrec2, startFilteredBy, UpdateAlt1").get();
		assertTrue(6 == res.size());
		assertEquals("startAlt2", res.get(1));
		assertEquals("UpdateAlt1", res.get(5));
	}
	
	@Test
	public void testViolatedAssertsNone() {
		List<InstanceName> res;
		setCurrentRule("violatedAsserts");
		
		res = assertValid("Violated asserts: none").get();
		assertTrue(res.isEmpty());
	}
	
	@Test
	public void testViolatedAssertsOne() {
		List<InstanceName> res;
		setCurrentRule("violatedAsserts");
		
		res = assertValid("Violated asserts: {assert1}1").get();
		assertTrue(res.size() == 1);
	}
	
	@Test
	public void testViolatedAssertsMany() {
		List<InstanceName> res;
		setCurrentRule("violatedAsserts");
		
		res = assertValid("Violated asserts: {assert1}1, {assert1}1, {assert1}1, {assert1}1").get();
		assertTrue(res.size() == 4);
	}
	
	@Test
	public void testConfiguration() {
		Configuration res;
		setCurrentRule("configuration");
		
		res = assertValid(
						"8{\n" +
						"- '{Comp}1' [@s, \n" +
						"    - ckRead1=0 \n" +
						"    - ckWrite1=1 \n" +
						"    - ckRead2=2\n" +
						"]\n" +
						"- '{AlternatesWith}1' [@s1,\n" +
						"]\n" +
						"- {env}1 [start]\n" +
						"- {pte_SchedulerFin}1 [start]\n" +
						"- {pte_SchedulerErreur}1 [start]\n" +
						"- {pte_ComputErreur}1 [start]\n" +
						"- {pty_Alternates_pw1_pr1}1 [start]\n" +
						"- Channels startAlt1, startAlt2, startStrictPrec1, startStrictPrec2, startFilteredBy\n" +
						"- Violated asserts: none\n" +
						"}").get();
		assertTrue(res.getId() == 8);
		assertTrue(res.getProcesses().size() == 7);
		assertTrue(res.getChannels().size() == 5);
		assertTrue(res.getFasserts().isEmpty());
	}
	
	private Result assertValid(String input) {
		return assertValid(input, null);
	}

	private Result parseWithRule(String input, String rule) {
		String theRule = rule != null ? rule : (currentRule != null ? currentRule : null);
		if (theRule == null) {
			return parser.parse(new Context(input));
		}
		return parser.ref(theRule).end().parse(new Context(input));
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
