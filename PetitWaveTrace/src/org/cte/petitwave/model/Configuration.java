package org.cte.petitwave.model;

import java.util.List;

public class Configuration extends TraceEntry {
	private int id; 
	private List<Process> processes;
	private List<Property> properties;
	private List<Channel>  channels;
	private List<FailedAssert> fasserts;
	
	public Configuration(int id, List<Process> proc, List<Property> prop, List<Channel> chan, List<FailedAssert> fasserts) {
		this.id = id;
		this.processes = proc;
		this.properties = prop;
		this.channels = chan;
		this.fasserts = fasserts;
	}

	public List<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(List<Process> processes) {
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

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public List<FailedAssert> getFasserts() {
		return fasserts;
	}

	public void setFasserts(List<FailedAssert> fasserts) {
		this.fasserts = fasserts;
	}

}
