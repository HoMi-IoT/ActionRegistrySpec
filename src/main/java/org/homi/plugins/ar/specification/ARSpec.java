package org.homi.plugins.ar.specification;

import java.util.List;

import org.homi.plugin.specification.ISpecification;
import org.homi.plugin.specification.SpecificationID;
import org.homi.plugin.specification.TypeDef;
import org.homi.plugins.ar.specification.actions.IActionDefenition;
import org.homi.plugins.ar.specification.actions.IAction;

import static org.homi.plugin.specification.SpecificationHelper.*;

import static org.homi.plugin.specification.Constraints.*;

@SpecificationID(id = "ActionRegistry") 
public enum ARSpec implements ISpecification{
	CALL(Object.class, String.class, String.class, Object[].class),
//	RUN(new ParameterType<>(Object.class), new ParameterType<>(IAction.class, true)),
	GET_ACTION(defineSerializableType(IAction.class), String.class),
	DEFINE(Void.class, defineSerializableType(IActionDefenition.class, notNull()));
//	GETPLUGINS(String[].class),
//	GET_SPEC(String[].class, String.class);
	
	private List<TypeDef<?>> parameterTypes;
	private TypeDef<?> returnType;
	
	ARSpec(Object returnType, Object...parameterTypes ) {
		try {
			this.returnType = processType(returnType);
			this.parameterTypes = processTypes(parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<TypeDef<?>> getParameterTypes() {
		return this.parameterTypes;
	}
	
	@Override
	public TypeDef<?> getReturnType() {
		return this.returnType;
	}
	
}
