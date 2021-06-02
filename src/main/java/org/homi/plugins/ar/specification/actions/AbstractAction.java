package org.homi.plugins.ar.specification.actions;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractAction implements IAction {

	private static final long serialVersionUID = -7133010062896916619L;

	private Function< Map<String, Serializable>, Serializable> invocationUnit;
	private Map<String, Serializable> arguments;
	private List<String> parameters;
	
	public AbstractAction(List<String> parameters) {
		this.parameters = List.copyOf(parameters);
		arguments = new HashMap<>();
		for(String param: this.parameters) {
			arguments.putIfAbsent(param, null);
		}
	}
	
	protected <T extends Function<Map<String, Serializable>, Serializable> & Serializable> void setInvocationUnit(T iu) {
		this.invocationUnit = (Function<Map<String, Serializable>, Serializable> & Serializable) iu;
	}
	
	protected Map<String, ? extends Serializable> getArguments(){
		return this.arguments;
	}

	protected List<String> getParameters(){
		return this.parameters;
	}
	
	@Override
	public <T extends Serializable> void SetArgument(String parameter, T argument) {
		System.out.println("setting argument "+parameter+" to value "+ argument);
		arguments.put(parameter, argument);
	}

	@Override
	public void SetArguments(Map<String, ? extends Serializable> args) {
		arguments.putAll(args);
	}

	@Override
	public final <R> R run() {
		System.out.println("running");
		return (R) this.invocationUnit.apply(arguments);
	};

	@Override
	public final <R, S extends Serializable> R run(S... args) {
		System.out.println("running with args");
		for(int i=0; i< this.parameters.size(); i++) {
			this.arguments.put(this.parameters.get(i), args[i]);
		}
		return run();
	};

}
