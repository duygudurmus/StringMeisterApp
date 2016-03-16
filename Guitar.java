public class Guitar extends PlaySound {

	private int fret;
	private int string;
	private int noteNumber;

	public Guitar() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNoteNumber() {
		return noteNumber = 13 * ( string - 1) + fret;
	}

	public void setFret( int fret) {
		this.fret = fret;
	}
	
	
	public void setString( int string) {
		this.string = string;

	}
	
	public int getString() {
		return string;
	}
	
	public int getFret() {
		return fret;
	}
	
	public void play() throws Exception {		
		super.play( getNoteNumber());
	}

	public void setNumber( int noteNumber) {
		this.noteNumber = noteNumber;		
	}
	
}
