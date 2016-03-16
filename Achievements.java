/*Class Description: Achievements class which takes user, score and interval
 *checker as parameters. It contains strings, user, userProfile and score as 
 *properties. It has a method of updateAchievement which update the achievements
 *of the user.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Achievements
{

	//Properties
	private User user;
	
	private UserProfile tempProfile;
	
	private Score score;
	
	private String songName;
	private String difficulty;
	private String text;
	
	//Constructor
	public Achievements(User user, Score score, IntervalChecker i) throws IOException 
	{
		this.user = user;
		this.score = score;
		
		//getting the name of song, difficulty and hand 
		//from other classes
		text = "" + user.getHand();
		songName = i.getSong().getName();
		difficulty = i.getSong().getDifficulty();

		//creating a temporary profile to update the user's text file after the user
		//earning achievement 
		tempProfile = new UserProfile(user.getName() + ".txt");
		tempProfile.add(user.getName() + user.getPassword() + text + user.getAchievements());
		tempProfile.add(user.getPassword());
		tempProfile.add(text);
		tempProfile.add(user.getAchievements());
		
		String s = user.getName()+"|"+user.getPassword()+"|"+ text +"|"+user.getAchievements()+"|";
		
		FileWriter fooWriter = new FileWriter(user.getName()+".txt", false);
		                                                     
		fooWriter.write( s);
		fooWriter.close();

	}
	
	//Updating the achievements of the user in the text file by overwriting the file after playing the game
	public void updateAchievement() throws IOException {
		
		String s = user.getName()+"|"+user.getPassword()+"|"+ text +"|"+ achievementType()+"|";
		
		FileWriter fooWriter = new FileWriter(user.getName()+".txt", false); 
		                                                    
		fooWriter.write( s);
		fooWriter.close();
		
	}
	
	public String achievementType()
	{
		if(score.CalculateScorePercentage() >= 40)
		{
			if(difficulty.equals("real"))
				return "Master," + user.getName() + ", Real, " + songName;
			else if(difficulty.equals("medium"))
				return "Silver," + user.getName() + ", Medium, " + songName;
			else if(difficulty.equals("easy"))
				return "Bronze," + user.getName() + ", Easy, " + songName;
			else
				return "";
		}
		else 
			return "";
	}
	
}
