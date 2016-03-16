//Description: Creating user profile as a text file


import java.io.*;

public class UserProfile {
	
	//variables
	private File file;
	private String filename;
	
	//constructor
	public UserProfile(String filename){
		
		this.filename = filename;
		file = new File(filename);
	}
	
	//Adding new information of username, password and hand about the user into the text file
    public void add(String text)
    {	
    	text = text + "|";
    	try
    	{
    		//the true value of boolean will append the new string to the file
    	    FileWriter filewriter = new FileWriter(filename, true);
    	    
    	    //appending a new text to the file
    	    filewriter.write(text);
    	    
    	    filewriter.close();
    	}
    	catch(IOException exception)
    	{
    	    System.out.println("IOException: " + exception.getMessage());
    	}
    }
    
    

}
