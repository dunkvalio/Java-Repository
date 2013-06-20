
public class LetterConsumer implements Runnable{

	private final Buffer buffer;
	private String readStr = null;
	

	//constructor
	public LetterConsumer (Buffer shared){
		buffer = shared;
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	}//end constructor
	
	@Override
	public void run() {

		while(!Thread.interrupted()){
			
			try {
				readStr = buffer.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
			
			if(readStr.equals("done")){
				System.out.print("\nLetter Consumer done consuming.\n" +
						"Terminating Consumer.\n");
				break;
			}else if(readStr != null){
				readStr = readStr.replaceAll("\\s","");
				char[] charArray = readStr.toCharArray();
				System.out.printf("\n%s%d%s: ","Letter Consumer reads ", 
						charArray.length, " letter(s)");
				for(char  character : charArray){
					System.out.printf("\"%c\" ", character);
				}//end for
				
				//prompt for user input
				System.out.print("\nEnter string or enter \"done\" to finish producing: ");
				
			}//end else
		}//end while
	}//end method run
}//end class LetterConsumer
