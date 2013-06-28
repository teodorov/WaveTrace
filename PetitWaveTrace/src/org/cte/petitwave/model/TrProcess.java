package org.cte.petitwave.model;

import java.util.Map;

public class TrProcess {
	private InstanceName name;
	private String state;
	private Map<String, Value<?>> fields;
	
	public TrProcess(InstanceName inName, String inState, Map<String, Value<?>> inFields) {
		setName(inName);
		setState(inState);
		setFields(inFields);
	}

	public InstanceName getName() {
		return name;
	}

	public void setName(InstanceName name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Map<String, Value<?>> getFields() {
		return fields;
	}

	public void setFields(Map<String, Value<?>> fields) {
		this.fields = fields;
	}
}
