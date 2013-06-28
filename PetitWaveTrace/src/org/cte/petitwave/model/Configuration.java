package org.cte.petitwave.model;

import java.util.List;

import com.google.common.collect.Lists;

public class Configuration extends TraceEntry {
	private int id; 
	private List<TrProcess> processes;
	private List<Property> properties;
	private List<String>  channels;
	private List<InstanceName> fasserts;
	
	public Configuration() {
		this.processes = Lists.newArrayList();
		this.channels  = Lists.newArrayList();
		this.fasserts  = Lists.newArrayList();
	}
	
	public List<TrProcess> getProcesses() {
		return processes;
	}

	public void setProcesses(List<TrProcess> processes) {
		this.processes = processes;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public List<InstanceName> getFasserts() {
		return fasserts;
	}

	public void setFasserts(List<InstanceName> fasserts) {
		this.fasserts = fasserts;
	}

}
