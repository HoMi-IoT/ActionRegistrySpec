package org.homi.plugins.ar.specification.actions;

import java.io.Serializable;
import java.util.Map;

public interface IAction extends Serializable {
	public <T extends Serializable> void SetArgument(String parameter, T argument);
	public void SetArguments(Map<String, ? extends Serializable> args);
	public <R> R run();
	public <R, S extends Serializable> R run(S... args);
}