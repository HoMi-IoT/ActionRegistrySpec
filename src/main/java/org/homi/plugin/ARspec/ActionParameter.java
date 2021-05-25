package org.homi.plugin.ARspec;

public class ActionParameter<T> {
	private T parameter;
	
	public ActionParameter(T p){
		this.parameter = p;
	}

	public T getParameter() {
		return parameter;
	}

	public void setParameter(T parameter) {
		this.parameter = parameter;
	}
}
