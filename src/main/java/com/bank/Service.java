package com.bank;

/**
 * Interface common for all of the Service Implementations.
 * Implementations define the specific operations they are
 * designed to do.
 * @author lukas kurasinski
 *
 */
public interface Service {
	
	public Account operation(String accName);

	
	public void operation(String accName, int amount);
	
	public void operation(String sender, String reciever, int amount);
	
	
	
}
