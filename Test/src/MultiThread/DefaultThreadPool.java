package MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
	
	public static final int MAX_WORKER_NUMBER = 10;
	
	public static final int DEFAULT_WORDER_NUMBER = 5;
	
	public static final int MIN_WORKER_NUMBER = 1;
	
	private final List<Job> jobs = new LinkedList<Job>();
	
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
	
	private int workNum = DEFAULT_WORDER_NUMBER;
	
	private AtomicLong threadNum = new AtomicLong();
	
	

	@Override
	public void execute(Job job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWorkers(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeWorker(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
