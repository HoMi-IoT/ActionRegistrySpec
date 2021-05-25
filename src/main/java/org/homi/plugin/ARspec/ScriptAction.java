package org.homi.plugin.ARspec;

public class ScriptAction implements IAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5167089593255703669L;

	@Override
	public void accept(IActionVisitor ab) {
		ab.visit(this);
		
	}

}
