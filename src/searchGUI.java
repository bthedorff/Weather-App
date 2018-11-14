import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class searchGUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private JPanel Panel;
	private JLabel location;
	private JButton searchBut;
	private JTextField userInput;
	public static String userLoc = "Choose Location";

	public void locationLookup() {
		JFrame locFrame = new JFrame("Set Location");
		locFrame.getContentPane();
		locFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = (JPanel) locFrame.getContentPane();
		Panel.setLayout(null);
		
		searchBut = new JButton("Search Location");
		searchBut.addActionListener(this);
		userInput = new JTextField("",10);
		location = new JLabel("Enter Desired Location:");

		
		searchBut.setBounds(160, 55, 130, 30);
		userInput.setBounds(157, 18, 250, 30);
		location.setBounds(10, 20, 250, 30);
		Panel.add(searchBut);
		Panel.add(userInput);
		Panel.add(location);
		locFrame.setSize(450, 110);
		locFrame.setLocationRelativeTo(null);
		locFrame.setVisible(true);
	}
	

	
	public static void main(String[] args) {
		new searchGUI().locationLookup();
	}

	public static String getLoc()
	{
		return userLoc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		userLoc = userInput.getText();
		dispose();
		new forecastGUI().Forecast();
	}
}