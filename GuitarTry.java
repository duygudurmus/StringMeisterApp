import javax.swing.*;

public class GuitarTry {
	// -----------------------------------------------------------------
	// Displays the main frame of the program.
	// -----------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Guitar Tryout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(
				new Initializer(new Song("SevenNationArmy", "medium")));

		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}