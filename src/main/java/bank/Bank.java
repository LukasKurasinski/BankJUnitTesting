package bank;


/**
 * Bank object responsible for operating on accounts
 * Operation thats going to be performed is defined 
 * in the Service Implementation
 * @author lukas kurasinski
 *
 */
public class Bank {

	Service service;
	
	public void setService(Service service) {
		this.service = service;
	}
	
	public void operation(String sender, String reciever, int amount) {
		//this service gets accounts from the DB, changes balance, saves in DB
		service.operation(sender, reciever, amount);
	}
	
	public Account operation(String accNamn) {
		//this service retrieves accounts from the DB
		return service.operation(accNamn); //TODO Null guard
	}
	public void operation(String accNamn, int amount) {
		//this service gets accounts from the DB, changes balance, saves in DB
		service.operation(accNamn, amount);
	}
}



