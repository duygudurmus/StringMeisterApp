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

	public Song(String name, String difficulty) throws IOException {

		playing = false;
		newTimes = new ArrayList<Long>();
		this.difficulty = difficulty;
		this.CSVSong = new File("songs/" + name + "/songFile.csv");
		this.midiSong = new File("songs/" + name + "/midiFile.mid");
		trueTimes = new Time(CSVSong);
		trueNote = new TrueNote(CSVSong);
		trueNote.initialize();
		trueTimes.startTimeArray();
		trueTimes.endTimeArray();
		this.name = name;
		pics = new ArrayList<Image>(16);

		if (difficulty.equals("easy")){
			factor2 = (float) 1.6;
			factor = (float)0.6;
		}
		else if (difficulty.equals("medium")){
			factor2 = (float) 2;
			factor =(float) 0.5;
		}
		else if (difficulty.equals("real")){
			factor2 = 1;
			factor = 1;
		}

		for (int i = 0; i < pics.size(); i++) {

			fileName = "songs/" + name + "/pics" + String.valueOf(i) + ".png";
			temp = ImageIO.read(new File(fileName));
			pics.add(temp);

		}
		

		for (Long l : trueTimes.getAllTimes()){
			l = (long) (l * factor2);
			System.out.println(l);
			newTimes.add(l);

		}

	}
	
	public ArrayList<Long> endTimes() {

			
		try{
			return trueTimes.endTimeArray();
		} catch (FileNotFoundException e) {}
		return null;
	}
	
	public ArrayList<Long> startTimes() {
		try{
			return trueTimes.startTimeArray();
		} catch (FileNotFoundException e) {}
		return null;
	}

	public String getName() {
		return name;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public ArrayList<Image> getTabPictures() {
		return pics;
	}

	public long getStartTime(int count) throws FileNotFoundException {

		return trueTimes.getStartTime(count)*(long)factor2;
	}

	public long getEndTime(int count) throws FileNotFoundException {

		return trueTimes.getEndTime(count)*(long)factor2;
	}

	public long getTrueNote(int count) {
		return trueNote.getTrueNote(count);
	}

	public int getNoteNumber() {
		return trueNote.getNoteNumber();
	}

	public void play() throws InvalidMidiDataException, IOException,
			MidiUnavailableException {

		if (!playing) {
			song = MidiSystem.getSequence(midiSong);
			player = MidiSystem.getSequencer();
			player.setSequence(song);
			player.setLoopCount(0);
			player.open();
			player.setTempoFactor(factor);
			player.start();
			playing = true;
		}

		

	}

	public void pause() throws InterruptedException {
		player.wait();
	}

	public ArrayList<Long> getTimes() {
		return newTimes;

	}
	
	public long getLastEndTime()
	{
		return trueTimes.getLastEndTime();
				
	}
	
	public boolean getPlaying() {
		return playing;
	}

	public void shut() {
		playing = false;
		player.stop();
	}


}
