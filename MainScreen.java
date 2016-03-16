import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainScreen extends JFrame {

	static UserMenuScreen userMenuPanel;
	
	private static MainScreen instance = new MainScreen();

	public static MainScreen getInstance() {
		return instance;
	}

	public static void switchToPanel(JPanel panel) {
		getInstance().setContentPane(panel);
		getInstance().validate();
	}

	private MainScreen() {
		setTitle("StringMeister");
		setVisible(true);
		setSize(1024, 764);
		setResizable(false);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				int userAnswer = JOptionPane.showConfirmDialog(
						MainScreen.getInstance(),
						"Are you sure to close StringMeister? You may regret!",
						"Confirm exit", JOptionPane.YES_NO_OPTION);
				if (userAnswer == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	public static void main(String[] args) {
		MainScreen.switchToPanel(new WelcomeScreen(userMenuPanel));
	}
}
