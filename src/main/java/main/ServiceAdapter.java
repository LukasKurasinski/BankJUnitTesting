package main;

/**
 * Used between the Service interface and the implementation
 * Implementation object just has to extend this adapter,
 * and override the operation method it needs
 * @author lukas kurasinski
 *
 */
public class ServiceAdapter implements Service{

	public Account operation(String accName) {	
		return null;
	}

	public void operation(String sender, String reciever, int amount) {	
	}

	public void operation(String accName, int amount) {
	}

}
