import java.util.ArrayList;
import java.util.List;


public class StringArrayList {

	private final List<String> shrdArrList = new ArrayList<String>();//the shared ArrayList
	private String str;
	
	//add a value to the SharedArrayList
	public synchronized void add(String string){
		str = string;
		shrdArrList.add(str);
	}//end method add
	
	public void printList (){
		
		System.out.printf("\n%s\n%s\n","Contents of the Array List of Strings: ",
				shrdArrList);
	}
}//end class StringArrayList
