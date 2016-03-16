import java.awt.*;
import java.awt.event.*;
import java.net.URI;

import javax.swing.*;

public class HowToPlayScreen extends JPanel {

	// Properties
	private Image background;
	private JPanel prevpanel;
	private JButton returnUserMenu;

	private final int sizeButtonx = 510;
	private final int sizeButtony = 80;
	final String url;
	final JLabel hyperlinkLabel;

	// Constructor
	public HowToPlayScreen(final JPanel prevpanel) {
		
		setPreferredSize(new Dimension(1024, 720));
		background = Toolkit.getDefaultToolkit().createImage("stringmeister.jpg");
		setLayout(null);
		this.prevpanel = prevpanel;
		url = "http://www.youtube.com/watch?v=DiSBG6KKVOQ";
		
		hyperlinkLabel = new JLabel("   Tutorial Video");
		hyperlinkLabel.setBounds(new Rectangle(355, 300, 300, 80));
		hyperlinkLabel.setForeground(Color.YELLOW);
		hyperlinkLabel.setBackground(new Color(230,230,230));
		hyperlinkLabel.setOpaque(true);
		hyperlinkLabel.setFont(new Font("Serif", Font.BOLD, 40));
		hyperlinkLabel.setVisible(true);
		add(hyperlinkLabel);
		
		returnUserMenu = new JButton("Return User Menu");
		returnUserMenu.setBounds(5, 5, sizeButtonx, sizeButtony);
		returnUserMenu.setForeground(Color.YELLOW);
		returnUserMenu.setFont(new Font("Serif", Font.BOLD, 40));
		returnUserMenu.setOpaque(false);
		returnUserMenu.addActionListener(new MyActionListener());
		add(returnUserMenu);

		hyperlinkLabel.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent me) {
				hyperlinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent me) {
				hyperlinkLabel.setCursor(Cursor.getDefaultCursor());
			}

			public void mouseClicked(MouseEvent me) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop.getDesktop().browse(new URI(url));
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		
		

	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.drawImage(background, 0, 0, this);
		repaint();
	}
	
	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == returnUserMenu)
				MainScreen.switchToPanel(prevpanel);

		}
	}

}