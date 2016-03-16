
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Score
{	
	private double scoreP;
	private IntervalChecker i;

	public Score(IntervalChecker i)
	{
		this.i = i;
		i.getSong().getName();
	}
	
	public double CalculateScorePercentage()
	{
		scoreP = (i.getScore()/ 2000) * 100;
		System.out.println("\n SCORE PERCENTAGE "  + scoreP + "\n");
		return scoreP;
	}
	
	
	
	

}
