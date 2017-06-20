package MultiThread;

public class Job implements Runnable {

	@Override
	public void run() {
		System.out.println(this.toString());
		System.out.println();
	}

}
