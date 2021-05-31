package org.homi.plugins.ar.specification.actions;

import java.io.Serializable;
import java.util.Map;

public interface IAction extends Serializable {
	public void SetArgument(String parameter, Object argument);
	public void SetArguments(Map<String, ?> args);
	public <R> R run();
	public <R> R run(Object...args);
}