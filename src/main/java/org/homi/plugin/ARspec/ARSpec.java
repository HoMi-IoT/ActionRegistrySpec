package org.homi.plugin.ARspec;
import org.homi.plugin.specification.*;

@SpecificationID(id = "ActionRegistry") 
public enum ARSpec implements ISpecification{
	CALL(new ParameterType<>(Object.class), new ParameterType<>(String.class), new ParameterType<>(String.class), new ParameterType<>(Object[].class)),
	EXECUTE(new ParameterType<>(Object.class), new ParameterType<>(IAction.class, true)),
	GETPLUGINS(new ParameterType<>(String[].class)),
	GETSPEC(new ParameterType<>(String[].class), new ParameterType<>(String.class));
	
	ParameterType<?> returnType;
	ParameterType<?>[] parameters;
 
	ARSpec(ParameterType<?> returnType, ParameterType<?> ...params ) {
		this.returnType = returnType;
		this.parameters = params;
		
	}

	@Override
	public ParameterType<?>[] getParameterTypes() {
		
		return this.parameters;
	}

	@Override
	public ParameterType<?> getReturnType() {
	
		return this.returnType;
	}

}
