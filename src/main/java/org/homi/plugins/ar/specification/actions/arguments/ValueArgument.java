package org.homi.plugins.ar.specification.actions.arguments;

import java.io.Serializable;

public class ValueArgument<T extends Serializable> implements IActionArgument<T>{

	private static final long serialVersionUID = 6856996111953475351L;
	
	private T value;
	
	public ValueArgument(T value){
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	@Override
	public T accept(IActionArgumentVisitor aav) {
		return aav.visit(this);
	}
}
