package com.yra.springpr.controller.util;

import java.io.Serializable;

public abstract class Message implements Serializable {
	private static final long serialVersionUID = 9169106508404516162L;

	private final boolean error;
	private final String message;
	
	public Message(boolean error, String message) {
		this.error = error;
		this.message = message;
	}	
	
	public boolean isError() {
		return error;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (error ? 1231 : 1237);
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (error != other.error)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
}
