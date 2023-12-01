package main;

/**
 * This exception is thrown when balance is not correct
 */
public class AccountBalanceException extends Exception{

	private static final long serialVersionUID = -177924605220530872L;

	public AccountBalanceException() {
	}
	
	public AccountBalanceException(String message) {
		super(message);
	}
}
