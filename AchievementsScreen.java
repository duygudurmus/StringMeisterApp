/*Class Description: AchievementsScreen which is a JPanel and implements Action Listener
 * It contains JButtons, JLabels, final int properties, image, user menu panel and Strings.
 * The screen shows the achievements of the user he/she earns while playing the game.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AchievementsScreen extends JPanel implements ActionListener{
	
	//Properties
	private UserMenuScreen userMenuPanel;
	
	private Image background;
	
	private JLabel achievements;
	private JLabel userAch;
	
	private JButton returnUserMenu;
	
	private String userAchievement;
	private String userName;
	
	private final int YCOORDINATE = 280;
	private final int XCOORDINATE = 200;
	private final int SIZEBUTTONX = 350;
	private final int SIZEBUTTONY = 80;
	

	public AchievementsScreen(final UserMenuScreen userMenuPanel) {
		
		this.userMenuPanel = userMenuPanel;
		
		//setting the layout null so as to determine the layout
		//according to the use
		setLayout(null);
		
		//setting the background as stringmeister background
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		
		//getting the user name and user achievements from the user menu panel
		userName = userMenuPanel.getUser().getName();
		userAchievement = userMenuPanel.getUser().getAchievements();
		
		//creating the achievements as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the label,
		//font and setting opaque false to eliminate the surrounding frame
		achievements = new JLabel("Achievements");
		achievements.setBounds( XCOORDINATE - 100, YCOORDINATE + 20, SIZEBUTTONX, SIZEBUTTONY);
		achievements.setForeground(Color.YELLOW);
		achievements.setFont(new Font("Serif", Font.BOLD, 50));
		achievements.setOpaque(false);
		
		//creating the userAch as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the label,
		//font and setting opaque false to eliminate the surrounding frame
		userAch = new JLabel(userAchievement);
		userAch.setBounds( XCOORDINATE + 280, YCOORDINATE - 230, SIZEBUTTONX + 230, SIZEBUTTONY + 500);
		userAch.setForeground(Color.YELLOW);
		userAch.setFont(new Font("Serif", Font.BOLD, 30));
		
		//creating the returnUserMenu as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the label,
		//font and setting opaque false to eliminate the surrounding frame
		returnUserMenu = new JButton("Return User Menu");
		returnUserMenu.setBounds( XCOORDINATE + 280, YCOORDINATE + 300, SIZEBUTTONX - 10, SIZEBUTTONY - 10);
		returnUserMenu.setForeground(Color.YELLOW);
		returnUserMenu.setFont(new Font("Serif", Font.BOLD, 30));
		returnUserMenu.addActionListener(this);
	
		//adding the properties into the panel of achievements panel
		add(userAch);
		add(achievements);
		add(returnUserMenu);
		
	}
	
	//paintComponent which creates a background for the 
	//achievements panel
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}
	
	//actionPerformed which returns the user menu panel when
	//the returnUserMenu is pressed 
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == returnUserMenu)
		{
			MainScreen.switchToPanel(userMenuPanel);
		}
		
	}
}
	
