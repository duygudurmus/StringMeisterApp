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
	
	//Constructors
	public Achievements( final User user, Score score, IntervalChecker i) throws IOException 
	{
		text = "" + user.getHand();
		this.user = user;
		this.score = score;
		songName = i.getSong().getName();
		difficulty = i.getSong().getDifficulty();

		tempProfile = new UserProfile(user.getName() + ".txt");
		tempProfile.add(user.getName() + user.getPassword() + text + user.getAchievements());
		
		System.out.println(user.getName());
		tempProfile.add(user.getPassword());
		tempProfile.add( text);
		tempProfile.add(user.getAchievements());
		
		String s = user.getName()+"|"+user.getPassword()+"|"+ text +"|"+user.getAchievements()+"|";
		
		FileWriter fooWriter = new FileWriter(user.getName()+".txt", false); // true to append
		                                                     // false to overwrite.
		fooWriter.write( s);
		fooWriter.close();

	}
	
	
	
	//Method
	
	public User updateAchievement() throws IOException {
		
		String s = user.getName()+"|"+user.getPassword()+"|"+ text +"|"+ achievementType()+"|";
		
		FileWriter fooWriter = new FileWriter(user.getName()+".txt", false); // true to append
		                                                     // false to overwrite.
		fooWriter.write( s);
		fooWriter.close();
		return user;
		
	}
	
	public String achievementType()
	{
		if(score.CalculateScorePercentage() >= 60)
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
