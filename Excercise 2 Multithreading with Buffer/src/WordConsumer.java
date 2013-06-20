
public class WordConsumer implements Runnable {

	private final Buffer buffer;
	private String readStr = null;

	//constructor
	public WordConsumer (Buffer shared){
		buffer = shared;
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
				System.out.print("\nWord Consumer done consuming.\nTerminating Consumer.\n");
				break;
			}else if(readStr != null){
				String[] words = readStr.split(" ");
				System.out.printf("\n%s%d%s: ", "Word Consumer Reads ", words.length, " word(s)");
				for(String word : words){
					System.out.printf("\"%s\" ",word);
				}//end for
			}//end else
		}//end while
	}//end method run
}//end class
