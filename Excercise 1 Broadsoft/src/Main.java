/**
 * 
 */

/**
 * @author Valio
 *
 */

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		String option;
		String file_name;
		String file_to_show = null;
		String url_path;
		boolean condition = false;
		
		//first option screen
		option = JOptionPane.showInputDialog("Please enter \"t\" for Text File " +
				"or \"w\" for URL");
	/*
	 * 
	 * First Option
	 * 	
	 */
		
		//open a File
		if (option.equalsIgnoreCase("t")){
		
			//Prompt user for File path/name
			file_name = JOptionPane.showInputDialog("Enter text file path: ");
			
			//check validity
			do {
				OpenTextFile file = new OpenTextFile(file_name);
				boolean check_result = file.checkValidity(file_name);
					if(check_result == true){
						System.out.println("Entry is valid.");
						condition = true;
						
						
					}//end if
					else{
						file_name = null;
						file_name = JOptionPane.showInputDialog("Enter text file path: ");
					}//end else
			}while (condition == false);
			
			//Show the file
			
			try{
				OpenTextFile file = new OpenTextFile(file_name);
				String[] aryLines = file.OpenFile();
				StringBuffer stbuffer = new StringBuffer();
				
				for(int i = 0; i < aryLines.length; i++){
					stbuffer.append(aryLines[i]+"\n");
				}//end for
				
				file_to_show = stbuffer.toString();
				JOptionPane.showMessageDialog(null, file_to_show);			
			}//end try
			catch (IOException e){
				JOptionPane.showMessageDialog(null, e.getMessage(), 
						"Error Message",
						JOptionPane.PLAIN_MESSAGE);
			}//end catch
		}//end of IF
		
	/*
	 * 
	 * Second Option
	 * 
	 */
		
		//open a URL
		else if (option.equalsIgnoreCase("w")){
			//prompt user for URL path
			url_path = JOptionPane.showInputDialog("Enter URL path: ");
			condition = false;
			//Check URL validity
			do {
				try{
					OpenURL myUrl = new OpenURL(url_path);
					boolean url_val = myUrl.checkValidity(url_path);
					if (url_val == true){
						condition = true;
					}//end if
					else{
		    			url_path = null;
		    			url_path = JOptionPane.showInputDialog("Enter URL path: ");
					}//end else
				}//end try
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message",
							JOptionPane.PLAIN_MESSAGE);
				}//end catch
			} while (condition == false);
			//Open URL
			try{
				OpenURL myUrl = new OpenURL(url_path);
				myUrl.OpenDefaultBrowser();
			}
			catch(URISyntaxException e1){
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error Message",
						JOptionPane.PLAIN_MESSAGE);
			}
			catch(IOException e2){
				JOptionPane.showMessageDialog(null, e2.getMessage(), "Error Message",
						JOptionPane.PLAIN_MESSAGE);
			}
		}//end  if
		else {
			JOptionPane.showMessageDialog(null, "Invalid entry. Please enter \"t\" for Text File" +
					"or \"w\" for URL", "Error Message",
					JOptionPane.PLAIN_MESSAGE);
		}//end else
	}//end method Main

}//End Class Main
