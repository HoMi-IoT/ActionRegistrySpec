package org.homi.plugins.ar.specification.actions;

import org.homi.plugins.ar.specification.actions.plugin.SpecificationActionDefinition;

public interface IActionDefenitionVisitor {
	public void visit(SpecificationActionDefinition<?> sa);
	public void visit(CustomActionDefenition ca);
	public void visit(ScriptActionDefinition sa);
}
