/*Class Description: PlayMenuScreen class which is a JPanel and implements Action Listener.
 *It contains combo boxes, JButtons, JLabels, strings, final int properties, image and user
 *menu panel. The play menu screen has song options and difficulty options as combo boxes. 
 *The user selects the difficulty and song from these combo boxes.Then when the user clicks
 *the button of �play� the game begins. If the user wants to return the user menu, the user
 *clicks the button of �return user menu�.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class PlayMenuScreen extends JPanel implements ActionListener {
	
	//Properties
	private Image background;
	
	private JComboBox difficulty;
	private JComboBox songs;
	
	private UserMenuScreen prev;
	private UserMenuScreen userMenuPanel;
	
	private JButton lyrics;
	private JButton play;
	private JButton returnUserMenu;
	
	private JLabel chooseDiff;
	private JLabel chooseSong;
	private JLabel playMenu;
	
	private final int SIZEBUTTONX = 250;
	private final int SIZEBUTTONY = 100;
	private final int YCOORDINATE = 280;
	private final int XCOORDINATE = 200;
	
	private String[] songNames = {"SevenNationArmy","Fly me to the moon","Animals","Nina","Summer Love"};
	private String[] difficultyOptions ={"easy", "medium","real"};
	private String currentSong;
	private String currentDiff;
	
	private Initializer playInit;
	
	//Constructor which takes user menu screen as parameter
	public PlayMenuScreen(final UserMenuScreen userMenuPanel) throws IOException, Exception {
		
		prev = userMenuPanel;
		this.userMenuPanel = userMenuPanel;
		//setting the layout null so as to determine the layout
		//according to the use
		setLayout(null);
		
		//setting the background as stringmeister background
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		
		//creating the playMenu as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the label,
		//font and setting opaque false to eliminate the surrounding frame
		playMenu = new JLabel("Play Menu");
		playMenu.setBounds(XCOORDINATE-100,YCOORDINATE+20,SIZEBUTTONX+30,SIZEBUTTONY);
		playMenu.setForeground(Color.YELLOW);
		playMenu.setFont(new Font("Serif", Font.BOLD, 60));
		playMenu.setOpaque(false);
		
		//creating the chooseSong as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the label,
		//font and setting opaque false to eliminate the surrounding frame
		chooseSong = new JLabel("Choose song");
		chooseSong.setBounds(XCOORDINATE+350,YCOORDINATE-200,SIZEBUTTONX,SIZEBUTTONY);
		chooseSong.setForeground(Color.YELLOW);
		chooseSong.setFont(new Font("Serif", Font.BOLD, 30));
		chooseSong.setOpaque(false);
		
		//creating songs combo boxes which stores the song names, setting bounds for it
		//as the layout is null, setting the colour of the combo box,
		//font and setting opaque false to eliminate the surrounding frame
		songs = new JComboBox(songNames);
		songs.setBounds(XCOORDINATE+350,YCOORDINATE-120,SIZEBUTTONX+50,SIZEBUTTONY-40);
		songs.setFont(new Font("Serif", Font.BOLD, 30));
		songs.setOpaque(false);
		
		//creating the chooseDiff as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the label,
		//font and setting opaque false to eliminate the surrounding frame
		chooseDiff = new JLabel("Choose Difficulty");
		chooseDiff.setBounds(XCOORDINATE+350,YCOORDINATE-80,SIZEBUTTONX,SIZEBUTTONY);
		chooseDiff.setForeground(Color.YELLOW);
		chooseDiff.setFont(new Font("Serif", Font.BOLD, 30));
		chooseDiff.setOpaque(false);
		
		//creating difficulty combo boxes which stores the difficulties, setting bounds for it
		//as the layout is null, setting the colour of the combo box,
		//font and setting opaque false to eliminate the surrounding frame
		difficulty = new JComboBox(difficultyOptions);
		difficulty.setBounds(XCOORDINATE+350,YCOORDINATE,SIZEBUTTONX-40,SIZEBUTTONY-40);
		difficulty.setFont(new Font("Serif", Font.BOLD, 30));
		difficulty.setOpaque(false);
		
		//creating the lyrics as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font and setting opaque false to eliminate the surrounding frame
		lyrics = new JButton("Lyrics");
		lyrics.setBounds(XCOORDINATE+350,YCOORDINATE+100,SIZEBUTTONX-40,SIZEBUTTONY-40);
		lyrics.setFont(new Font("Serif", Font.BOLD, 30));
		lyrics.setOpaque(false);
		lyrics.addActionListener(this);
		
		//creating the play as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font and setting opaque false to eliminate the surrounding frame
		play = new JButton("Play");
		play.setBounds(XCOORDINATE+350,YCOORDINATE+200,SIZEBUTTONX-40,SIZEBUTTONY-40);
		play.setFont(new Font("Serif", Font.BOLD, 30));
		play.setOpaque(false);
		play.addActionListener(this);
		
		//creating the returnUserMenu as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font and setting opaque false to eliminate the surrounding frame
		returnUserMenu = new JButton("Return User Menu");
		returnUserMenu.setBounds(XCOORDINATE+350,YCOORDINATE+300,SIZEBUTTONX+25,SIZEBUTTONY-40);
		returnUserMenu.setFont(new Font("Serif", Font.BOLD, 30));
		returnUserMenu.setOpaque(false);
		returnUserMenu.addActionListener(this);
		
		//adding the properties into the panel of play menu panel
		add(playMenu);
		add(chooseSong);
		add(songs);
		add(chooseDiff);
		add(difficulty);
		add(lyrics);
		add(play);
		add(returnUserMenu);
	}
	
	//paintComponent which creates a background for the 
	//play menu panel
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}
	
	//ActionPerformed which produces action for different buttons
	public void actionPerformed(ActionEvent e) {

		//if the play button is pressed
		if (e.getSource() == play) 
		{	
			//get the song and difficulty chose
			currentSong = songNames[songs.getSelectedIndex()];
			currentDiff = difficultyOptions[difficulty.getSelectedIndex()];
			
			try {
				//switch the panel to initializer
				playInit = new Initializer(new Song(currentSong,
						currentDiff), userMenuPanel.getUser() , this);
				MainScreen.switchToPanel( playInit);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		//if the returnUserMenu button is pressed
		} else if (e.getSource() == returnUserMenu) {

			//switch the panel to user menu panel
			MainScreen.switchToPanel( prev);

		//if the lyrics button is pressed	
		} else if (e.getSource() == lyrics) {
			
			//switch the panel to song lyrics panel
			MainScreen.switchToPanel(new SongLyrics(this));
		}
	}
}
