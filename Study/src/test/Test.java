package test;

import MultiThread.DefaultThreadPool;
import MultiThread.Job;
import MultiThread.ThreadPool;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		ThreadPool pool = new DefaultThreadPool<Job>();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			pool.execute(new Job());
		}
	}
}
