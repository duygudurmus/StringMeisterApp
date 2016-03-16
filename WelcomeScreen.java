/*Class Description: WelcomeScreen class which is a JPanel and implements ActionListener.
 *The Welcome Screen has two buttons of “new user” and “existing user” which enables user to choose. 
 *The button of “new user” switches the panel of welcome to new user panel which is in the new user screen.
 *The button of “existing user” switches the panel of welcome to existing user screen.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeScreen extends JPanel implements ActionListener {
	
	private UserMenuScreen userMenuPanel;
	
	private Image background;
	private ImageIcon stringMeister;
	private ImageIcon java;
	
	private JButton existingUser;
	private JButton newUser;
	
	private JLabel st;
	private JLabel js;
	
	private final int SIZEBUTTONX = 200;
	private final int SIZEBUTTONY = 80;

	//Constructor
	public WelcomeScreen(final UserMenuScreen userMenuPanel) {
		
		this.userMenuPanel = userMenuPanel;
		
		//setting the layout null so as to determine the layout
		//according to the use
		setLayout(null);
		
		//setting the background as stringmeister background
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		
		//creating image icons 
		stringMeister = new ImageIcon("st.png");
		java = new ImageIcon("js.png");
		
		//adding image icons into labels
		st = new JLabel(stringMeister);
		st.setBounds(210, 0, 600, 300);
		js = new JLabel(java);
		js.setBounds(0, 100, 1000, 1000);
		
		
		//creating the existingUser as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font
		existingUser = new JButton("Existing User");
		existingUser.setFont(new Font("Existing User",Font.BOLD,23));
		existingUser.setBounds(200,300, SIZEBUTTONX, SIZEBUTTONY);
		existingUser.addActionListener(this);
		
		//creating the newUser as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font
		newUser = new JButton("New User");
		newUser.setFont(new Font("New User",Font.BOLD,23));
		newUser.setBounds(600, 300, SIZEBUTTONX, SIZEBUTTONY);
		newUser.addActionListener(this);
		
		//adding the properties into the panel of welcome screen
		add(st);
		add(existingUser);
		add(newUser);
		add(js);
	}
	
	//paintComponent which creates a background for the 
	//welcome screen
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}

	//ActionPerformed which produces actions according
	//to the buttons pressed
	public void actionPerformed(ActionEvent e)
	{
		//if the newUser button is pressed
		if(e.getSource() == newUser)
		{
			//switch the panel to new user screen
			MainScreen.switchToPanel(new NewUserScreen(this));
		}
		//if the existingUser button is pressed
		else if(e.getSource() == existingUser)
		{
			//switch the panel to existing user screen
			MainScreen.switchToPanel(new ExistingUserScreen(this));
		}
	}
}	