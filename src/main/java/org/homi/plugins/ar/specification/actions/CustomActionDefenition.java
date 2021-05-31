package org.homi.plugins.ar.specification.actions;

public class CustomActionDefenition implements IActionDefenition{

	private static final long serialVersionUID = -5977269362396174506L;

	@Override
	public void accept(IActionDefenitionVisitor ab) {
		ab.visit(this);
	}
}
