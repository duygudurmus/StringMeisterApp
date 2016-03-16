import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ExistingUserScreen extends JPanel implements ActionListener {

	private WelcomeScreen welcomePanel;
	private User profile;
	private Image background;
	private JLabel username;
	private JLabel userpassword;
	private JTextField user;
	private JTextField password;
	private JButton signIn;
	private JButton returnMain;
	private final int SIZEBUTTONX = 510;
	private final int SIZEBUTTONY = 80;
	private final int YCOORDINATE = 200;
	private final int XCOORDINATE = 250;

	public ExistingUserScreen(final WelcomeScreen welcomePanel) {

		setLayout(null);
		background = Toolkit.getDefaultToolkit().createImage(
				"stringmeister.jpg");
		username = new JLabel("User Name: ");
		this.welcomePanel = welcomePanel;
		username.setBounds( XCOORDINATE, YCOORDINATE, SIZEBUTTONX, SIZEBUTTONY);
		username.setForeground(Color.YELLOW);
		username.setFont(new Font("Serif", Font.BOLD, 60));
		username.setOpaque(false);

		user = new JTextField(15);
		user.setBounds( XCOORDINATE + 310, YCOORDINATE + 30, 200, 40);
		user.setForeground(Color.BLUE);
		user.setFont(new Font("Serif", Font.BOLD, 20));

		userpassword = new JLabel("Password: ");
		userpassword.setBounds( XCOORDINATE, YCOORDINATE + 70, SIZEBUTTONX,
				SIZEBUTTONY);
		userpassword.setForeground(Color.YELLOW);
		userpassword.setFont(new Font("Serif", Font.BOLD, 60));
		userpassword.setOpaque(false);

		password = new JTextField(15);
		password.setBounds( XCOORDINATE + 310, YCOORDINATE + 100, 200, 40);
		password.setForeground(Color.BLUE);
		password.setFont(new Font("Serif", Font.BOLD, 20));

		signIn = new JButton("Sign in!");
		signIn.setBounds( XCOORDINATE, YCOORDINATE + 290, SIZEBUTTONX,
				SIZEBUTTONY);
		signIn.setForeground(Color.YELLOW);
		signIn.setFont(new Font("Serif", Font.BOLD, 60));
		signIn.setOpaque(false);
		signIn.addActionListener(this);
		
		returnMain = new JButton("Return Welcome Screen");
		returnMain.setBounds( XCOORDINATE, YCOORDINATE + 400, SIZEBUTTONX,
				SIZEBUTTONY);
		returnMain.setForeground(Color.YELLOW);
		returnMain.setFont(new Font("Serif", Font.BOLD, 40));
		returnMain.setOpaque(false);
		returnMain.addActionListener(this);

		add(username);
		add(user);
		add(userpassword);
		add(password);
		add(signIn);
		add(returnMain);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.drawImage(background, 0, 0, this);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signIn) {
			
			try {
				profile = new User(user.getText());
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			
			try {
				
			if(user.getText().length() == 0 || password.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please fill the blanks to continue!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			else if((user.getText()).equals(profile.getName()) && password.getText().length() != 0) {
				
				if ((password.getText()).equals(profile.getPassword()) && user.getText().length() != 0) {
					MainScreen.switchToPanel(new UserMenuScreen(this));
				} 
				else
				{	
					JOptionPane.showMessageDialog(null,"Wrong Password! Try Again", "ERROR", JOptionPane.ERROR_MESSAGE);
				}	
			}
			else if(!(user.getText()).equals(profile.getName()))
				JOptionPane.showMessageDialog(null,"Wrong Username! Try Again", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			} catch (Exception ex) { JOptionPane.showMessageDialog(null,"Wrong Username! Try Again", "ERROR", JOptionPane.ERROR_MESSAGE); }

		}
		else if (e.getSource() == returnMain)
			MainScreen.switchToPanel(welcomePanel);
			
	}
	
	public User getUser()
	{
		return profile;
	}
}
