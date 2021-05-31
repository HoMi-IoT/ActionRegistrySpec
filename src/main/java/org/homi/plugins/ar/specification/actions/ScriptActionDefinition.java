package org.homi.plugins.ar.specification.actions;

public class ScriptActionDefinition implements IActionDefenition{

	private static final long serialVersionUID = -5167089593255703669L;

	@Override
	public final void accept(IActionDefenitionVisitor adv) {
		adv.visit(this);
	}

}
