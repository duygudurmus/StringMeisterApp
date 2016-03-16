import java.io.*;
import java.util.*;

class TrueNote {
	
	private File CSVFile;
	private ArrayList<Long> notes;
	
	
	public TrueNote( File CSVFile) {
		this.CSVFile = CSVFile;
		
	}
	
	public void initialize() throws FileNotFoundException{
		
		Scanner CSVScanner = new Scanner( CSVFile);
		CSVScanner.useDelimiter(",");
		
		ArrayList<Long> notesAndTime = new ArrayList<Long>();
		notes = new ArrayList<Long>();
		
		while(CSVScanner.hasNext()) {
			
			notesAndTime.add(Long.parseLong(CSVScanner.next()));
		} 
		
		for( int i = 0; i < notesAndTime.size(); i++) {
			
			notes.add(notesAndTime.get(i));
			i++;
		}
		
		
	}
	
	public int getNoteNumber()
	{
		return notes.size();
	}


	public long getTrueNote( int index){
		
		return notes.get(index); //index starts from 0
	}
}
