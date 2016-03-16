/*Class Description: UserMenuScreen class which is a panel and implements
 *Action Listener. It contains JButtons, string, JLabels, user, image,
 *existing user panel and achievements panel.The user menu screen has four
 *buttons which are “play”, “how to play”, “achievements” and “change user”.
 *The button of “play” switches the user menu screen to play menu screen.
 *The button of “how to play”plays the tutorial video. The button of “achievements”
 *switches the user menu screen to achievements screen. The button of “change user”
 *switches the user menu screen to welcome screen.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class UserMenuScreen extends JPanel implements ActionListener {
	
	//Properties
	private ExistingUserScreen existingUserPanel;
	
	private Image background;
	
	private JButton play;
	private JButton howToPlay;
	private JButton achievements;
	private JButton changeUser;
	
	private String username;
	
	private User profile;
	
	private JLabel user;
	private JLabel usermenu;
	
	private final int SIZEBUTTONX = 350;
	private final int SIZEBUTTONY = 80;
	
	private AchievementsScreen achievementsPanel;
	
	//Constructor which takes existing user panel as parameter
	public UserMenuScreen(final ExistingUserScreen existingUserPanel) throws IOException {
		
		this.existingUserPanel = existingUserPanel; 
		
		//setting the layout null so as to determine the layout
		//according to the use
		setLayout(null);
		
		//setting the background as stringmeister background
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		
		//getting the user from User Class
		profile = new User(existingUserPanel.getUser().getName());
		
		//creating the username as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the username label,
		//font and setting opaque false to eliminate the surrounding frame
		usermenu = new JLabel("User Menu");
		username = existingUserPanel.getUser().getName();
		usermenu.setBounds(230,250,SIZEBUTTONX,SIZEBUTTONY);
		usermenu.setForeground(Color.YELLOW);
		usermenu.setFont(new Font("Serif", Font.BOLD, 50));
		usermenu.setOpaque(false);
		
		//creating the user as a JLabel, setting bounds for it
		//as the layout is null, setting the colour of the user label,
		//font and setting opaque false to eliminate the surrounding frame
		user = new JLabel("Hi " + username + " ! ");
		user.setBounds(230,350,SIZEBUTTONX,SIZEBUTTONY);
		user.setForeground(Color.YELLOW);
		user.setFont(new Font("Serif", Font.BOLD, 50));
		user.setOpaque(false);
		
		//creating the play as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the play label,
		//font and setting opaque false to eliminate the surrounding frame
		play = new JButton("Play");
		play.setBounds(550,150,SIZEBUTTONX,SIZEBUTTONY);
		play.setForeground(Color.BLACK);
		play.setFont(new Font("Serif", Font.BOLD, 30));
		play.setOpaque(false);
		play.addActionListener((ActionListener) this);
		
		//creating the howToPlay as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the howToPlay button,
		//font and setting opaque false to eliminate the surrounding frame
		howToPlay = new JButton("How to Play");
		howToPlay.setBounds(550,250,SIZEBUTTONX,SIZEBUTTONY);
		howToPlay.setForeground(Color.BLACK);
		howToPlay.setFont(new Font("Serif", Font.BOLD, 30));
		howToPlay.setOpaque(false);
		howToPlay.addActionListener(this);
		
		//creating the achievements as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font and setting opaque false to eliminate the surrounding frame
		achievements = new JButton("Achievements");
		achievements.setBounds(550,350,SIZEBUTTONX,SIZEBUTTONY);
		achievements.setForeground(Color.BLACK);
		achievements.setFont(new Font("Serif", Font.BOLD, 30));
		achievements.setOpaque(false);
		achievements.addActionListener((ActionListener) this);
		
		//creating the changeUser as a JButton, setting bounds for it
		//as the layout is null, setting the colour of the button,
		//font and setting opaque false to eliminate the surrounding frame
		changeUser = new JButton("Change User");
		changeUser.setBounds(550,450,SIZEBUTTONX,SIZEBUTTONY);
		changeUser.setForeground(Color.BLACK);
		changeUser.setFont(new Font("Serif", Font.BOLD, 30));
		changeUser.setOpaque(false);
		changeUser.addActionListener((ActionListener) this);
		
		//adding the properties into the panel of user menu panel
		add(usermenu);
		add(user);
		add(play);
		add(howToPlay);
		add(achievements);
		add(changeUser);
		
	}
	
	//getting user from User class
	public User getUser() {
		return profile;
	}
	
	//paintComponent which creates a background for the 
	//user menu screen
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}
	
	//ActionPerformed which produces action according 
	//to the buttons pressed
	public void actionPerformed(ActionEvent e)
	{
		//if the changeUser is pressed
		if(e.getSource() == changeUser)
		{
			//switch to the panel of welcome panel
			MainScreen.switchToPanel(new WelcomeScreen(this));
		}
		
		//if the play is pressed
		else if (e.getSource() == play)
		{
			try {
				//switch to the panel of play menu panel
				MainScreen.switchToPanel(new PlayMenuScreen(this));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//if the achievements is pressed
		else if(e.getSource() == achievements)
		{
			//switch to the panel of achievements panel
			MainScreen.switchToPanel(new AchievementsScreen(this));
		}
		
		//if the howToPlay is pressed
		else if(e.getSource() == howToPlay)
		{
			//switch to the panel of how to play panel
			MainScreen.switchToPanel(new HowToPlayScreen(this));
		}
	}
}