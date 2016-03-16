/*Class Description: UserProfile class creates a text file for the user
*which is used by the NewUserScreen class and it contains an add method
*which adds information into the text file of user account.
*/
import java.io.*;

public class UserProfile {
	
	//Properties
	private File file;
	private String filename;
	
	//Constructor
	public UserProfile(String filename){
		
		this.filename = filename;
		
		//creating a text file for the user
		file = new File(filename);
	}
	
	//Adding new information of user name, password,hand and achievements
	//about the user into the text file
    public void add(String text)
    {	
    	//after adding text, it also add the char of '|' in order to use 
    	//the logic of CSV
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
