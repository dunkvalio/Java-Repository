import java.util.Scanner;

//import java.util.Scanner;


public class Producer implements Runnable {

	private final Buffer buffer;
	private final StringArrayList strList;
//	private Consumer consumer;
	private String str;
	private Scanner input = new Scanner(System.in);
	
	//constructor
	public Producer (Buffer shared){
		buffer = shared;
		strList = new StringArrayList();
	}//end constructor
	
	@Override
	public void run() {
		
		//prompt for user input
		System.out.printf("Enter string or enter \"done\" to finish producing: ");
			
		//loop until escape sequence
		while(!Thread.interrupted()){
			
			str = input.nextLine();
			//try to set string into buffer
			try {	
				buffer.set(str);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end try block
			
			//when escape sequence is met break loop
			if(str.equals("done")){
				System.out.println(
						"\nProducer done produucing\nTerminating Producer");
				strList.printList();
				break;
			}//end if
			//add string to ArrayList
			strList.add(str);
			System.out.printf("%s \"%s\"", "Producer writes", str);
			System.out.printf("\n%s added \"%s\" to the List of Stings",
					Thread.currentThread().getName(), str);
		
		}//end inner while		
	}//end method run
}//end class Producer
