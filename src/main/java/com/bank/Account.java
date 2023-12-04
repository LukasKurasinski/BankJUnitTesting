package com.bank;




import java.util.LinkedList;
import java.util.List;

/**
 * Represents client Accounts in the Bank.
 * Simple POJO.
 * @author lukas kurasinski
 *
 */
public class Account {
	private int balance = 0;
	protected String name = "";
	private List<Integer> transactionAmountList = new LinkedList<Integer>();
	private List<String> transactionTypeList = new LinkedList<String>();
	
	
	public Account() {
	}
	
	public Account(int balance, String name) {
		this.balance = balance;
		this.name = name;
	}
	
	public List<Integer> getTransactionAmountList(){
		return transactionAmountList;
	}
	
	public List<String> getTransactionTypeList(){
		return transactionTypeList;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void debit(int amount) throws AccountBalanceException, DebitAmountException {
		
		if(amount <= 0) {
			throw new DebitAmountException("Debit amount must be larger than 0");
		}else if(amount <= balance) {
			balance -= amount;
			transactionAmountList.add(amount);
			transactionTypeList.add("Debit");
		}else {
			throw new AccountBalanceException("amount is to large to be debited from the account");
		}
	}
	
	public void credit(int amount) {
		balance += amount;
	}
	
	public void widthdraw(int amount) {
		balance -= amount;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
