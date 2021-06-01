package org.homi.plugins.ar.specification.actions;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractAction implements IAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7133010062896916619L;

	private Function<Object, Map<String, Object>> invocationUnit;
	private Map<String, Object> arguments;
	private List<String> parameters;
	
	public AbstractAction(List<String> parameters) {
		this.parameters = List.copyOf(parameters);
		arguments = new HashMap<>();
		for(String param: this.parameters) {
			arguments.putIfAbsent(param, null);
		}
	}
	
	protected <T extends Function<Object, Map<String, Object>> & Serializable> void setInvocationUnit(T iu) {
		this.invocationUnit = iu;
	}
	
	protected Map<String, Object> getArguments(){
		return this.arguments;
	}

	protected List<String> getParameters(){
		return this.parameters;
	}
	
	@Override
	public void SetArgument(String parameter, Object argument) {
		arguments.put(parameter, argument);
	}

	@Override
	public void SetArguments(Map<String, ?> args) {
		arguments.putAll(args);
	}

	@Override
	public final <R> R run() {
		return (R) this.invocationUnit.apply(arguments);
	};

	@Override
	public final <R> R run(Object... args) {
		for(int i=0; i< this.parameters.size(); i++) {
			this.arguments.put(this.parameters.get(i), args[i]);
		}
		return run();
	};

}
