package assignment.domain;

import java.util.Observable;

public class Bird extends Observable {

	public void fly() {		
		setChanged();
		notifyObservers();
	}
	
}
