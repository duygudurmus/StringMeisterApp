import java.awt.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
public class UpperPlay extends JPanel 
{
	private int width = 1024;
	private int height = 720;
	private int index = 0;
	private int tempNote;
	private long noteNumber;
	private Song input;
	private TrueNote note = new TrueNote(new File("SevenNationArmy.csv"));
	private GuitarPaint notes;
	
	private ImageIcon menuButtonImage = new ImageIcon("menu.jpg");
	private ImageIcon guitar = new ImageIcon("verynewguitar.png");
	private Image guitarImage = new ImageIcon("verynewguitar.png").getImage();
	
	int imageW = guitar.getIconWidth();
	int imageH = guitar.getIconHeight();
	
	private UserMenuScreen userMenuPanel;

		
	
	  //y axis
	private long string;
	private long fred;
	private long stringu;
	private long fredu;

	 public  UpperPlay( Song input)
	 {
		 //setting up buttons and objects

		 notes = new GuitarPaint();
		 notes.setSong(input);
		 this.input = input;
		 setOpaque(false);
		 setPreferredSize(new Dimension(width, height/2));
		 
		 //Adding components
		 add( notes);
		
	 }
	 //Changes the current appearance of note oval
	 public void changePlayed( int noteNumber) {
		 this.noteNumber = noteNumber;
		 repaint();
	 }
	 
	 //Stops the motion
	 public void stop() {
		 notes.stop();
	 }
	 
	 public void paintComponent(Graphics page)
	 {
		 super.paintComponent(page);
		 page.setColor( Color.cyan);
		 page.drawImage(guitarImage,(width/2)-180,0,null); //drawing background (variable control is needed for user preference)
		 
		 //Prints the note oval
		 if (noteNumber%13 >= 8)
			 page.fillOval(  650 - ( (int)noteNumber%13)*26, (int) 30 + ( (5-(int)noteNumber/13))*10  , 10, 10); //functions to determine the flace of a note
		 else
		 	 page.fillOval( (int) 775 - ((int)noteNumber%13)*42, (int) 30 + ( (5-(int)noteNumber/13))*10  , 10, 10);
			
		
	 }
	 	 
	 //BUTTONL›STENERS

			 

	public void start() {
		notes.start();
		
	}
	 
	 
	 
	 
}
 
	
