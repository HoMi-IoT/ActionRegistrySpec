package org.homi.plugin.ARspec;

import org.homi.plugin.specification.ISpecification;
import org.homi.plugin.specification.SpecificationID;
import org.homi.plugin.specification.SerializableTypeDef;
import org.homi.plugin.specification.SpecificationHelper;
import org.homi.plugin.specification.TypeDef;

@SpecificationID(id = "ActionRegistry") 
public enum ARSpec implements ISpecification{
	CALL(Object.class, String.class, String.class, Object[].class),
	//EXECUTE(new ParameterType<>(Object.class), new ParameterType<>(IAction.class, true)),
	
	DEFINE(Void.class, new SerializableTypeDef<>(IAction.class)),
	GETPLUGINS(String[].class),
	GETSPEC(String[].class, String.class);
	
	private TypeDef<?>[] parameterTypes;
	private TypeDef<?> returnType;
	ARSpec(Object returnType, Object...parameterTypes ) {
		try {
			this.returnType = SpecificationHelper.processType(returnType);
			this.parameterTypes = new TypeDef<?>[parameterTypes.length];
			
			for(int i =0; i<parameterTypes.length; i++) {
				this.parameterTypes[i] = SpecificationHelper.processType(parameterTypes[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TypeDef<?>[] getParameterTypes() {
		return this.parameterTypes;
	}
	
	@Override
	public TypeDef<?> getReturnType() {
		return this.returnType;
	}
}
