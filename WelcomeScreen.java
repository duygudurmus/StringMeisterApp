import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WelcomeScreen extends JPanel implements ActionListener {
	
	private UserMenuScreen userMenuPanel;
	private Image background;
	private JButton existingUser;
	private JButton newUser;
	private final int SIZEBUTTONX = 200;
	private final int SIZEBUTTONY = 80;
		
	public WelcomeScreen(final UserMenuScreen userMenuPanel) {
		
		setLayout(null);
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		this.userMenuPanel = userMenuPanel;
		existingUser = new JButton("Existing User");
		existingUser.setFont(new Font("Existing User",Font.BOLD,23));
		existingUser.setBounds(200,300, SIZEBUTTONX, SIZEBUTTONY);
		existingUser.addActionListener(this);
		
		newUser = new JButton("New User");
		newUser.setFont(new Font("New User",Font.BOLD,23));
		newUser.setBounds(600, 300, SIZEBUTTONX, SIZEBUTTONY);
		newUser.addActionListener(this);
		add(existingUser);
		add(newUser);
	}
	
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == newUser)
		{
			MainScreen.switchToPanel(new NewUserScreen(this));
		}
		else if(e.getSource() == existingUser)
		{
			MainScreen.switchToPanel(new ExistingUserScreen(this));
		}
		
	}
}	

