package org.homi.plugin.ARspec;

import java.io.Serializable;
import java.util.ArrayList;

public interface IAction extends Serializable{

	public void accept(IActionVisitor ab);
	
}
