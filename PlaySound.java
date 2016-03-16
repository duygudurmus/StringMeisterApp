import java.io.File;
import java.net.URL;

import javax.swing.*;
import javax.sound.sampled.*;

public class PlaySound {

	private File note;
	private Clip clip;
	private AudioInputStream ais;
	private GuitarSounds cleanGuitar;
	private boolean playing = false;

	public PlaySound() throws Exception {
		cleanGuitar = new GuitarSounds();
		clip = AudioSystem.getClip();

	}

	public void play( int noteNumber ) throws Exception {
		if( playing) {
			ais.close();
			clip.setFramePosition(0);
		}
		note = cleanGuitar.getFile( noteNumber);
		// getAudioInputStream() also accepts a File or InputStream
		ais = AudioSystem.getAudioInputStream( note);
		clip = AudioSystem.getClip();
		
		try{
			clip.open(ais);
		} catch (Exception e){System.out.println("Exception concerning stream has occurred.");}
		// no loop
		clip.loop(0);
		playing = true;
	}

	public void shut() {
		clip.stop();
		playing = false;
		clip.setFramePosition(0);
	}
}