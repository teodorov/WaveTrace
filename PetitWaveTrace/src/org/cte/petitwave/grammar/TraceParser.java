package org.cte.petitwave.grammar;

import java.util.List;

import org.cte.petitwave.model.InstanceName;
import org.petitparser.buffer.Token;
import org.petitparser.parser.Parser;
import org.petitparser.tools.Production;

import com.google.common.base.Function;

public class TraceParser extends TraceGrammar {
	
	@Production
	public Parser number() {
		return super.number().map(new Function<String, Number>() {
			@Override
		      public Number apply(String input) {
		        return Integer.parseInt(input);
		      }
			});
	}
	
	@Production
	public Parser identifier() {
		return super.identifier().map(new Function<Token, String>() {
			@Override
			public String apply(Token input) {
				return input.getValue();
			}
		});
	}
	
	@Production
	public Parser instanceName() {
		return super.instanceName().map(new Function<List<?>, InstanceName>() {
			@Override
			public InstanceName apply(List<?> input) {
				return new InstanceName((String)input.get(1), (Integer)input.get(3));
			}
		});
	}
	
	@Production
	public Parser fiInstanceName() {
		return super.fiInstanceName().map(new Function<List<?>, InstanceName>() {
			@Override
			public InstanceName apply(List<?> input) {
				return (InstanceName)input.get(1);
			}
		});
	}
}
