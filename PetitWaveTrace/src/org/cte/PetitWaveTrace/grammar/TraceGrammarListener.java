// Generated from TraceGrammar.g4 by ANTLR 4.0
package org.cte.PetitWaveTrace.grammar;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface TraceGrammarListener extends ParseTreeListener {
	void enterConfigurationElement(TraceGrammarParser.ConfigurationElementContext ctx);
	void exitConfigurationElement(TraceGrammarParser.ConfigurationElementContext ctx);

	void enterFiInstanceName(TraceGrammarParser.FiInstanceNameContext ctx);
	void exitFiInstanceName(TraceGrammarParser.FiInstanceNameContext ctx);

	void enterRecordElements(TraceGrammarParser.RecordElementsContext ctx);
	void exitRecordElements(TraceGrammarParser.RecordElementsContext ctx);

	void enterTraceFile(TraceGrammarParser.TraceFileContext ctx);
	void exitTraceFile(TraceGrammarParser.TraceFileContext ctx);

	void enterTransition(TraceGrammarParser.TransitionContext ctx);
	void exitTransition(TraceGrammarParser.TransitionContext ctx);

	void enterChannels(TraceGrammarParser.ChannelsContext ctx);
	void exitChannels(TraceGrammarParser.ChannelsContext ctx);

	void enterRecordValue(TraceGrammarParser.RecordValueContext ctx);
	void exitRecordValue(TraceGrammarParser.RecordValueContext ctx);

	void enterBooleanValue(TraceGrammarParser.BooleanValueContext ctx);
	void exitBooleanValue(TraceGrammarParser.BooleanValueContext ctx);

	void enterProcess(TraceGrammarParser.ProcessContext ctx);
	void exitProcess(TraceGrammarParser.ProcessContext ctx);

	void enterField(TraceGrammarParser.FieldContext ctx);
	void exitField(TraceGrammarParser.FieldContext ctx);

	void enterArrayValue(TraceGrammarParser.ArrayValueContext ctx);
	void exitArrayValue(TraceGrammarParser.ArrayValueContext ctx);

	void enterInstanceName(TraceGrammarParser.InstanceNameContext ctx);
	void exitInstanceName(TraceGrammarParser.InstanceNameContext ctx);

	void enterArrayElements(TraceGrammarParser.ArrayElementsContext ctx);
	void exitArrayElements(TraceGrammarParser.ArrayElementsContext ctx);

	void enterFieldValue(TraceGrammarParser.FieldValueContext ctx);
	void exitFieldValue(TraceGrammarParser.FieldValueContext ctx);

	void enterNumberValue(TraceGrammarParser.NumberValueContext ctx);
	void exitNumberValue(TraceGrammarParser.NumberValueContext ctx);

	void enterStateName(TraceGrammarParser.StateNameContext ctx);
	void exitStateName(TraceGrammarParser.StateNameContext ctx);

	void enterConfiguration(TraceGrammarParser.ConfigurationContext ctx);
	void exitConfiguration(TraceGrammarParser.ConfigurationContext ctx);

	void enterViolatedAsserts(TraceGrammarParser.ViolatedAssertsContext ctx);
	void exitViolatedAsserts(TraceGrammarParser.ViolatedAssertsContext ctx);

	void enterProcessState(TraceGrammarParser.ProcessStateContext ctx);
	void exitProcessState(TraceGrammarParser.ProcessStateContext ctx);

	void enterIdentifier(TraceGrammarParser.IdentifierContext ctx);
	void exitIdentifier(TraceGrammarParser.IdentifierContext ctx);
}