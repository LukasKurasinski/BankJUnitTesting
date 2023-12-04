package com.bank;

/**
 * This exception is thrown when the debit amount is not correct
 */
public class DebitAmountException extends Exception{

	private static final long serialVersionUID = -185851590534373636L;

	public DebitAmountException() {
	}
	
	public DebitAmountException(String message) {
		super(message);
	}
	
}
