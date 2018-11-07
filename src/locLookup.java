import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class locLookup {
	private JPanel Panel;
	private JLabel location;
	private JButton searchBut;
	private JTextField userInput;

	public void locationLookup() {
		JFrame locFrame = new JFrame("Set Location");
		locFrame.getContentPane();
		locFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = (JPanel) locFrame.getContentPane();
		Panel.setLayout(null);
		
		searchBut = new JButton("Search Location");
		searchBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		userInput = new JTextField("",10);
		location = new JLabel("Enter Desired Location:");
		
		searchBut.setBounds(160, 80, 150, 40);
		userInput.setBounds(157, 20, 250, 40);
		location.setBounds(10, 20, 250, 40);
		Panel.add(searchBut);
		Panel.add(userInput);
		Panel.add(location);
		locFrame.setSize(450, 150);
		locFrame.setLocationRelativeTo(null);
		locFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new locLookup().locationLookup();
	}

}