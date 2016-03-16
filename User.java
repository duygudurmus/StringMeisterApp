import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class User 
{
	//Properties
	private String name; // from the textfield of New User Screen
	private String password; // from the textfield of New User Screen
	private String achievements = "No achievement! Play to Earn!";
	private String hand; //left: 0, right: 1 get from radiobutton
	private Achievements ach;
	private int firstchar;
	private int secondchar;
	private int thirdchar;
	private int guitarColor; //get the design part from panel
	private int background;
	
	//Constructors
	public User(String filename) throws IOException
	{
		readFile(filename + ".txt");
		searchForInfo(filename + ".txt");
	}
	
	//Methods
	//reading the text file and returns the text file as a string
    public String readFile(String fileName) throws IOException {
	    
    	BufferedReader reader = new BufferedReader(new FileReader(fileName));
	    
    	try {
	        StringBuilder storage = new StringBuilder();
	        String line = reader.readLine();

	        while (line != null) {
	            storage.append(line);
	            storage.append("\n");
	            line =reader.readLine();
	        }
	        return storage.toString();
	    } finally {
	        reader.close();
	    }
	}
    
    //Gets a parameter as filename and determine username, password
    //and achievements as strings. Use readFile method to make the text file
    //of user to string. 
    public void searchForInfo(String filename) throws IOException{
    	
    	String userInfo = readFile(filename);

    	//for the name of the user
    	for(int index = 0; index < userInfo.length(); index++)
    	{
    	    if (userInfo.charAt(index) == '|')
    	    {	
    	    	firstchar = index;
    	    	index = userInfo.length();
    	    }
    	}
    	
    	//for the password of the user
    	for(int index = firstchar+1; index < userInfo.length(); index++)
    	{
    		if (userInfo.charAt(index) == '|')
    	    {	
    	    	secondchar = index;
    	    	index = userInfo.length();
    	    }
    	}
    	
    	//for the hand of the user
    	for(int index = secondchar+1; index < userInfo.length(); index++)
    	{
    		if (userInfo.charAt(index) == '|')
    	    {	
    	    	thirdchar = index;
    	    	index = userInfo.length();
    	    }
    	}
    	
    	//after secondchar, for the achievements of the user
    	name = userInfo.substring(0,firstchar);
    	password = userInfo.substring(firstchar+1,secondchar);
    	hand = userInfo.substring(secondchar+1, thirdchar);
    	achievements = userInfo.substring(thirdchar + 1, userInfo.length() - 2);
    }
	public String getName()
	{
		if ( name == null)
			return "-1";
		return name;
	}
	
	public String getPassword()
	{
		System.out.println(password);
		return password;
	}
	
	public int getHand()
	{
		return Integer.parseInt(hand);
	}
	
	
	public String getAchievements()
	{
		return achievements;
		//ach.achievementType();
	}
	
	public void setAchievements(String str)
	{
		achievements = str;
	}
	
}
