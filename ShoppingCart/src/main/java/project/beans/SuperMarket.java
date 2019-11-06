package project.beans;

public class SuperMarket {

	private static SuperMarket instance;
	
	
	private SuperMarket() {
		
	}
	
	public static SuperMarket getInstance() {
		if (instance==null) 
			instance = new SuperMarket();
		return instance;
	}
}
