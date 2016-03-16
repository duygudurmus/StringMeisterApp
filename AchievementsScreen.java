import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AchievementsScreen extends JPanel implements ActionListener{
	
	//variables
	private UserMenuScreen userMenuPanel;
	private Image background;
	private JLabel achievements;
	private JButton returnUserMenu;
	private final int SIZEBUTTONX = 350;
	private final int SIZEBUTTONY = 80;
	private JLabel userAch;
	private String userAchievement;
	private String userName;
	private final int YCOORDINATE = 280;
	private final int XCOORDINATE = 200;
	
	
	
	public AchievementsScreen(final UserMenuScreen userMenuPanel) {
		
		setLayout(null);
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		this.userMenuPanel = userMenuPanel;
		userName = userMenuPanel.getUser().getName();
		userAchievement = userMenuPanel.getUser().getAchievements();
		
		achievements = new JLabel("Achievements");
		achievements.setBounds( XCOORDINATE - 100, YCOORDINATE + 20, SIZEBUTTONX, SIZEBUTTONY);
		achievements.setForeground(Color.YELLOW);
		achievements.setFont(new Font("Serif", Font.BOLD, 50));
		achievements.setOpaque(false);
		
		userAch = new JLabel(userAchievement);
		userAch.setBounds( XCOORDINATE + 280, YCOORDINATE - 230, SIZEBUTTONX + 230, SIZEBUTTONY + 500);
		userAch.setForeground(Color.YELLOW);
		userAch.setFont(new Font("Serif", Font.BOLD, 30));
		
		returnUserMenu = new JButton("Return User Menu");
		returnUserMenu.setBounds( XCOORDINATE + 280, YCOORDINATE + 300, SIZEBUTTONX - 10, SIZEBUTTONY - 10);
		returnUserMenu.setForeground(Color.YELLOW);
		returnUserMenu.setFont(new Font("Serif", Font.BOLD, 30));
		returnUserMenu.addActionListener(this);
	
		add(userAch);
		add(achievements);
		add(returnUserMenu);
		
	}
	
	public void paintComponent(Graphics page)
	{	
		super.paintComponent(page);
		page.drawImage(background,0,0,this);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == returnUserMenu)
		{
			MainScreen.switchToPanel(userMenuPanel);
		}
		
	}
}
	
