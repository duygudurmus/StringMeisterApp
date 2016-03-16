import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JPanel;


public class TabPanel extends JPanel {
	
	Boolean start;  //bunu kontrol etmelisin, ayrica diger classler bunu kontrol etmeli
	Song playing;
	
	public TabPanel( Song input) {
		
		start = false;
		playing = input;
		
		setPreferredSize(new Dimension( 1024, 500));
		setFocusable(true);
		
	}
	
	public void setStart( Boolean state) {
		start = state;
	}
	
	public void playStatusUpdate() throws InvalidMidiDataException, IOException, MidiUnavailableException {
		if ( start) {
			playing.play();
		}
		else 
			playing.shut();
	}
	
	public void paintComponent(Graphics Page) {
		super.paintComponent(Page);
		

	}
	
	

}
