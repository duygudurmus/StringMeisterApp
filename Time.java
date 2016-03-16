import java.util.*;
import java.io.*;

public class Time {
	final int DIFFICULTY = 50;
	private File file;
	private ArrayList<Long> temp;
	private ArrayList<Long> tempOnlyTimes;
	private ArrayList<Long> trueStartTimes;
	private ArrayList<Long> trueEndTimes;
	private Scanner CSVReader;
	
	
	private long totalEndTimes;

	public Time(File file) throws FileNotFoundException {

		totalEndTimes = 0;
		
		temp = new ArrayList<Long>();
		tempOnlyTimes = new ArrayList<Long>();
		trueStartTimes = new ArrayList<Long>();
		trueEndTimes = new ArrayList<Long>();


		CSVReader = new Scanner( file);
		CSVReader.useDelimiter(","); // buras˝ csv dosyas˝n˝ okumak iÁin

	}
	
	public ArrayList<Long> getAllTimes() {
		return tempOnlyTimes;
		
	}

	public ArrayList<Long> startTimeArray() throws FileNotFoundException// Ba˛lang˝Á
																		// s¸relerinini
																		// dˆnd¸r¸r
	{
		final int DIFFICULTY = 50;

		while (CSVReader.hasNext()) // temp adl˝ arraylistin iÁine csv dosyas˝n˝
									// at˝yor tek tek
		{
			temp.add(Long.parseLong(CSVReader.next()));
		}

		for (int i = 1; i < temp.size(); i++)// notalar˝ ay˝r˝p sadece zamanlar˝
												// depolayan ayr˝ bir arraylist
		{
			tempOnlyTimes.add(temp.get(i));
			i++;
		}

		for (int k = 0; k < tempOnlyTimes.size(); k++) {
			trueStartTimes.add((tempOnlyTimes.get(k) - DIFFICULTY));
		}

		return trueStartTimes;

	}

	public ArrayList<Long> endTimeArray() throws FileNotFoundException {
		final int DIFFICULTY = 50;

		while (CSVReader.hasNext()) // temp adl˝ arraylistin iÁine csv dosyas˝n˝
									// at˝yor tek tek
		{
			temp.add(Long.parseLong(CSVReader.next()));
		}

		for (int i = 1; i < temp.size(); i++)// notalar˝ ay˝r˝p sadece zamanlar˝
												// depolayan ayr˝ bir arraylist
		{
			tempOnlyTimes.add(temp.get(i));
			i++;
		}

		for (int k = 0; k < tempOnlyTimes.size(); k++) {
			trueEndTimes.add((tempOnlyTimes.get(k) + DIFFICULTY));
		}

		return trueEndTimes;
	}

	public long getStartTime(int index) throws FileNotFoundException {
		startTimeArray();
		long startTime = 0;
		for (int k = 0; k < index; k++) {
			startTime += trueStartTimes.get(k);

		}
		return startTime;

	}
	
	public long getLastEndTime()
	{
		for(int i = 0; i < trueEndTimes.size(); i++)
			totalEndTimes+= trueEndTimes.get(i);
		return totalEndTimes;
		//return trueEndTimes.get(trueEndTimes.size()-1);
	}

	public long getEndTime(int index) throws FileNotFoundException {
		endTimeArray();
		long endTime = 0;
		for (int k = 0; k <= index; k++) {
			endTime += trueStartTimes.get(k);

		}
		return endTime;

	}

}
