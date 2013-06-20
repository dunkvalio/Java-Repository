import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import javax.swing.JOptionPane;

public class OpenTextFile {

	private String path;	
	
	public OpenTextFile (String file_path){
		path = file_path;
	}//end 1 argument constructor
	
	public boolean checkValidity (String file_name){
		//check file validity
		boolean result = false;
		try {
			File ut_file = new File(file_name);
			if(ut_file.exists()){
				System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s",
						ut_file.getName(), " exists",
						(ut_file.isFile() ? "is a file" : "is not a file" ),
						(ut_file.isDirectory() ? "is a directory" :
						"is not a directory" ),
						(ut_file.isAbsolute() ? "is absolute path" :
						"is not absolute path" ), "Last modified: ", ut_file.lastModified()
						, "Length: ", ut_file.length(),
						"Path: ", ut_file.getPath(), "Parent: ", ut_file.getParent());
				result = true;
			}//end if
			else{
				result = false;
				throw new IOException("Entry Invalid. Please Re-enter.");
			}//end else
		}//end try
		//catch exception if file is not valid
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message",
					JOptionPane.PLAIN_MESSAGE);
		}//end catch

		return result;
	}//end method CheckValidity
	
	//method open file
	public String[] OpenFile() throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		
		for(int i = 0; i < numberOfLines; i++){
			textData[i] = textReader.readLine();
		}//end for

		textReader.close();
		return textData;
	}//end method OpenFile
		
	//method get number of lines in the file
	public int readLines () throws IOException {
			
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
			
		@SuppressWarnings("unused")
		String aLine;
		int numberOfLines = 0;
		
		while((aLine = bf.readLine()) != null){
			numberOfLines++;
		}//end while
			
		bf.close();
		return numberOfLines;
	}//end method readLines
	
}
