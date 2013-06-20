import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BlockingBuffer implements Buffer {

	private final Lock accessLock = new ReentrantLock();
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	private Boolean occupied = false;
	private int entryCount = 0;
	private String readStr;
	
	@Override
	public void set(String string) throws InterruptedException {
		
		//lock the object
		accessLock.lock();
		
		try{
			//while buffer is not empty, place thread in waiting state
			while(occupied){
					canWrite.await();
			}//end while	
			
			readStr = string;
			
			occupied = true;
			
			canRead.signalAll();
		}//end try
		finally{
			accessLock.unlock();
		}//end finally
	}//end method set

	public String get () throws InterruptedException {
		
		//lock object
		accessLock.lock();
		
		try{
			//while buffer is empty, place thread in waiting state
			while(!occupied){
				canRead.await();
			}//end while

			++entryCount;
			
			//ensure buffer is read by all four consumers before emptying it
			if(entryCount == 4){
				occupied = false;
				entryCount = 0;
				canWrite.signalAll();
			}//end if
			
			Thread.sleep(300);
			return readStr;
		}//end try
		finally{
			accessLock.unlock();
		}//end finally
	}//end method get

}//end class BlockingBuffer
