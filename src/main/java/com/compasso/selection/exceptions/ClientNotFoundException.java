package com.compasso.selection.exceptions;



public class ClientNotFoundException extends Exception {
	
	public ClientNotFoundException() {
		super("Client Not Found");
		// TODO Auto-generated constructor stub
	}

	public ClientNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
