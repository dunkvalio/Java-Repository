
public class LineConsumer implements Runnable{

	private final Buffer buffer;
	private String readStr = null;
	
	//constructor
	public LineConsumer (Buffer shared){
		buffer = shared;
	}//end constructor
	
	@Override	
	public void run() {
		
		while(!Thread.interrupted()){
			//attempt to read string from buffer
			try {
				readStr = buffer.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
			
			//terminate loop if condition is met
			if(readStr.equals("done")){
				System.out.print("\nLine Consumer done consuming.\nTerminating Consumer.\n");
				break;
			}else if(readStr != null){
				String[] lines = readStr.split("\n");
				System.out.printf("\n%s%d%s: ", "Line Consumer reads ", lines.length, " line(s)");
				for(int i = 0 ; i < lines.length; i++){
					System.out.printf("\"%s\" ", lines[i]);
				}//end for
			}//end else
		}//end  while
	}//end method run
}//end class LineConsumer
