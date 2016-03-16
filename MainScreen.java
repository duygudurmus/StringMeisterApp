/*Class Description: MainScreen which is frame provides change of panels.
 * Thus, it is possible to switch panels when the buttons are pressed.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainScreen extends JFrame {

	//properties
	static UserMenuScreen userMenuPanel;
	
	private static MainScreen instance = new MainScreen();

	//getInstance method
	public static MainScreen getInstance() {
		return instance;
	}

	//switchToPanel method which changes the panel in the frame
	public static void switchToPanel(JPanel panel) {
		getInstance().setContentPane(panel);
		getInstance().validate();
	}

	//Constructor
	private MainScreen() {
		
		//setting the title, visibility, size and resizability of frame
		setTitle("StringMeister");
		setVisible(true);
		setSize(1024, 764);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//adding window listener for the closing of the program
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
