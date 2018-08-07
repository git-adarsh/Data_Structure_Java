package com.dsj.gp;

import java.text.MessageFormat;

public class Activity_Sel_Pair{
	int startValue;
	int finishValue;

	public Activity_Sel_Pair(int startValue, int finishValue) {
		this.startValue = startValue;
		this.finishValue = finishValue;
	}

	public int getStartValue() {
		return startValue;
	}

	public int getFinishValue() {
		return finishValue;
	}
	
	public void display() {
		System.out.println(MessageFormat.format("({0},{1})", startValue, finishValue));
	}

}
