import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * BottomPlayPanel represents a tablature panel for displaying notes and song
 * information panel
 *
 */

public class BottomPlayPanel extends JPanel {

	//properties
	private ArrayList<Image> tabs;
	private Image temp;
	private final int imageNumber = 38;// total image number
	private Song input;
	private int count;// for getting images from the arraylist

	private JPanel infoPanel;
	private JPanel tablature;

	private JLabel infoLabel;
	private String songName;
	private String songDiff;//song difficulty

	private final int infoSize = 50; // size of info panel
	private final int mainSize = 150; // size of main panel

	private Stick stick = new Stick();
	private double speed = 2.66; // for move method
	private final int WIDTH = 939; // width of the picture
	private final int DELAY = 15; // timer constructor delay
	private Timer timer = null;
	private String startTimeString;
	private long startTime;

	public BottomPlayPanel(Song input) {

		tabs = new ArrayList<Image>();
		count = 0;
		this.input = input;
		
		//updating speed according to difficulty of the song
		if (input.getDifficulty().equals("easy"))
			speed = speed * 0.60;
		else if ((input.getDifficulty().equals("medium")))
			speed = speed * 0.70;

		//collecting images
		for (int i = 1; i <= imageNumber; i++) {
			temp = Toolkit.getDefaultToolkit().createImage(
					"songs/" + input.getName() + "/pics/" + i + ".png");
			tabs.add(temp);
		}

		// setting main panel and info panel
		setPreferredSize(new Dimension(1024, mainSize));
		setLayout(new BorderLayout());

		infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(1024, infoSize));

		infoLabel = new JLabel();
		songName = input.getName();
		songDiff = input.getDifficulty();
		infoLabel.setText("\t" + songName + " - " + songDiff + "\t");
		infoLabel.setBorder(BorderFactory.createEtchedBorder());

		infoPanel.add(infoLabel);

		// setting tablature panel
		tablature = new JPanel();
		tablature.repaint();
		tablature.setOpaque(false);

		// setting stick and timer
		timer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stick.move();
				if (count == imageNumber - 1) {
					stick.initialize();
					count = 0;
					repaint();
					timer.stop();
					input.shut();
				}
				repaint();
			}
		});

		// adding components to main panel
		add(infoPanel, BorderLayout.NORTH);
		add(tablature, BorderLayout.SOUTH);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(tabs.get(count), 0, infoSize, this);
		stick.drawStick(g);
	}

	private class Stick {
		private final int length;
		private double x = 0;
		private Color c = Color.red; //initial color
		private int width = 10; // width of the stick

		private Stick() {
			length = 80;
		}

		private void drawStick(Graphics g) {
			g.setColor(c);
			g.fillRect((int) x, infoSize, width, length);
		}

		private void move() {
			if (x >= WIDTH) {
				x = 0;
				count++;
			}
			x += speed;
		}

		private void initialize() {
			x = 0;
		}

		private void setColor(Color c) {
			this.c = c;
		}
	}

	// Starts the timer for tab motion
	public void start() {
		timer.start();

		// For interval checker
		Calendar cal = Calendar.getInstance();
		startTime = cal.getTimeInMillis();

		// start playing sound
		try {
			input.play();
		} catch (InvalidMidiDataException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (MidiUnavailableException e1) {
			e1.printStackTrace();
		}

	}

	// Unidentified
	public long getStartTime() {
		return startTime;
	}

	public void setColor(Color c) {
		stick.setColor(c);
	}

	// halts everything
	public void stop() {
		stick.initialize();
		count = 0;
		repaint();
		timer.stop();
		input.shut();
	}

	// TEST
	public static void main(String[] args) throws IOException {

		JFrame frame = new JFrame("test");
		BottomPlayPanel test = new BottomPlayPanel(new Song("SevenNationArmy",
				"easy"));
		test.getStartTime();
		frame.add(test);
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
}
