package test.mockedObjects;

import java.util.HashMap;
import java.util.Map;

import main.Account;
import main.ServiceAdapter;


public class MockTransferService extends ServiceAdapter{

	Map<String, Account> mockDatabase = new HashMap<String, Account>();
	
	public void addAccount(Account account) {
		mockDatabase.put(account.getName(), account);
	}
	
	public Account getAccount(String name) {
		return mockDatabase.get(name);
	}
	
	@Override
	public void operation(String sender, String reciever, int amount) {
		Account dbSender = mockDatabase.get(sender);
		Account dbReciever = mockDatabase.get(reciever);
		
			dbSender.setBalance(dbSender.getBalance() - amount);
			dbReciever.setBalance(dbReciever.getBalance() + amount);
	}
}