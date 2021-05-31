package org.homi.plugins.ar.specification.actions;

import java.io.Serializable;

public interface IActionDefenition extends Serializable {
	public void accept(IActionDefenitionVisitor adv);
}
