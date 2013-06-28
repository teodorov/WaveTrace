package org.cte.petitwave.model;

public class Value<T> {
	private T data;
	
	public Value(T inData) {
		data = inData;
	}

	public void setData(T inData) {
		data = inData;
	}
	public T getData() {
		return data;
	}
}