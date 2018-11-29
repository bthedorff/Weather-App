import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class forecastGUI extends JFrame implements ActionListener
{
	/**Displays the weather forecast for the week*/
	private JPanel Panel;
	
	/**Displays data for Sunday*/
	private JLabel Sunday;
	/**Displays data for Monday*/
	private JLabel Monday;
	/**Displays data for Tuesday*/
	private JLabel Tuesday;
	/**Displays data for Wednesday*/
	private JLabel Wednesday;
	/**Displays data for Thursday*/
	private JLabel Thursday;
	/**Displays data for Friday*/
	private JLabel Friday;
	/**Displays data for Saturday*/
	private JLabel Saturday;
	/**Displays data for daily high*/
	private JLabel high;
	/**Displays data for daily low*/
	private JLabel low;
	/**Displays data for precipitation*/
	private JLabel precip;
	/**Displays the location*/
	private JLabel location;
	
	/**Used to switch to the dailyGUI window*/
	private JButton dailyBut;
	/**Used to refresh the forecastGUI window*/
	private JButton weeklyBut;
	/**Allows the user to search for a new location*/
	private JButton searchLocBut;
	/**Used to display any weather warnings*/
	private JButton warnBut;
	
	/**
	 * Sets up the forecastGUI panel
	 */
	public forecastGUI()
	{
		setTitle("Weekly Forecast");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = (JPanel) getContentPane();
		Panel.setLayout(null);
		
		/**Initializes search button*/
		searchLocBut = new JButton("Set Location");
		searchLocBut.addActionListener(this);
		
		/**Initializes weekly weather button*/
		weeklyBut = new JButton("Weekly Forecast");
		weeklyBut.addActionListener(this);
		
		/**Initializes daily weather button*/
		dailyBut = new JButton("Daily Weather");
		dailyBut.addActionListener(this);
		
		/**Initializes warning button*/
		warnBut = new JButton();
		warnBut.setBackground(Color.RED);
		warnBut.addActionListener(this);
		
		/**Initailizes JLabels*/
		JLabel Sunday = new JLabel("<html><div style='text-align: center;'>Sunday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel Monday = new JLabel("<html><div style='text-align: center;'>Monday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel Tuesday = new JLabel("<html><div style='text-align: center;'>Tuesday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel Wednesday = new JLabel("<html><div style='text-align: center;'>Wednesday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel Thursday = new JLabel("<html><div style='text-align: center;'>Thursday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel Friday = new JLabel("<html><div style='text-align: center;'>Friday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel Saturday = new JLabel("<html><div style='text-align: center;'>Saturday<br><br><br><br>TEST<br><br><br><br><br>Image</div></html>");
		JLabel hilow = new JLabel("High/Low");
		JLabel precip = new JLabel("Precipitation");
		JLabel location = new JLabel(searchGUI.getLoc());
		location.setFont(new Font("Serif", Font.PLAIN, 20));
		
		/**Sets location of components on the panel*/
		Sunday.setBounds(285, 68, 75, 200);
		Monday.setBounds(350, 68, 75, 200);
		Tuesday.setBounds(415, 68, 75, 200);
		Wednesday.setBounds(480, 68, 75, 200);
		Thursday.setBounds(565, 68, 75, 200);
		Friday.setBounds(640, 68, 75, 200);
		Saturday.setBounds(705, 68, 75, 200);
		hilow.setBounds(210, 140, 75, 30);
		precip.setBounds(200, 225, 90, 30);
		location.setBounds(340, 30, 300, 30);
		dailyBut.setBounds(30, 120, 150, 30);
		weeklyBut.setBounds(30, 150, 150, 30);
		searchLocBut.setBounds(30, 180, 150, 30);
		warnBut.setBounds(730, 275, 20, 20);
		
		/**Adds components to panel*/
		Panel.add(Sunday);
		Panel.add(Monday);
		Panel.add(Tuesday);
		Panel.add(Wednesday);
		Panel.add(Thursday);
		Panel.add(Friday);
		Panel.add(Saturday);
		Panel.add(hilow);
		Panel.add(precip);
		Panel.add(location);
		Panel.add(dailyBut);
		Panel.add(weeklyBut);
		Panel.add(searchLocBut);
		Panel.add(warnBut);
		
		/**Creates frame on screen*/
		setSize(800, 375);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Sets the functionality of the buttons
	 * @param arg0 the user pressing a button
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == dailyBut) {
			dispose();
			new DailyGUI();
		}
		else if(arg0.getSource() == weeklyBut) {
		}
		else if(arg0.getSource() == searchLocBut) {
			dispose();
			new searchGUI();
		}
		else if(arg0.getSource() == warnBut) {
			dispose();
			new WarnGUI();
		}
	}
	////////////////DELETE//////////////////////////
	public static void main(String[] args) {
		new forecastGUI();
	}
}

