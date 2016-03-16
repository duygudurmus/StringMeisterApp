import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Initializer extends JPanel {
	// Variables
	// private JLabel keyPress;
	private int noteNumber;
	private int fret;
	private int string;
	private ArrayList<Integer> stringPack;
	private ArrayList<Integer> fretPack;
	private PlaySound cleanGuitar;
	private UpperPlay upperPanel;
	private BottomPlayPanel tabPlay;
	private Song userSong;
	private JLabel keyPress;
	private boolean left;
	private IntervalChecker checker;
	int lastNumber;
	private JLabel score;
	private Image background;
	private JButton play;
	private JButton rewind;
	private JButton options;
	private Score playScore;
	private Achievements playMedal;
	private PlayMenuScreen playMenuScreen;
	private JButton menuButton;
	private long playTime;
	private ImageIcon menuButtonImage = new ImageIcon("menu.jpg");
	private PlayMenuScreen prev;

	// Constructor
	public Initializer(Song userSong , User player , PlayMenuScreen prev) throws Exception {
		
		this.prev = prev;
		 menuButton = new JButton(menuButtonImage);
		 menuButton.addActionListener( new ActionListener()  {
			 public void actionPerformed(ActionEvent e)
			 {
			 	try {
			 		if ( userSong.getPlaying())
			 			userSong.shut();
					MainScreen.switchToPanel( prev);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			 }
		 
		 });

		
		score = new JLabel(" Score:");
		score.setBorder(BorderFactory.createEtchedBorder());
		score.setForeground(Color.white);
		background = Toolkit.getDefaultToolkit().createImage("meister.jpg");
		left = false;
		checker = new IntervalChecker(userSong);
		// Creating and setting up variables
		this.userSong = userSong;
		stringPack = new ArrayList<Integer>();
		fretPack = new ArrayList<Integer>();
		cleanGuitar = new PlaySound();
		upperPanel = new UpperPlay(userSong);
		tabPlay = new BottomPlayPanel(userSong);
		play = new JButton("Play");
		rewind = new JButton("Stop");
		options = new JButton("Options");
		
		if ( player.getHand() == 0)
			setLeft(true);
			
		// Adds play and rewind button at the bottom
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperPanel.start();
				tabPlay.start();
				options.setFocusable(false);
				play.setFocusable(false);
				checker.start();
				//checker.setStart( e.getWhen());
			}
		});
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.setFocusable(false);
				JDialog.setDefaultLookAndFeelDecorated(true);
				Object[] selectionValues = { "Red", "Blue", "Green", "Yellow", "Black" };
				Object initialSelection = "Red";
				Object selection = JOptionPane.showInputDialog(null,
						"Select a color for the stick", "Options",
						JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				
				if(selection.equals("Blue")) {
					tabPlay.setColor(Color.blue);
					repaint();
				}
				if(selection.equals("Green")) {
					tabPlay.setColor(Color.green);
					repaint();
				}
				if(selection.equals("Yellow")) {
					tabPlay.setColor(Color.yellow);
					repaint();
				}
				if(selection.equals("Black")) {
					tabPlay.setColor(Color.black);
					repaint();
				}
			}
		});
		rewind.setFocusable(false);
		options.setFocusable(false);
		rewind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperPanel.stop();
				tabPlay.stop();
				checker.stop();
				playScore = new Score( checker);
				try {
					playMedal = new Achievements( player, playScore, checker);
					playMedal.updateAchievement();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();		
				checker = new IntervalChecker(userSong);
				//checker.checkAll();
				rewind.setFocusable(false);
				}			
			}
		});

		// Initializes to default values
		noteNumber = -1;
		fret = 0;
		string = 0;

		// Adding and creating everything else
		keyPress = new JLabel("Current note is: " + noteNumber);
		add(menuButton);
		add(score);
		add(upperPanel);
		add(tabPlay);
		add(play);
		add(rewind);
		add(options);
		add(checker);
		addKeyListener(new guitarListener());
		// add(keyPress);
		setPreferredSize(new Dimension(1024, 720));
		setBackground(Color.white);
		setFocusable(true);

	}

	public void paintComponent(Graphics Page) {
		super.paintComponent(Page);

		// Entering the loop of guitar needs to play or shutting it down
		if (noteNumber == -1) {
			cleanGuitar.shut();
			lastNumber = noteNumber;
		} else if (noteNumber != lastNumber)
			try {
				if (string != -1) {
					cleanGuitar.play(noteNumber); // creates sound
					upperPanel.changePlayed(noteNumber); // updates upperplay
					lastNumber = noteNumber; // to be used to press same note
												// more than once
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		Page.drawImage(background, 0, 0, this);
		repaint();
		// keyPress.setText("Current note is: " + noteNumber); //for testing
		// purposes
	}

	//

	// Listens user keystrokes
	public class guitarListener implements KeyListener {

		public void keyPressed(KeyEvent e) {

			if (!left) {
				switch (e.getKeyCode()) {
				// Does nothing if only fret is pressed
				case KeyEvent.VK_F1: {
					fret = 1;
					break;
				}
				case KeyEvent.VK_F2: {
					fret = 2;
					break;
				}
				case KeyEvent.VK_F3: {
					fret = 3;
					break;
				}
				case KeyEvent.VK_F4: {
					fret = 4;
					break;
				}
				case KeyEvent.VK_F5: {
					fret = 5;
					break;
				}
				case KeyEvent.VK_F6: {
					fret = 6;
					break;
				}
				case KeyEvent.VK_F7: {
					fret = 7;
					break;
				}
				case KeyEvent.VK_F8: {
					fret = 8;
					break;
				}
				case KeyEvent.VK_F9: {
					fret = 9;
					break;
				}
				case KeyEvent.VK_F10: {
					fret = 10;
					break;
				}
				case KeyEvent.VK_F11: {
					fret = 11;
					break;
				}
				case KeyEvent.VK_F12: {
					fret = 12;
					break;
				}

				// Plays if only string is pressed or bote is pressed
				case KeyEvent.VK_5: {
					string = 6;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_6: {
					string = 5;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_7: {
					string = 4;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_8: {
					string = 3;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_9: {
					string = 2;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_0: {
					string = 1;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				}
			}

			else {

				switch (e.getKeyCode()) {
				// Does nothing if only fret is pressed
				case KeyEvent.VK_F1: {
					fret = 12;
					break;
				}
				case KeyEvent.VK_F2: {
					fret = 11;
					break;
				}
				case KeyEvent.VK_F3: {
					fret = 10;
					break;
				}
				case KeyEvent.VK_F4: {
					fret = 9;
					break;
				}
				case KeyEvent.VK_F5: {
					fret = 8;
					break;
				}
				case KeyEvent.VK_F6: {
					fret = 7;
					break;
				}
				case KeyEvent.VK_F7: {
					fret = 6;
					break;
				}
				case KeyEvent.VK_F8: {
					fret = 5;
					break;
				}
				case KeyEvent.VK_F9: {
					fret = 4;
					break;
				}
				case KeyEvent.VK_F10: {
					fret = 3;
					break;
				}
				case KeyEvent.VK_F11: {
					fret = 2;
					break;
				}
				case KeyEvent.VK_F12: {
					fret = 1;
					break;
				}

				// Plays if only string is pressed or bote is pressed
				case KeyEvent.VK_6: {
					string = 6;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_5: {
					string = 5;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_4: {
					string = 4;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_3: {
					string = 3;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_2: {
					string = 2;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}
				case KeyEvent.VK_1: {
					string = 1;
					noteNumber = 13 * (string - 1) + fret;
					fret = 0;
					break;
				}

				}

			}

			score.setText("Score is: " + checker.getScore());
			checker.setUserNote(noteNumber);
			repaint();
		}
		

		// Shuts the guitar down when user releases fret or string
		public void keyReleased(KeyEvent e) {
			noteNumber = -1;
			fret = 0;
			string = 0;
			checker.setUserNote(-1);
			repaint();
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	// For interval checker

	//Determines if right or left
	public void setLeft( Boolean b) {
		left = b;	
	}
	
	public int getInputNote() {
		return noteNumber;
	}
}
