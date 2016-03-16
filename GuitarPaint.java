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


public class GuitarPaint extends JPanel 
{
	
	private Song input;
	private int noteNumber;
	private boolean start;
	private int index = 0;
	private long delay = 0;

	Timer timer;
    
	
	 public  GuitarPaint() 
	 {
		 setPreferredSize(new Dimension(1024, 360));
		 setOpaque(false);
		 timer = new Timer(726,new MyActionListener());

		
	 }
	 
	 public void setSong( Song input) {
		 this.input = input;
	 }
	 
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (start) {
			timer.start();
			delay = (input.getTimes().get(index+1));
			timer.setDelay((int) delay); //setting the timer for new delay
			
			//Setting up variables and getting the new note from array
			noteNumber = (int) input.getTrueNote(index);
			g.setColor(Color.red);

			//printing the note oval
			if (noteNumber % 13 >= 8) {
				
				g.fillOval((int) 650 - (noteNumber % 13) * 26, (int) 30 //function to determine the place
						+ ((5 - (int) noteNumber / 13)) * 10, 10, 10);
			} else {
				g.fillOval((int) 775 - (noteNumber % 13) * 42, (int) 30//function to determine the place
						+ ((5 - (int) noteNumber / 13)) * 10, 10, 10);	
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
}	 
	
