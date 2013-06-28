package org.cte.petitwave.grammar;

import java.util.List;
import java.util.Map;

import org.cte.petitwave.model.Configuration;
import org.cte.petitwave.model.InstanceName;
import org.cte.petitwave.model.TrProcess;
import org.cte.petitwave.model.Value;
import org.petitparser.buffer.StringToken;
import org.petitparser.buffer.Token;
import org.petitparser.utils.Functions;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TraceParser extends TraceGrammar {

	@Override
	protected void initialize() {
		super.initialize();
		action("number",
				new Function<StringToken, Value<Integer>>() {
			@Override
			public Value<Integer> apply(StringToken input) {
				return new Value<Integer>(Integer.parseInt((String)input.getValue()));
			}
		});
		action("identifier",
				new Function<Token, String>() {
			@Override
			public String apply(Token input) {
				return input.getValue();
			}
		});
		action("instanceName",
				new Function<List<?>, InstanceName>() {
			@SuppressWarnings("unchecked")
			@Override
			public InstanceName apply(List<?> input) {
				return new InstanceName((String)input.get(1), ((Value<Integer>)input.get(3)).getData());
			}
		} );
		action("fiInstanceName",
				new Function<List<?>, InstanceName>() {
			@Override
			public InstanceName apply(List<?> input) {
				return (InstanceName)input.get(1);
			}
		});
		action("booleanValue",
				new Function<Token, Value<Boolean>>() {
			@Override
			public Value<Boolean> apply(Token input) {
				if (input.getValue().equals("true")) {
					return new Value<Boolean>(Boolean.TRUE);
				}
				else if (input.getValue().equals("false")) {
					return new Value<Boolean>(Boolean.FALSE);
				}
				else {
					System.err.println("unexpected boolean value: " + input.getValue());
				}
				return null;
			}
		});
		action("arrayElements", org.petitparser.utils.Functions.withoutSeparators());
		action("arrayValue",
				new Function <List<List<Object>>, Value<List<Object>>>() {
			@Override
			public Value<List<Object>> apply(List<List<Object>> inList) {
				List<Object> result = Lists.newArrayList();
				if (inList.get(1) != null) {
					for (Object obj : inList.get(1)) {
						result.add(obj);
					}
				}
				return new Value<List<Object>>(result);
			}
		});
		action("field", 
				new Function <List<Object>, List<Object>>() {
			@Override
			public List<Object> apply(List<Object> inList) {
				List<Object> result = Lists.newArrayList();
				result.add(inList.get(0));
				result.add(inList.get(2));
				return result;
			}
		});
		action("recordElements", org.petitparser.utils.Functions.withoutSeparators());
		action("recordValue",
				new Function <List<List<List<Object>>>, Value<Map<String, Object>>>() {
			@Override
			public Value<Map<String, Object>> apply(List<List<List<Object>>> inList) {
				Map<String, Object> result = Maps.newLinkedHashMap();
				if (inList.get(1) != null) {
					for (List<Object> list : inList.get(1)) {
						result.put((String)list.get(0), list.get(1));
					}
				}
				return new Value<Map<String, Object>>(result);
			}
		});
		action("stateName",
				new Function<List<String>, String>() {
			@Override
			public String apply(List<String> inList) {
				return inList.get(1);
			}
		});
		action("fields",
				new Function<List<List<?>>, List<?>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<?> apply(List<List<?>> inList) {
				return Functions.withoutSeparators().apply((List<Object>)inList.get(1));
			}
		});
		action("processState",
				new Function<List<List<List<Object>>>, TrProcess>(){
			@Override
			public  TrProcess apply(List<List<List<Object>>> inList) {
				Object state = inList.get(0);
				Map<String, Value<?>> map = Maps.newLinkedHashMap();

				if (inList.get(1) != null) {
					for (List<Object> list : inList.get(1)) {
						map.put((String)list.get(0), (Value<?>)list.get(1));
					}
				}

				return new TrProcess(null, (String)state, map);
			}
		});
		action("process",
				new Function<List<Object>, TrProcess>(){
			@Override
			public TrProcess apply(List<Object> inList) {
				TrProcess theProcess = (TrProcess)inList.get(2);

				theProcess.setName((InstanceName)inList.get(0));
				return theProcess;
			}
		});
		action("channels",
				new Function<List<List<Object>>, List<String>>(){
			@SuppressWarnings("unchecked")
			@Override
			public List<String> apply(List<List<Object>> inList) {
				List<Object> result = Lists.newArrayList();
				
				if (inList.get(1) != null) {
					result = Functions.withoutSeparators().apply(inList.get(1));
				}
				return (List<String>)(List<?>)result;
			}
		});
		action("violatedAsserts",
				new Function<List<?>, List<InstanceName>>(){
			@SuppressWarnings("unchecked")
			@Override
			public List<InstanceName> apply(List<?> inList) {
				List<InstanceName> result = Lists.newArrayList();
				if (inList.get(1) != null) {
					if (inList.get(1) instanceof StringToken)
						return result;
					result = (List<InstanceName>)(List<?>)Functions.withoutSeparators().apply((List<Object>)inList.get(1));
				}
				return result;
			}
		});
		action("configurationElement",
				new Function<List<?>, Object>() {
			@Override
			public Object apply(List<?> inList) {
				return inList.get(1);
			}
		});
		action("configuration",
				new Function<List<List<?>>, Configuration>() {
			@SuppressWarnings("unchecked")
			@Override
			public Configuration apply(List<List<?>> inList) {
				Configuration conf = new Configuration();
				conf.setId(((Value<Integer>)inList.get(0)).getData());
				if (inList.get(2) != null) {
					for (Object o : inList.get(2)) {
						if (o instanceof TrProcess) conf.getProcesses().add((TrProcess)o);
						if (o instanceof List<?>) {
							
							if (!((List<Object>)o).isEmpty())
								if (((List<Object>)o).get(0) instanceof String)
									conf.getChannels().addAll((List<String>) o);
								else
									conf.getFasserts().addAll((List<InstanceName>) o);
						}
					}
				}
				return conf;
			}
		});
	}
}