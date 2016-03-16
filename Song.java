import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.FloatControl;

import java.util.*;

public class Song {
	//Variables
	private ArrayList<Image> pics;
	private ArrayList<Long> newTimes;
	private String fileName;
	private BufferedImage temp;
	private Time trueTimes;
	public float factor2;
	private TrueNote trueNote;
	private String difficulty;
	private File CSVSong;
	private File midiSong;
	private Sequence song;
	private Sequencer player;
	private String name;
	private float factor;
	private boolean playing;

	//Contructors
	public Song(String name, String difficulty) throws IOException {

		//Setting the required variables and creating required objects
		playing = false;
		newTimes = new ArrayList<Long>();
		this.difficulty = difficulty;
		this.CSVSong = new File("songs/" + name + "/songFile.csv"); //getting the csv file of notes 
		this.midiSong = new File("songs/" + name + "/midiFile.mid");
		trueTimes = new Time(CSVSong);
		trueNote = new TrueNote(CSVSong);
		trueNote.initialize();
		trueTimes.startTimeArray();
		trueTimes.endTimeArray();
		this.name = name;
		pics = new ArrayList<Image>(16);

		//Getting the difficulty setting from the contructor and making required submissions
		if (difficulty.equals("easy")){
			factor2 = (float) 1.6; //this factor changes the times in the song array
			factor = (float)0.6;//this factor changes the speed of the ticker on bottom play panel
		}
		else if (difficulty.equals("medium")){
			factor2 = (float) 2;
			factor =(float) 0.5;
		}
		else if (difficulty.equals("real")){
			factor2 = 1;
			factor = 1;
		}

		//Getting the pictures from the files and adding the array
		for (int i = 0; i < pics.size(); i++) {
			fileName = "songs/" + name + "/pics" + String.valueOf(i) + ".png";
			temp = ImageIO.read(new File(fileName));
			pics.add(temp);

		}
		
		//Settign all the times to the required value for the difficulty
		for (Long l : trueTimes.getAllTimes()){
			l = (long) (l * factor2);
			System.out.println(l);
			newTimes.add(l);

		}

	}
	
	//Returns the end times
	public ArrayList<Long> endTimes() {
			
		try{
			return trueTimes.endTimeArray();
		} catch (FileNotFoundException e) {}
		return null;
	}
	
	//returns the start times
	public ArrayList<Long> startTimes() {
		try{
			return trueTimes.startTimeArray();
		} catch (FileNotFoundException e) {}
		return null;
	}

	//Returns the name of the song
	public String getName() {
		return name;
	}

	//Returns the difficulty
	public String getDifficulty() {
		return difficulty;
	}

	//Returns the tab pictures
	public ArrayList<Image> getTabPictures() {
		return pics;
	}

	//Gets the required note from the notes array
	public long getTrueNote(int count) {
		return trueNote.getTrueNote(count);
	}


	//Plays the song
	public void play() throws InvalidMidiDataException, IOException,
			MidiUnavailableException {

		if (!playing) { //this if statement blocks multiple channels to be open 
			//Audiostream conventions
			song = MidiSystem.getSequence(midiSong);
			player = MidiSystem.getSequencer();
			player.setSequence(song);
			player.setLoopCount(0);
			player.open();
			player.setTempoFactor(factor); //SEtting the difficulty
			player.start();
			playing = true;
		}

		

	}

	//Returns all the times of the song
	public ArrayList<Long> getTimes() {
		return newTimes;

	}
	
	//Gets the last end time 
	public long getLastEndTime()
	{
		return trueTimes.getLastEndTime();
				
	}
	
	//Returns if the clip playing
	public boolean getPlaying() {
		return playing;
	}

	//Shuts the clip
	public void shut() {
		playing = false;
		player.stop();
	}


}
