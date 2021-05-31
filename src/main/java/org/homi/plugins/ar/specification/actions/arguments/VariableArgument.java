package org.homi.plugins.ar.specification.actions.arguments;

import java.io.Serializable;

public class VariableArgument<T extends Serializable> implements IActionArgument<T> {

	private static final long serialVersionUID = -954326441665246657L;

	private Class<T> type;
	private String parameterName;
	
	public VariableArgument(Class<T> type, String parameterName){
		this.type = type;
		this.parameterName = parameterName;
	}

	public Class<T> getType(){
		return this.type;
	}
	
	public String getParameterName() {
		return this.parameterName;
	}
	
	@Override
	public T accept(IActionArgumentVisitor aav) {
		return aav.visit(this);
	}

}