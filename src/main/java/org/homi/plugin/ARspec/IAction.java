package org.homi.plugin.ARspec;

import java.io.Serializable;
import java.util.ArrayList;

public interface IAction extends Serializable{

	public default Class<?> getKind() {
		return this.getClass();
	}	
	
}
