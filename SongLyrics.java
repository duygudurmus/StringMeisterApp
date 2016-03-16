import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

	public class SongLyrics extends JPanel implements ActionListener
	{
		private int width = 1024;
		private int height = 720;
		private JTextArea lyricsLabel;
		private String lyrics; 
		private JButton returnPlayMenu;
		private final int SIZEBUTTONX = 200;
		private final int SIZEBUTTONY = 80;
		private final int YCOORDINATE = 200;
		private final int XCOORDINATE = 250;
		private JPanel prevPanel;
		private Image background;
		
		public SongLyrics( final JPanel prevPanel)
		{
			this.prevPanel = prevPanel;

			lyrics	= "I'm gonna fight 'em off"
					+ "\nA seven nation army couldn't hold me back"
					+ "\nThey're gonna rip it off"
					+ "\nTaking their time right behind my back"
					+ "\nAnd I'm talking to myself at night"
					+ "\nBecause I can't forget "
					+ "\nBack and forth through my mind" 
					+"\nBehind a cigarette"
					+"\nAnd the message coming from my eyes" 
					+"\nSays leave it alone" 
					+"\n"
					+"\nDon't want to hear about it" 
					+"\nEvery single one's got a story to tell" 
					+"\nEveryone knows about it" 
					+"\nFrom the Queen of England to the hounds of hell" 
					+"\n"
					+"\nAnd if I catch it coming back my way" 
					+"\nI'm gonna serve it to you"
					+"\nAnd that ain't what you want to hear" 
					+"\nBut thats what I'll do" 
					+"\nAnd the feeling coming from my bones" 
					+"\nSays find a home" 

					+"\nI'm going to Wichita "
					+"\nFar from this opera for evermore" 
					+"\nI'm gonna work the straw" 
					+"\nMake the sweat drip out of every pore "
					+"\nAnd I'm bleeding, and I'm bleeding, and I'm bleeding "
					+"\nRight before the lord" 
					+"\nAll the words are gonna bleed from me" 
					+"\nAnd I will sing no more" 
					
					
					+"\nAnd the stains coming from my blood ";
			
			lyricsLabel = new JTextArea(lyrics);
			lyricsLabel.setEditable( false);
			lyricsLabel.setBounds( XCOORDINATE + 500, YCOORDINATE + 500, SIZEBUTTONX - 30,
			SIZEBUTTONY);
			
			returnPlayMenu = new JButton("Return Play Menu");
			returnPlayMenu.setBounds(XCOORDINATE, YCOORDINATE + 400, SIZEBUTTONX,
					SIZEBUTTONY);
			returnPlayMenu.setForeground(Color.YELLOW);
			returnPlayMenu.setFont(new Font("Serif", Font.BOLD, 40));
			returnPlayMenu.setOpaque(false);
			returnPlayMenu.addActionListener( this);
			
			background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
			
			add(lyricsLabel);
			add(returnPlayMenu);	
			
		}
		
		public void paintComponent(Graphics page)
		{	
			super.paintComponent(page);
			page.drawImage(background,0,0,this);
			repaint();
		}
		
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource() == returnPlayMenu)
			{
				MainScreen.switchToPanel( prevPanel);
			}
				
		}
				
}
		

