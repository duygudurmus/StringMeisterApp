/*
 * An IntervalChecker instance is created and the getScore() method of 
 * it is used in the calculateScorePercentage() method of the score class. 
 * The calculateScorePercentage() method is used in the Achievements class.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Score
{	
	//Properties
	private double scoreP;
	private IntervalChecker i;

	//Constructor
	public Score(IntervalChecker i)
	{
		this.i = i;
		i.getSong().getName();
	}
	
	//Used in Achievements class, calculates the score percentage of a user
	public double CalculateScorePercentage()
	{
		scoreP = (i.getScore()/ 1000) * 100;
		return scoreP;
	}
	
	
	
	

}
