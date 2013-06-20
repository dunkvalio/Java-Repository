
public interface Buffer {

	//place String in Buffer
	public void set (String string) throws InterruptedException;
	
	//return String from Buffer
	public String get () throws InterruptedException;
}//end interface Buffer
