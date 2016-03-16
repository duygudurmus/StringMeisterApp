
public class NoteInformation {

	private int note;

	public NoteInformation( int note) {
		this.note = note;
	}
	
	public int fretFinder() {
		return note % 13;
	}
	
	public int stringFinder() {
		return (int) note / 13;
	}

}
