/*
 * IntervalChecker is a GUI class, because it uses a Timer object in order to 
 * keep track of the time of input. The Score class uses this class. It has a 
 * Song object and it is passed to the constructor. It has a setUserNote( int note)
 * method and it sets up the new input notes every time the user enters one. 
 * The paintComponent(Graphics g) method sets up the timer in every input 
 * and checks whether if it is the correct note and increments the score. 
 * 
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class IntervalChecker extends JPanel {

	
	//Properties
	private Song input;
	private int score;
	private int inputNote;
	private int noteNumber;
	private boolean start;
	private int index = 0;
	private long delay = 0;

	Timer timer;

	//Constructor
	public IntervalChecker(Song s) {
		score = 0;
		input = s;
		setPreferredSize(new Dimension(1024, 360));
		setOpaque(false);
		timer = new Timer(726, new MyActionListener());

	}

	//Sets up the input note when user enters it to the keyboard
	public void setUserNote(int note) {
		inputNote = note;
	}

	//Starts and sets up the timer with a delay, to allow the user reaction time. 
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (start) {
			timer.start();
			delay = (input.getTimes().get(index + 1));
			timer.setDelay((int) delay);




		}
	}

	//Index is incremented when action is performed, so the desired real times are obtained
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			index++;
			repaint();

		}
	}

	// Starts the timer when input is entered
	public void start() {
		start = true;
		repaint();

	}

	// Stops the timer when input isn't entered
	public void stop() {
		start = false;
		index = 0;
		delay = 0;
		timer.stop();
	}

	// returns current song
	public Song getSong() {
		return input;
	}

	// returns score for the Score class
	public double getScore() {
		return score;
	}

}
