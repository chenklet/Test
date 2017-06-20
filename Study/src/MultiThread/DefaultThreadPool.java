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

	private final LinkedList<Job> jobs = new LinkedList<Job>();

	private final List<Worker> workers = Collections
			.synchronizedList(new ArrayList<Worker>());

	private int workNum = DEFAULT_WORDER_NUMBER;

	private AtomicLong threadNum = new AtomicLong();

	public int getWorkNum() {
		return workNum;
	}

	public void setWorkNum(int workNum) {
		this.workNum = workNum;
	}

	public AtomicLong getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(AtomicLong threadNum) {
		this.threadNum = threadNum;
	}

	public DefaultThreadPool() {
		initializeWorkers(DEFAULT_WORDER_NUMBER);
	}

	public DefaultThreadPool(int num) {
		setWorkNum(num > MAX_WORKER_NUMBER ? MAX_WORKER_NUMBER
				: num < MIN_WORKER_NUMBER ? MIN_WORKER_NUMBER : num);
		initializeWorkers(getWorkNum());
	}

	private void initializeWorkers(int defaultWorderNumber) {
		for (int i = 0; i < defaultWorderNumber; i++) {
			Worker worker = new Worker();
			Thread thread = new Thread(worker, "ThreadPool-Worker" + threadNum.incrementAndGet());
			thread.start();
			workers.add(worker);
		}
	}

	@Override
	public void execute(Job job) {
		if(job != null) {
			synchronized(jobs) {
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}

	@Override
	public void addWorkers(int num) {
		synchronized(jobs) {
			if (num + this.workNum > MAX_WORKER_NUMBER)
				num = MAX_WORKER_NUMBER - this.workNum;
			initializeWorkers(num);
			this.workNum += num;
		}
	}

	@Override
	public void shutdown() {
		for (Worker worker : workers)
			worker.shutdown();
	}

	@Override
	public void removeWorker(int num) {
		synchronized(jobs) {
			if (num > this.workNum)
				throw new IllegalArgumentException("beyond workNum");
			int count = 0;
			while (count < num) {
				Worker worker = workers.get(0);
				if(workers.remove(worker)) {
					worker.shutdown();
					count++;
				}
			}
			this.workNum = num;
		}
	}

	@Override
	public int getJobSize() {
		return jobs.size();
	}
	
	class Worker implements Runnable {
		
		private volatile boolean running = true;

		@Override
		public void run() {
			while(running) {
				Job job = null;
				synchronized(jobs) {
					while(jobs.isEmpty()) {
						try {
							jobs.wait();
						} catch (Exception e) {
							Thread.currentThread().interrupt();
						}
					}
					job = jobs.removeFirst();
				}
				if (job != null) {
					try {
						System.out.println(this.toString() + "handling the job");
						job.run();
					} catch (Exception e) {
					}
				}
			}
		}

		public void shutdown() {
			running = false;
		}

	}

}
