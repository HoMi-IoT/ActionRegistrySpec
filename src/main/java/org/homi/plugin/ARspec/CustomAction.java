package org.homi.plugin.ARspec;

public class CustomAction implements IAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5977269362396174506L;

	@Override
	public void accept(IActionVisitor ab) {
		ab.visit(this);
		
	}

}
