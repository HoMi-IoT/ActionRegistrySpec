package org.homi.plugins.ar.specification.actions.plugin;

import java.util.List;

import org.homi.plugins.ar.specification.actions.IActionDefenition;
import org.homi.plugins.ar.specification.actions.IActionDefenitionVisitor;
import org.homi.plugins.ar.specification.actions.arguments.IActionArgument;

public class SpecificationActionDefinition implements IActionDefenition{

	private static final long serialVersionUID = 926951652763166143L;

	private String specificationID;
	private String PluginID;
	private String command;
	private List<IActionArgument<?>> parameters;
	
	public SpecificationActionDefinition(String specificationID, String command, IActionArgument<?>... parameters) {
		this.specificationID = specificationID;
		this.command = command;
		this.parameters = List.of(parameters);
	}
	
	public SpecificationActionDefinition(String specificationID, String command, List<IActionArgument<?>> parameters) {
		this.specificationID = specificationID;
		this.command = command;
		this.parameters = parameters;
	}
	
	public String getSpecificationID() {
		return this.specificationID;
	}

	public String getPluginID() {
		return PluginID;
	}

	
	public String getCommand(String s) {
		return this.command;
	}
	
	public List<IActionArgument<?>> getParameters() {
		return this.parameters;
	}
	
	@Override
	public final void accept(IActionDefenitionVisitor adv) {
		adv.visit(this);
	}
}
