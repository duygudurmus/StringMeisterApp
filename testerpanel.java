import java.io.IOException;

import javax.swing.JFrame;


public class testerpanel {
	public static void main (String[] args) throws IOException {
		
		JFrame frame = new JFrame("test");
		GuitarPaint test = new GuitarPaint();
		test.setSong(new Song("SevenNationArmy" , "easy"));
		frame.add( test);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		
 }
}
