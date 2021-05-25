package org.homi.plugin.ARspec;

import java.io.Serializable;

public interface IActionVisitor extends Serializable{
	public void visit(SpecAction sa);
	public void visit(CustomAction ca);
	public void visit(ScriptAction sa);
}
