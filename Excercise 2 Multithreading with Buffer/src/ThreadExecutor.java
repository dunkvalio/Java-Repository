import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//create new thread pool
		ExecutorService application = Executors.newCachedThreadPool();
		
		//create BlockingBuffer
		Buffer sharedBuffer = new BlockingBuffer();
		
		//execute		
		application.execute(new Producer(sharedBuffer));
		application.execute(new Consumer(sharedBuffer));
		application.execute(new LineConsumer(sharedBuffer));
		application.execute(new WordConsumer(sharedBuffer));
		application.execute(new LetterConsumer(sharedBuffer));
		
		application.shutdown();
	}//end method main

}//end class ThreadExecutor
