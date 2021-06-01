package org.homi.plugins.ar.specification.actions.plugin;

import java.util.List;

import org.homi.plugin.api.IPlugin;
import org.homi.plugin.specification.ISpecification;
import org.homi.plugins.ar.specification.actions.IActionDefenition;
import org.homi.plugins.ar.specification.actions.IActionDefenitionVisitor;
import org.homi.plugins.ar.specification.actions.arguments.IActionArgument;

public class SpecificationActionDefinition<T extends Enum<T> & ISpecification> implements IActionDefenition{

	private static final long serialVersionUID = 926951652763166143L;

	private IPlugin plugin;
	private T command;
	private List<IActionArgument<?>> parameters;
	
	public SpecificationActionDefinition(IPlugin plugin, T command, IActionArgument<?>... parameters) {
		this.plugin = plugin;
		this.command = command;
		this.parameters = List.of(parameters);
	}
	
	public SpecificationActionDefinition(IPlugin plugin, T command, List<IActionArgument<?>> parameters) {
		this.plugin = plugin;
		this.command = command;
		this.parameters = parameters;
	}

	public IPlugin getPlugin() {
		return plugin;
	}

	
	public T getCommand() {
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
