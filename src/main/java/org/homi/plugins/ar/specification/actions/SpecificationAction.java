package org.homi.plugins.ar.specification.actions;

import java.util.List;

import org.homi.plugin.api.commander.Commander;
import org.homi.plugin.api.exceptions.InternalPluginException;
import org.homi.plugin.specification.ISpecification;
import org.homi.plugin.specification.exceptions.ArgumentLengthException;
import org.homi.plugin.specification.exceptions.InvalidArgumentException;

public class SpecificationAction<T extends Enum<T> & ISpecification> extends AbstractAction {

	private static final long serialVersionUID = -4882060310691045794L;

	public String id;
	
	public <T extends Enum<T> & ISpecification> SpecificationAction(Class<T> specification, List<String> parameters, Commander<T> commander, T command) {
		super(parameters);
		this.id = command.name();
		System.out.println("NUMBER OF PARAMERTERS IS: " + parameters.size());
		this.setInvocationUnit(
				(arguments)->{
					Object[] args = new Object[parameters.size()];
					System.out.println("_____________1___________________");
//					for(var arg: this.getArguments().entrySet()) {
//						args[Integer.parseInt(arg.getKey())] = arg.getValue(); 
//					}
					System.out.println("NUMBER OF PARAMERTERS IN INVOCATION UNIT IS: " + parameters.size());
					System.out.println("_____________2___________________");
					try {
						return commander.execute(command, args);
					} catch (InvalidArgumentException | ArgumentLengthException | InternalPluginException e) {
						throw new RuntimeException(e);
					}
				}
				);
	}

}
