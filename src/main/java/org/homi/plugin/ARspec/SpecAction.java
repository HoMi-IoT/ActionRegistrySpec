package org.homi.plugin.ARspec;

import java.util.ArrayList;
import java.util.List;

public class SpecAction implements IAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 926951652763166143L;
	
	private String specTarget;
	private String apiCall;
	private List<Object> parameters;
	
	public SpecAction(String s, String call, Object... params) {
		this.specTarget = s;
		this.parameters = List.of(params);
		this.apiCall = call;
	}
	
	public String getSpecTarget() {
		return this.specTarget;
	}
	
	public List<Object> getParams() {
		return this.parameters;
	}
	
	public String getAPICall() {
		return this.apiCall;
	}
	
	
	

}
