/*Class Description: The existing user screen asks the username and password by using textfields.
 *When the sign in button is pushed which is in the existing user screen, actionPerformed method
 *checks if one of the blanks (or both of them) is not filled. If the blanks are not filled,
 *the error is given. By using the user class, the password and username is also checked.
 *If the username or password is wrong, the error is given. If the password and username
 *is matched with the information in the user class,  the panel is switched to the user menu screen.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class ExistingUserScreen extends JPanel implements ActionListener {

	//Properties
	private WelcomeScreen welcomePanel;
	
	private User profile;
	
	private Image background;
	
	private JLabel username;
	private JLabel userpassword;
	
	private JTextField user;
	
	private JPasswordField password;
	
	private JButton signIn;
	private JButton returnMain;
	
	private final int SIZEBUTTONX = 510;
	private final int SIZEBUTTONY = 80;
	private final int YCOORDINATE = 200;
	private final int XCOORDINATE = 250;
	
	private char[] input;
	private String pass;

	//Constructor
	public ExistingUserScreen(final WelcomeScreen welcomePanel) {

		this.welcomePanel = welcomePanel;
		
		//setting the layout null so as to determine the layout
		//according to the use
		setLayout(null);
		
		//setting the background as stringmeister background
		background = Toolkit.getDefaultToolkit().createImage(
				"stringmeister.jpg");
		
		//creating the username as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the username label,
		//font and setting opaque false to eliminate the surrounding frame
		username = new JLabel("User Name: ");
		username.setBounds( XCOORDINATE, YCOORDINATE, SIZEBUTTONX, SIZEBUTTONY);
		username.setForeground(Color.YELLOW);
		username.setFont(new Font("Serif", Font.BOLD, 60));
		username.setOpaque(false);
		
		//creating the user as a JTextField to enable to user enter his/her
		//user name, setting bounds for it as the layout is null, setting the 
		//colour of the user text field and font
		user = new JTextField(15);
		user.setBounds( XCOORDINATE + 310, YCOORDINATE + 30, 200, 40);
		user.setForeground(Color.BLUE);
		user.setFont(new Font("Serif", Font.BOLD, 20));

		//creating the userpassword as a JLabel, setting bounds for it
		//as the layout is null, setting the color of the userpassword label,
		//font and setting opaque false to eliminate the surrounding frame
		userpassword = new JLabel("Password: ");
		userpassword.setBounds( XCOORDINATE, YCOORDINATE + 70, SIZEBUTTONX,
				SIZEBUTTONY);
		userpassword.setForeground(Color.YELLOW);
		userpassword.setFont(new Font("Serif", Font.BOLD, 60));
		userpassword.setOpaque(false);

		//creating the password as a JPasswordField to enable user to enter his/
		//her password, setting bounds for it as the layout is null, setting
		//the colour of the password field and font
		password = new JPasswordField(15);
		password.setEchoChar('*');
		password.setBounds( XCOORDINATE + 310, YCOORDINATE + 100, 200, 40);
		password.setForeground(Color.BLUE);
		password.setFont(new Font("Serif", Font.BOLD, 20));

		//creating the signIn as a JButton to enable user to switch panel from
		//existing user panel to user menu panel,setting bounds for it as the
		//layout is null, setting the colour of the button and font
		signIn = new JButton("Sign in!");
		signIn.setBounds( XCOORDINATE, YCOORDINATE + 290, SIZEBUTTONX,
				SIZEBUTTONY);
		signIn.setForeground(Color.YELLOW);
		signIn.setFont(new Font("Serif", Font.BOLD, 60));
		signIn.setOpaque(false);
		signIn.addActionListener(this);
		
		//creating the returnMain as a JButton to enable user to switch panel from
		//existing user panel to welcome panel,setting bounds for it as the
		//layout is null, setting the colour of the button and font
		returnMain = new JButton("Return Welcome Screen");
		returnMain.setBounds( XCOORDINATE, YCOORDINATE + 400, SIZEBUTTONX,
				SIZEBUTTONY);
		returnMain.setForeground(Color.YELLOW);
		returnMain.setFont(new Font("Serif", Font.BOLD, 40));
		returnMain.setOpaque(false);
		returnMain.addActionListener(this);

		//adding the properties into the panel of existing user screen
		add(username);
		add(user);
		add(userpassword);
		add(password);
		add(signIn);
		add(returnMain);
	}
	
	//paintComponent which creates a background for the 
	//existing user screen
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.drawImage(background, 0, 0, this);
		repaint();
	}

	//ActionPerformed for the actions of the buttons
	public void actionPerformed(ActionEvent e) {
		
		//converting the char array of password into String
		input = password.getPassword();
		pass = new String(input);
		
		//if the user presses the signIn button
		if (e.getSource() == signIn) {
			
			try {
				
				//get user information from the user class
				profile = new User(user.getText());
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			
			try {
			//if the user or password field is blank gives error	
			if(user.getText().length() == 0 || pass.length() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please fill the blanks to continue!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			//if the user name is correct but the password field is blank gives error	
			else if((user.getText()).equals(profile.getName()) && pass.length() != 0) {
				
				//if the password and user name are correct switches the panel
				if ((pass).equals(profile.getPassword()) && user.getText().length() != 0) {
					MainScreen.switchToPanel(new UserMenuScreen(this));
				} 
				else
				{	
					JOptionPane.showMessageDialog(null,"Wrong Password! Try Again", "ERROR", JOptionPane.ERROR_MESSAGE);
				}	
			}
			//if the user name is wrong gives an error
			else if(!(user.getText()).equals(profile.getName()))
				JOptionPane.showMessageDialog(null,"Wrong Username! Try Again", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			} catch (Exception ex) { JOptionPane.showMessageDialog(null,"Wrong Username! Try Again", "ERROR", JOptionPane.ERROR_MESSAGE); }

		}
		//if the returnMain is pressed the panel is switched to the welcome screen
		else if (e.getSource() == returnMain)
			MainScreen.switchToPanel(welcomePanel);
			
	}
	
	public User getUser()
	{
		return profile;
	}
}
