package org.homi.plugins.ar.specification.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActionQuery implements Serializable {

	private static final long serialVersionUID = -8291875986152674995L;
	
	public static enum TYPE implements Serializable{
		CUSTOM, SCRIPT, SPECIFICATION;

		private static final long serialVersionUID = -8297875926152634945L;
	}

	private ActionQuery.TYPE type = ActionQuery.TYPE.SPECIFICATION;
	private String specificationID = null;
	private String pluginID = null;
	private String command = null; 
	private List<String> tags = new ArrayList<>();
	
	public ActionQuery type(ActionQuery.TYPE type) {
		if(type != null)
			this.type = type;
		return this;
	}
	public ActionQuery command(String command) {
		this.command = command;
		return this;
	}
	
	public ActionQuery pluginID(String pluginID) {
		this.pluginID = pluginID;
		return this;
	}
	
	public ActionQuery specificationID(String specificationID) {
		this.specificationID = specificationID;
		return this;
	}
	
	public ActionQuery tag(String tag) {
		this.tags.add(tag);
		return this;
	}
	
	public ActionQuery tags(Collection<String> tags) {
		this.tags.addAll(tags);
		return this;
	}

	public ActionQuery.TYPE getType() {
		return type;
	}
	public String getSpecificationID() {
		return specificationID;
	}
	public String getPluginID() {
		return pluginID;
	}
	public String getCommand() {
		return command;
	}
	public List<String> getTags() {
		return tags;
	}
}
