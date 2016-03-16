import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class IntervalChecker extends JPanel 
{
	
	private Song input;
	private int score;
	private int inputNote;
	private int noteNumber;
	private boolean start;
	private int index = 0;
	private long delay = 0;

	Timer timer;
    
	
	 public  IntervalChecker( Song s) 
	 {
		 score = 0;
		 input = s;
		 setPreferredSize(new Dimension(1024, 360));
		 setOpaque(false);
		 timer = new Timer(726,new MyActionListener());
		
	 }
	 

	 public void setUserNote( int note) {
		 inputNote = note;	 
	 }
	 
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (start) {
			timer.start();
			delay = (input.getTimes().get(index+1));
			timer.setDelay((int) delay);
			
			noteNumber = (int) input.getTrueNote(index);

			if (noteNumber != -1 && noteNumber == inputNote) {
				score++;
			}
		
		}
	}
			 

	private class MyActionListener implements ActionListener
	 {
	 	public void actionPerformed(ActionEvent e) 
	 	{
	 		 index++;
	 		 repaint();
	 		
	 	}
	 }

	//Starts the motion of notes
	public void start() {
		start = true;
		repaint();
		
	}

	//Stops the motion of notes
	public void stop() {
		start = false;
		index = 0;
		delay = 0;
		timer.stop();
	}
	
	public Song getSong()
	{
		return input;
	}
	
	public double getScore()
	{
		return score;
	}
	
}	 
	
