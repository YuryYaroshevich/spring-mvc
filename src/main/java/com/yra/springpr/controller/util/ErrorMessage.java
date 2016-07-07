package com.yra.springpr.controller.util;

public class ErrorMessage extends Message {
	private static final long serialVersionUID = 8732647274282384712L;

	public ErrorMessage(String message) {
		super(true, message);
	}	
}
