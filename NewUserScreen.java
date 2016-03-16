import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewUserScreen extends JPanel implements ActionListener {

	private Image background;
	private UserProfile profile;
	private WelcomeScreen welcomePanel;
	private JLabel username;
	private JLabel userpassword;
	private JRadioButton lefthanded;
	private JRadioButton righthanded;
	private JTextField user;
	private JTextField password;
	private JButton returnMain;
	private JButton register;
	private String newuser;
	private String newpassword;
	private String newachievements;
	private int hand;
	private final int SIZEBUTTONX = 510;
	private final int SIZEBUTTONY = 80;
	private final int YCOORDINATE = 200;
	private final int XCOORDINATE = 250;

	public NewUserScreen(final WelcomeScreen welcomePanel) {

		setLayout(null);
		background = Toolkit.getDefaultToolkit().createImage(
				"stringmeister.jpg");
		this.welcomePanel = welcomePanel;
		newachievements = "No Achievement! Play to Earn!";
		username = new JLabel("User Name: ");
		username.setBounds(XCOORDINATE, YCOORDINATE, SIZEBUTTONX, SIZEBUTTONY);
		username.setForeground(Color.YELLOW);
		username.setFont(new Font("Serif", Font.BOLD, 60));
		username.setOpaque(false);

		user = new JTextField(15);
		user.setBounds(XCOORDINATE + 310, YCOORDINATE + 30, 200, 40);
		user.setForeground(Color.BLUE);
		user.setFont(new Font("Serif", Font.BOLD, 20));

		userpassword = new JLabel("Password: ");
		userpassword.setBounds(XCOORDINATE, YCOORDINATE + 70, SIZEBUTTONX,
				SIZEBUTTONY);
		userpassword.setForeground(Color.YELLOW);
		userpassword.setFont(new Font("Serif", Font.BOLD, 60));
		userpassword.setOpaque(false);

		password = new JTextField(15);
		password.setBounds(XCOORDINATE + 310, YCOORDINATE + 100, 200, 40);
		password.setForeground(Color.BLUE);
		password.setFont(new Font("Serif", Font.BOLD, 20));

		lefthanded = new JRadioButton("Left-Handed");
		lefthanded.setBounds(XCOORDINATE, YCOORDINATE + 140, SIZEBUTTONX,
				SIZEBUTTONY);
		lefthanded.setForeground(Color.YELLOW);
		lefthanded.setFont(new Font("Serif", Font.BOLD, 60));
		lefthanded.setOpaque(false);
		
		lefthanded.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      hand = 0;
		    }
		});

		righthanded = new JRadioButton("Right-Handed");
		righthanded.setBounds(XCOORDINATE, YCOORDINATE + 210, SIZEBUTTONX,
				SIZEBUTTONY);
		righthanded.setForeground(Color.YELLOW);
		righthanded.setFont(new Font("Serif", Font.BOLD, 60));
		righthanded.setOpaque(false);
		//righthanded.setSelected(true);
		
		righthanded.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      hand = 1;
		    }
		});


		register = new JButton("Register!");
		register.setBounds(XCOORDINATE, YCOORDINATE + 290, SIZEBUTTONX,
				SIZEBUTTONY);
		register.setForeground(Color.YELLOW);
		register.setFont(new Font("Serif", Font.BOLD, 60));
		register.setOpaque(false);
		register.addActionListener(this);
		
		returnMain = new JButton("Return Welcome Screen");
		returnMain.setBounds(XCOORDINATE, YCOORDINATE + 400, SIZEBUTTONX,
				SIZEBUTTONY);
		returnMain.setForeground(Color.YELLOW);
		returnMain.setFont(new Font("Serif", Font.BOLD, 40));
		returnMain.setOpaque(false);
		returnMain.addActionListener(this);

		ButtonGroup group = new ButtonGroup();
		group.add(lefthanded);
		group.add(righthanded);

		add(username);
		add(user);
		add(userpassword);
		add(password);
		add(lefthanded);
		add(righthanded);
		add(register);
		add(returnMain);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.drawImage(background, 0, 0, this);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == register) {
			if(user.getText().length() == 0 || password.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please fill the blanks to continue!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				newuser = user.getText();
				newpassword = password.getText();
				Object source = e.getSource();
				/*
				if (source == lefthanded) {
					hand = 0;
				} else if (source == righthanded) {
					hand = 1;
				}
*/
				profile = new UserProfile(newuser + ".txt");
				profile.add(newuser);
				profile.add(newpassword);
				profile.add(hand + "");
				profile.add(newachievements);

				MainScreen.switchToPanel(welcomePanel);
			}
		}
		else if(e.getSource() == returnMain)
			MainScreen.switchToPanel(welcomePanel);
			
	}
}