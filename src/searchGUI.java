import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class searchGUI extends JFrame implements ActionListener{
	/**Displays the weather information*/
	private JPanel Panel;
	/**Instructs the user*/
	private JLabel location;
	/**Used to search for a location*/
	private JButton searchBut;
	/**Allows the user to enter a location*/
	private JTextField userInput;
	/**Holds the user's desired location*/
	public static String userLoc = "Choose Location";

	/**Initializes each variable*/
	public searchGUI() {
		setTitle("Set Location");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel = (JPanel) getContentPane();
		Panel.setLayout(null);

		/**Initializes search button*/
		searchBut = new JButton("Search Location");
		searchBut.addActionListener(this);

		/**Initializes search bar*/
		userInput = new JTextField("",10);
		location = new JLabel("Enter Desired Location:");

		/**Organizes components on the panel*/
		searchBut.setBounds(160, 55, 130, 30);
		userInput.setBounds(157, 18, 250, 30);
		location.setBounds(10, 20, 250, 30);
		Panel.add(searchBut);
		Panel.add(userInput);
		Panel.add(location);
		setSize(450, 180);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	/////////////////DELETE FOR FINAL///////////////////
	/////////////////RUN IN MAIN////////////////////////
	public static void main(String[] args) {
		new searchGUI();
	}
	////////////////////////////////////////////////////

	/**
	 * Returns the location the user entered
	 * @return userLoc user's location
	 */
	public static String getLoc()
	{
		return userLoc;
	}

	/**
	 * Stores user's input
	 * @param e the user pressing the search button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchBut) {
			userLoc = userInput.getText();
			new DailyGUI();
			dispose();
		}
	}
}