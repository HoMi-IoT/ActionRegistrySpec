package org.homi.plugins.ar.specification.actions.arguments;

import java.io.Serializable;

public interface IActionArgumentVisitor {

	<T extends Serializable> T visit(VariableArgument<T> variableArgument);

	<T extends Serializable> T visit(ValueArgument<T> valueArgument);

}
