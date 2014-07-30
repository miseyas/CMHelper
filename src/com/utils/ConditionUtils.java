package com.utils;

import java.util.Arrays;
import java.util.Vector;

public class ConditionUtils {

	private Vector<String> DEFAULT_CONDITION;
	
	private String[] DEFAULT_STRING = {"like","equals","isnot","contains"};
	
	private Vector<String> USER_CONDITION;

	public ConditionUtils() {
		this.init();
	}
	
	public Vector<String> getCondition() {
		if (null != USER_CONDITION) {
			return USER_CONDITION;
		} else {
			return DEFAULT_CONDITION;
		}
	}

	public void setCondition(Vector<String> vector) {
		USER_CONDITION = vector;
	}

	public void setCondition(String[] args) {
		Vector<String> condition =  new Vector<String>(Arrays.asList(args));
		this.setCondition(condition);
	}
	
	private void init() {
		DEFAULT_CONDITION =  new Vector<String>(Arrays.asList(DEFAULT_STRING));
	}
}
