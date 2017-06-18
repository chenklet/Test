package MultiThread;

public interface ThreadPool<Job extends Runnable> {
	void execute(Job job);

	void addWorkers(int num);

	void shutdown();

	void removeWorker(int num);

	int getJobSize();
}
