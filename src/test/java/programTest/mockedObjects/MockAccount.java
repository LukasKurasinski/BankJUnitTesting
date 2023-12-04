package programTest.mockedObjects;

import bank.Account;

/**
 * If we need to get a value from a protected field in our test,
 * and we dont have getters and setters,
 * we can extend the class with a mockHelpClass and define
 * our getters and setters there. 
 */
public class MockAccount extends Account{

	public String getName() {
		return super.name;
	}
}
