package org.homi.plugin.ARspec;
import org.homi.plugin.specification.*;

@SpecificationID(id = "ActionRegistry") 
public enum ARSpec implements ISpecification{
	CALL(Object.class, String.class, String.class, Object[].class),
	GETPLUGINS(String[].class),
	GETSPEC(String[].class, String.class);
	
	
	
	Class<?> returnType;
	Class<?>[] parameters; 
	
	
 
	ARSpec(Class<?> returnType, Class<?> ...params ) {
		this.returnType = returnType;
		this.parameters = params;
		
	}

	@Override
	public Class<?>[] getParameterTypes() {
		
		return this.parameters;
	}

	@Override
	public Class<?> getReturnType() {
	
		return this.returnType;
	}

}
