package org.homi.plugins.ar.specification.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.homi.plugin.api.IPluginProvider;
import org.homi.plugin.api.basicplugin.IBasicPlugin;
import org.homi.plugin.api.commander.Commander;
import org.homi.plugin.api.exceptions.PluginException;
import org.homi.plugin.specification.ISpecification;
import org.homi.plugin.specification.exceptions.ArgumentLengthException;
import org.homi.plugin.specification.exceptions.InvalidArgumentException;
import org.homi.plugins.ar.specification.ARSpec;

public class Action<R> {

	private static IPluginProvider pluginProvider;
	private static IBasicPlugin actionRegistry; 
	private static Commander<? extends ISpecification> commander; 

	private BiFunction<Map<String,?>, ClassLoader, R> action;
	private Map<String, Object> arguments = new HashMap<>();
	
	private Action(BiFunction<Map<String,?>, ClassLoader, R> action) {
		this.action = action;
	}
	
	public static <R> Action<R> getAction(ActionQuery aq) throws PluginException, InvalidArgumentException, ArgumentLengthException {
		if(commander == null)
			getARSpecCommander();
		return new Action<R>(commander.execute(ARSpec.GET_ACTION, aq));
	}

	public static void setPluginProvider(IPluginProvider pluginProvider) {
		Action.pluginProvider = pluginProvider;
	}
	
	private static void getARSpecCommander() throws PluginException {
		if(actionRegistry == null)
			getActionRegistry();
		commander = actionRegistry.getCommander(ARSpec.class);
	}

	private static void getActionRegistry() {
		actionRegistry = (IBasicPlugin) pluginProvider.getPluginByID("ActionRegistry");
	}
	
	public void set(String Key, Object Value) {
		this.arguments.put(Key, Value);
	}
	
	public R run() throws PluginException, InvalidArgumentException, ArgumentLengthException {
		return action.apply(this.arguments, Action.class.getClassLoader());
	}

}
