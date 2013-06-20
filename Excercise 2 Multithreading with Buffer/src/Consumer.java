
public class Consumer implements Runnable {

	private final Buffer buffer;
	private String readStr = null;

	//constructor
	public Consumer (Buffer shared){
		buffer = shared;
	}//end constructor
	
	@Override
	public void run() {
		
		while(!Thread.interrupted()){
			//attempt to read string from buffer
			try {
				readStr = buffer.get();			
			} catch (InterruptedException e) {		
				e.printStackTrace();	
			}//end try block
			
			if(readStr.equals("done")){
				System.out.print("\nConsumer done consuming.\nTerminating Consumer.\n");
				break;
			}else if(readStr != null){
				System.out.printf("\n%s: \"%s\"", "Consumer reads", readStr);	
			}//end else if 
			Thread.yield();
		}//end while
	}//end method run
}//end class Consumer
