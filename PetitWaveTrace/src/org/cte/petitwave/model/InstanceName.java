package org.cte.petitwave.model;

public class InstanceName {
	private String name;
	private Integer id;
	
	public InstanceName(String name, Integer id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
