package observer;

import java.util.Observable;
import java.util.Observer;

public class Publisher extends Observable{
	private static Publisher instance;
	
	private Publisher() {
		
	}
	
	public static Publisher getInstance() {
		if(instance == null) {
			synchronized (Publisher.class) {
				if(instance == null)
					instance = new Publisher();
			}
		}
		return instance;
	}
	
	public void addReader(Observer obs) {
		this.addObserver(obs);
	}
	
	public void addProduction(String production) {
		this.setChanged();
		this.notifyObservers(production);
	}
}
