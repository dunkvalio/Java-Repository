import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


import javax.swing.JOptionPane;


public class OpenURL {

	private String myUrl;
	
	public OpenURL(String url_path){
		myUrl = url_path;
	}//end constructor
	
	public boolean checkValidity(String url_path){
	    
		boolean url_validity = false;
	    
	    	try {
	    		URL url = new URL(url_path);
	    		InputStream i = null;

	    		try {
	    			i = url.openStream();
	    		}//end inner try 
	    		catch (IOException e) {
	    			JOptionPane.showMessageDialog(null, "URL is invalid", "Error Message",
	    					JOptionPane.PLAIN_MESSAGE);
	    			url_validity = false;
	    		}//end catch

	    		if (i != null) {
	    			url_validity = true;
	    			System.out.println("URL is valid");
	    		}//end if
	    	} //end outer try
	    	catch (MalformedURLException e) {
	    		JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message",
	    				JOptionPane.PLAIN_MESSAGE);
	    		url_validity = false;
	    	}//end catch
	    	return url_validity;

	}//end checkValidity
	
	public void OpenDefaultBrowser() throws URISyntaxException, IOException{
		URI url = new URI(myUrl);
		Desktop.getDesktop().browse(url);
	}//end method OpenDefaultBrowser
}//end class OpenURL
