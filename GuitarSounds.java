import java.io.File;
import java.util.*;

public class GuitarSounds {

	private String fileNameStr;
	private ArrayList<File> wavs;
	private File temp;

	public GuitarSounds() {
		wavs = new ArrayList<File>(78);
		
		for (int i = 0; i < 78; i++) {
			wavs.add(null);
		}
		
		
		for (int i = 0; i < 78; i++) {			
			fileNameStr = "Notes/" + String.valueOf(i) + ".wav";
			temp = new File( fileNameStr);
			wavs.add( i , temp);

		}
		
	}

	public File getFile(int noteNumber) {
		return wavs.get( noteNumber);

	}

}
