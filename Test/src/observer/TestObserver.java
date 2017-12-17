package observer;

public class TestObserver {
	public static void main(String[] args) {
		Publisher publisher = Publisher.getInstance();
		Reader reader1 = new Reader("test1");
		Reader reader2 = new Reader("test2");
		publisher.addObserver(reader1);
		publisher.addObserver(reader2);
		publisher.addProduction("program");
	}
}
