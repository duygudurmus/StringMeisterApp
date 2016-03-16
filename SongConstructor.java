import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class SongConstructor  {
	
	private ArrayList<ArrayList<Integer>> notes; //Creating two-dimensional array 
	private Scanner CSVReader;
	
	public SongConstructor() {		
		
		notes = new ArrayList<ArrayList<Integer>>();		
		notes.add(new ArrayList<Integer>()); //Row 0 for notes
		notes.add(new ArrayList<Integer>()); //Row 1 for times in millisecond	
			

	}
	
	public void addSongPart( String CSVFileName) throws FileNotFoundException {
		
		File inputFile = new File(CSVFileName);   
		int temp;
		CSVReader = new Scanner( inputFile);
        CSVReader.useDelimiter(",");
        
    	while ( CSVReader.hasNext()) { 	
    		temp = Integer.parseInt( CSVReader.next());
        	notes.get(0).add( temp);
    		temp = Integer.parseInt( CSVReader.next());
        	notes.get(1).add( temp);        	
        }	
	}
	
	public void changeSpeed( double speed) {
		int temp;
		
		for ( int i = 0 ; i < notes.get(1).size() ; i++) { //Running through the notes		
			temp = (int) (notes.get(0).get( i) * speed);
			notes.get(0).set( i, temp); 
		}	
	} 
	
	public void saveToDrive(String songFileName) {
		
		File inputFile = new File(songFileName);
		
		try {
			FileWriter fw = new FileWriter( inputFile);
			Writer output = new BufferedWriter(fw);
			
			for ( int i = 0 ; i < notes.get(1).size() ; i++) { //Running through the notes
				output.write( notes.get(0).get( i).toString() + ",");
				output.write( notes.get(1).get( i).toString() + ",");
			}	
			output.close();
			JOptionPane.showMessageDialog( null, "File created.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, "I cannot create that file.");
		}		
	}
	
	public String output() {
		
		String temp = "Notes: "; //Creating a string 
		
		for ( int i = 0 ; i < notes.get(0).size() ; i++) //Running through the notes
			temp += notes.get(0).get( i) + " | ";
		
		temp += "\nWaiting time after notes are: "; //Prepare to run through wait times
		
		for ( int j = 0 ; j < notes.get(1).size() ; j++) //Running through waiting times after each note
			temp += notes.get(1).get( j) + " | ";

		return temp;
	}
}
