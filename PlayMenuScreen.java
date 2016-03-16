import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class PlayMenuScreen extends JPanel implements ActionListener {
	
	private Image background;
	private JComboBox difficulty;
	private JComboBox songs;
	private ExistingUserScreen existingUserPanel;
	private PlayMenuScreen playMenuPanel;
	private UserMenuScreen userMenuPanel;
	private AchievementsScreen achievementsPanel;
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
	private UserMenuScreen prev;
	
	public PlayMenuScreen(final UserMenuScreen userMenuPanel) throws IOException, Exception {
		
		prev = userMenuPanel;

		
		setLayout(null);
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		this.userMenuPanel = userMenuPanel;
		playMenu = new JLabel("Play Menu");
		playMenu.setBounds(XCOORDINATE-100,YCOORDINATE+20,SIZEBUTTONX+30,SIZEBUTTONY);
		playMenu.setForeground(Color.YELLOW);
		playMenu.setFont(new Font("Serif", Font.BOLD, 60));
		playMenu.setOpaque(false);
		
		chooseSong = new JLabel("Choose song");
		chooseSong.setBounds(XCOORDINATE+350,YCOORDINATE-200,SIZEBUTTONX,SIZEBUTTONY);
		chooseSong.setForeground(Color.YELLOW);
		chooseSong.setFont(new Font("Serif", Font.BOLD, 30));
		chooseSong.setOpaque(false);
		
		songs = new JComboBox(songNames);
		songs.setBounds(XCOORDINATE+350,YCOORDINATE-120,SIZEBUTTONX+50,SIZEBUTTONY-40);
		songs.setFont(new Font("Serif", Font.BOLD, 30));
		songs.setOpaque(false);
		
		chooseDiff = new JLabel("Choose Difficulty");
		chooseDiff.setBounds(XCOORDINATE+350,YCOORDINATE-80,SIZEBUTTONX,SIZEBUTTONY);
		chooseDiff.setForeground(Color.YELLOW);
		chooseDiff.setFont(new Font("Serif", Font.BOLD, 30));
		chooseDiff.setOpaque(false);
		
		difficulty = new JComboBox(difficultyOptions);
		difficulty.setBounds(XCOORDINATE+350,YCOORDINATE,SIZEBUTTONX-40,SIZEBUTTONY-40);
		difficulty.setFont(new Font("Serif", Font.BOLD, 30));
		difficulty.setOpaque(false);
		
		lyrics = new JButton("Lyrics");
		lyrics.setBounds(XCOORDINATE+350,YCOORDINATE+100,SIZEBUTTONX-40,SIZEBUTTONY-40);
		lyrics.setFont(new Font("Serif", Font.BOLD, 30));
		lyrics.setOpaque(false);
		lyrics.addActionListener(this);
		
		play = new JButton("Play");
		play.setBounds(XCOORDINATE+350,YCOORDINATE+200,SIZEBUTTONX-40,SIZEBUTTONY-40);
		play.setFont(new Font("Serif", Font.BOLD, 30));
		play.setOpaque(false);
		play.addActionListener(this);
		
		returnUserMenu = new JButton("Return User Menu");
		returnUserMenu.setBounds(XCOORDINATE+350,YCOORDINATE+300,SIZEBUTTONX+25,SIZEBUTTONY-40);
		returnUserMenu.setFont(new Font("Serif", Font.BOLD, 30));
		returnUserMenu.setOpaque(false);
		returnUserMenu.addActionListener(this);
		
		add(playMenu);
		add(chooseSong);
		add(songs);
		add(chooseDiff);
		add(difficulty);
		add(lyrics);
		add(play);
		add(returnUserMenu);
	}
	
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == play) {
			currentSong = songNames[songs.getSelectedIndex()];
			currentDiff = difficultyOptions[difficulty.getSelectedIndex()];
			try {
				playInit = new Initializer(new Song(currentSong,
						currentDiff), userMenuPanel.getUser() , this);
				MainScreen.switchToPanel( playInit);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == returnUserMenu) {

			MainScreen.switchToPanel( prev);

		} else if (e.getSource() == lyrics) {
			MainScreen.switchToPanel(new SongLyrics(this));
		}
	}

}
