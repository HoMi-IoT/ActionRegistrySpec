package org.homi.plugins.ar.specification.actions.arguments;

import java.io.Serializable;

public interface IActionArgument<T extends Serializable> extends Serializable {
	public T accept(IActionArgumentVisitor aav);
}
