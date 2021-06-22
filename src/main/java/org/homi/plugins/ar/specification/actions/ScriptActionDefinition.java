package org.homi.plugins.ar.specification.actions;

import java.util.List;

public class ScriptActionDefinition implements IActionDefenition{

	private static final long serialVersionUID = -5167089593255703669L;
	
	private String command;
	private List<String> tags;
	private ActionQuery actionQuery;

	public ScriptActionDefinition(String command, List<String> tags, ActionQuery aq){
		this.command = command;
		this.tags = tags;
		this.actionQuery = aq;
	}
	
	public ActionQuery getActionQuery() {
		return actionQuery;
	}
	
	public String getCommand() {
		return command;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	@Override
	public final void accept(IActionDefenitionVisitor adv) {
		adv.visit(this);
	}

}
