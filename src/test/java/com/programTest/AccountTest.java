package com.programTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bank.Account;
import com.bank.AccountBalanceException;
import com.bank.Bank;
import com.bank.DebitAmountException;
import com.bank.ServiceAdapter;
import com.programTest.mockedObjects.MockTransferService;

class AccountTest {

	MockTransferService mts;
	
	@Mock
	ServiceAdapter mockAccountService;	//Returns an account object from DB

	
	private void initMockTransferService3Accounts() {
		//Mock setup
		Account acc1 = new Account(500,"Bob");
		Account acc2 = new Account(200,"Rob");
		Account acc3 = new Account(1000,"Gob");
		mts = new MockTransferService();
		mts.addAccount(acc1);
		mts.addAccount(acc2);
		mts.addAccount(acc3);
	}
	
	private void initMockTransferService0Accounts() {
		//Mock setup
		mts = new MockTransferService();
	}
	


	@DisplayName("Test correct balance value")
	@Test
	void testGetBalance() {
		initMockTransferService3Accounts();
		//test
		Bank bank = new Bank();
		bank.setService(mts);
		bank.operation("Bob", "Rob", 300);
		assertEquals(200, mts.getAccount("Bob").getBalance());
		assertEquals(500, mts.getAccount("Rob").getBalance());
	}
	

	@Test
	@DisplayName("transactionAmount registers correctly")
	void testDebitTransactionAmount() throws AccountBalanceException, DebitAmountException  {
		MockitoAnnotations.openMocks(this);
		when(mockAccountService.operation("Zob")).thenReturn(new Account(200, "Zob"));
		Bank bank = new Bank();
		bank.setService(mockAccountService);
		Account acc = bank.operation("Zob");
		acc.debit(200);
		assertEquals((Integer) 200, acc.getTransactionAmountList().get(0));
	}
	
	@Test
	@DisplayName("transaction Type registers correctly")
	void testDebitTransactionType() throws AccountBalanceException, DebitAmountException  {
		MockitoAnnotations.openMocks(this);
		when(mockAccountService.operation("Zob")).thenReturn(new Account(200, "Zob"));
		Bank bank = new Bank();
		bank.setService(mockAccountService);
		Account acc = bank.operation("Zob");
		acc.debit(200);
		assertEquals("Debit", acc.getTransactionTypeList().get(0));
	}
	
	@Test
	@DisplayName("Balance after correct Debit")
	void testBalanceAfterDebit() throws AccountBalanceException, DebitAmountException  {
		MockitoAnnotations.openMocks(this);
		when(mockAccountService.operation("Zob")).thenReturn(new Account(200, "Zob"));
		Bank bank = new Bank();
		bank.setService(mockAccountService);
		Account acc = bank.operation("Zob");
		System.out.println(acc.getBalance());
		acc.debit(200);
		assertEquals(0, acc.getBalance());
	}
	
	@Test
	@DisplayName("Exception after debit with balance 0")
	void testDebitWithBalanceZero() throws AccountBalanceException, DebitAmountException  {
		
		MockitoAnnotations.openMocks(this);
		when(mockAccountService.operation("Zob")).thenReturn(new Account(0, "Zob"));
		Bank bank = new Bank();
		bank.setService(mockAccountService);
		Account acc = bank.operation("Zob");
		assertThrows(AccountBalanceException.class, () -> acc.debit(200));
	}
	
	@Test
	@DisplayName("Exception after debit amount 0")
	void testDebitZero() throws DebitAmountException, DebitAmountException {
		MockitoAnnotations.openMocks(this);
		when(mockAccountService.operation("Zob")).thenReturn(new Account(10000, "Zob"));
		Bank bank = new Bank();
		bank.setService(mockAccountService);
		Account acc = bank.operation("Zob");
		assertThrows(DebitAmountException.class, () -> acc.debit(0));
	}
	
	
	/*TODO Account methods, Boundaries, exceptions, null vals
	 * Bank null guards etc.
	 * protected variables by creating mockHelpClass.
	 * 
	 * 
	 * 
	 */
}
