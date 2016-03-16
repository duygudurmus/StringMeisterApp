import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class UserMenuScreen extends JPanel implements ActionListener {
	
	//variables
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
	
	public UserMenuScreen( ExistingUserScreen existingUserPanel) throws IOException {
		
		setLayout(null);
		profile = new User(existingUserPanel.getUser().getName());
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		usermenu = new JLabel("User Menu");
		username = existingUserPanel.getUser().getName();
		
		this.existingUserPanel = existingUserPanel; 
		usermenu.setBounds(230,250,SIZEBUTTONX,SIZEBUTTONY);
		usermenu.setForeground(Color.YELLOW);
		usermenu.setFont(new Font("Serif", Font.BOLD, 50));
		usermenu.setOpaque(false);
		user = new JLabel("Hi " + username + " ! ");
		user.setBounds(230,350,SIZEBUTTONX,SIZEBUTTONY);
		user.setForeground(Color.YELLOW);
		user.setFont(new Font("Serif", Font.BOLD, 50));
		user.setOpaque(false);
		
		play = new JButton("Play");
		play.setBounds(550,150,SIZEBUTTONX,SIZEBUTTONY);
		play.setForeground(Color.BLACK);
		play.setFont(new Font("Serif", Font.BOLD, 30));
		play.setOpaque(false);
		play.addActionListener((ActionListener) this);
	
		howToPlay = new JButton("How to Play");
		howToPlay.setBounds(550,250,SIZEBUTTONX,SIZEBUTTONY);
		howToPlay.setForeground(Color.BLACK);
		howToPlay.setFont(new Font("Serif", Font.BOLD, 30));
		howToPlay.setOpaque(false);
		howToPlay.addActionListener(this);
		
		achievements = new JButton("Achievements");
		achievements.setBounds(550,350,SIZEBUTTONX,SIZEBUTTONY);
		achievements.setForeground(Color.BLACK);
		achievements.setFont(new Font("Serif", Font.BOLD, 30));
		achievements.setOpaque(false);
		achievements.addActionListener((ActionListener) this);
		
		changeUser = new JButton("Change User");
		changeUser.setBounds(550,450,SIZEBUTTONX,SIZEBUTTONY);
		changeUser.setForeground(Color.BLACK);
		changeUser.setFont(new Font("Serif", Font.BOLD, 30));
		changeUser.setOpaque(false);
		changeUser.addActionListener((ActionListener) this);
		
		add(usermenu);
		add(user);
		add(play);
		add(howToPlay);
		add(achievements);
		add(changeUser);
		
	}
	
	public User getUser() {
		return profile;
	}
	
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == changeUser)
		{
			MainScreen.switchToPanel(new WelcomeScreen(this));
		}
		else if (e.getSource() == play)
		{
			try {
				MainScreen.switchToPanel(new PlayMenuScreen(this));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == achievements)
		{
			MainScreen.switchToPanel(new AchievementsScreen(this));
		}
		else if(e.getSource() == howToPlay)
		{
			MainScreen.switchToPanel(new HowToPlayScreen(this));
		}
	}
}

