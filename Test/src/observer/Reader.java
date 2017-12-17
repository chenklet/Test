package observer;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer{
	String name;
	
	public Reader(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String prod = "";
		if (arg1 instanceof String) {
			prod = (String) arg1;
		}
		System.out.println(name + " receicved the message about " + prod);
	}

}
