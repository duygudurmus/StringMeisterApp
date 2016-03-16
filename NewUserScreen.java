/*Class Description: NewUserScreen class is a JPanel which implements ActionListener
*for its buttons. It contains JButtons of returnMain and register, JLabels of
*username and password, JTextField of user and JPasswordField of password, strings, image
*final int properties, char array, welcome panel and profile. By using this screen,
*the user can create an account for herself/himself as a text file. This text file
stores the username, password, left or right handed and achievements.
*/ 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewUserScreen extends JPanel implements ActionListener {

	//Properties
	private Image background;
	
	private UserProfile profile;
	
	private WelcomeScreen welcomePanel;
	
	private JLabel username;
	private JLabel userpassword;
	
	private JRadioButton lefthanded;
	private JRadioButton righthanded;
	
	private JTextField user;
	private JPasswordField password;
	
	private JButton returnMain;
	private JButton register;
	
	private String newuser;
	private String newpassword;
	private String newachievements;
	private String pass;
	
	private int hand;
	private final int SIZEBUTTONX = 510;
	private final int SIZEBUTTONY = 80;
	private final int YCOORDINATE = 200;
	private final int XCOORDINATE = 250;
	
	private ButtonGroup group;
	
	private char[] input;
	

	//constructor which takes welcomePanel as a parameter
	public NewUserScreen(final WelcomeScreen welcomePanel) {

		this.welcomePanel = welcomePanel;

		//setting the layout null so as to determine the layout
		//according to the use
		setLayout(null);
		
		//setting the background as stringmeister background
		background = Toolkit.getDefaultToolkit().createImage(
				"stringmeister.jpg");
		
		//setting a default text for achievements as the user 
		//does not have any achievements at the beginning
		newachievements = "No Achievement! Play to Earn!";
		
		//creating the username as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the username label,
		//font and setting opaque false to eliminate the surrounding frame
		username = new JLabel("User Name: ");
		username.setBounds(XCOORDINATE, YCOORDINATE, SIZEBUTTONX, SIZEBUTTONY);
		username.setForeground(Color.YELLOW);
		username.setFont(new Font("Serif", Font.BOLD, 60));
		username.setOpaque(false);

		//creating the user as a JTextField to enable to user enter his/her
		//user name, setting bounds for it as the layout is null, setting the 
		//colour of the user text field and font
		user = new JTextField(15);
		user.setBounds(XCOORDINATE + 310, YCOORDINATE + 30, 200, 40);
		user.setForeground(Color.BLUE);
		user.setFont(new Font("Serif", Font.BOLD, 20));

		//creating the userpassword as a JLabel, setting bounds for it
		//as the layout is null, setting the color of the userpassword label,
		//font and setting opaque false to eliminate the surrounding frame
		userpassword = new JLabel("Password: ");
		userpassword.setBounds(XCOORDINATE, YCOORDINATE + 70, SIZEBUTTONX,
				SIZEBUTTONY);
		userpassword.setForeground(Color.YELLOW);
		userpassword.setFont(new Font("Serif", Font.BOLD, 60));
		userpassword.setOpaque(false);

		//creating the password as a JPasswordField to enable user to enter his/
		//her password, setting bounds for it as the layout is null, setting
		//the colour of the password field and font
		password = new JPasswordField(15);
		password.setEchoChar('*');
		password.setBounds(XCOORDINATE + 310, YCOORDINATE + 100, 200, 40);
		password.setForeground(Color.BLUE);
		password.setFont(new Font("Serif", Font.BOLD, 20));

		//creating left-handed as JRadioButton. Only one of them
		//can be chosen, setting bounds for it as the layout is null, setting the
		//colour of the radio button, font and make the opaque false
		lefthanded = new JRadioButton("Left-Handed");
		lefthanded.setBounds(XCOORDINATE, YCOORDINATE + 140, SIZEBUTTONX,
				SIZEBUTTONY);
		lefthanded.setForeground(Color.YELLOW);
		lefthanded.setFont(new Font("Serif", Font.BOLD, 60));
		lefthanded.setOpaque(false);
		
		//adding action listener for the left-handed and set the hand zero when the 
		//radio button is pressed
		lefthanded.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      hand = 0;
		    }
		});

		//creating right-handed as JRadioButton. Only one of them
		//can be chosen, setting bounds for it as the layout is null, setting the
		//colour of the radio button, font and make the opaque false
		righthanded = new JRadioButton("Right-Handed");
		righthanded.setBounds(XCOORDINATE, YCOORDINATE + 210, SIZEBUTTONX,
				SIZEBUTTONY);
		righthanded.setForeground(Color.YELLOW);
		righthanded.setFont(new Font("Serif", Font.BOLD, 60));
		righthanded.setOpaque(false);
		
		//adding action listener for the right-handed and set the hand one when the 
		//radio button is pressed
		righthanded.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      hand = 1;
		    }
		});

		//creating the register as a JButton to enable to create his/her
		//account, setting bounds for it as the layout is null, setting
		//the colour of the password field,font and adding action listener
		//to create this account as text file
		register = new JButton("Register!");
		register.setBounds(XCOORDINATE, YCOORDINATE + 290, SIZEBUTTONX,
				SIZEBUTTONY);
		register.setForeground(Color.YELLOW);
		register.setFont(new Font("Serif", Font.BOLD, 60));
		register.setOpaque(false);
		register.addActionListener(this);
		
		//creating the returnMain as a JButton to enable to return the
		//welcome screen, setting bounds for it as the layout is null, setting
		//the colour of the password field,font and adding action listener
		//to return the welcome screen
		returnMain = new JButton("Return Welcome Screen");
		returnMain.setBounds(XCOORDINATE, YCOORDINATE + 400, SIZEBUTTONX,
				SIZEBUTTONY);
		returnMain.setForeground(Color.YELLOW);
		returnMain.setFont(new Font("Serif", Font.BOLD, 40));
		returnMain.setOpaque(false);
		returnMain.addActionListener(this);

		//creating a button group to provide only one selection of radio 
		//button for the user
		group = new ButtonGroup();
		group.add(lefthanded);
		group.add(righthanded);

		//adding the properties into the panel of new user
		add(username);
		add(user);
		add(userpassword);
		add(password);
		add(lefthanded);
		add(righthanded);
		add(register);
		add(returnMain);
	}

	//paintComponent which creates a background for the 
	//new user screen
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.drawImage(background, 0, 0, this);
		repaint();
	}

	//Action performed which creates an account for the user
	//when register button is pressed and returns the welcome
	//screen when the return main button is pressed
	public void actionPerformed(ActionEvent e) {
		
		//it the register button is pressed, the user returns the welcome
		//panel after creating the account
		if (e.getSource() == register) 
		{
			//getting the password and converting char array into string
			input = password.getPassword();
			pass = new String(input);
			
			//if the one of user or password field is blank gives an error
			if(user.getText().length() == 0 || pass.length() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please fill the blanks to continue!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else //if all text fields are filled the account is created
			{
				newuser = user.getText();
				newpassword = pass;
				profile = new UserProfile(newuser + ".txt");
				profile.add(newuser);
				profile.add(newpassword);
				profile.add(hand + "");
				profile.add(newachievements);

				//returning the welcome screen automatically after creating
				//account
				MainScreen.switchToPanel(welcomePanel);
			}
		}
		
		//if the returnMain button is pressed, the user returns the welcome panel
		//without creating account
		else if(e.getSource() == returnMain)
			MainScreen.switchToPanel(welcomePanel);
			
	}
}