import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class forecastGUI extends JFrame implements ActionListener
{
	private JPanel Panel;
	
	private JLabel Sunday;
	private JLabel Monday;
	private JLabel Tuesday;
	private JLabel Wednesday;
	private JLabel Thursday;
	private JLabel Friday;
	private JLabel Saturday;
	private JLabel high;
	private JLabel low;
	private JLabel precip;
	private JLabel location;
	
	private JButton dailyBut;
	private JButton weeklyBut;
	private JButton searchLocBut;
	private JButton warnBut;
	
	private Graphics line;
	
	public void Forecast()
	{
		//JFrame locFrame = new JFrame("Weekly Forecast");
		setTitle("Weekly Forecast");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = (JPanel) getContentPane();
		Panel.setLayout(null);
		
		searchLocBut = new JButton("Search Location");
		searchLocBut.addActionListener(this);
		
		weeklyBut = new JButton("Weekly Forecast");
		weeklyBut.addActionListener(this);
		
		dailyBut = new JButton("Daily Weather");
		dailyBut.addActionListener(this);
		
		warnBut = new JButton("Warnings");
		warnBut.addActionListener(this);
		
		JLabel Sunday = new JLabel("Sunday");
		JLabel Monday = new JLabel("Monday");
		JLabel Tuesday = new JLabel("Tuesday");
		JLabel Wednesday = new JLabel("Wednesday");
		JLabel Thursday = new JLabel("Thursday");
		JLabel Friday = new JLabel("Friday");
		JLabel Saturday = new JLabel("Saturday");
		JLabel hilow = new JLabel("High/Low");
		JLabel precip = new JLabel("Precipitation");
		JLabel location = new JLabel(searchGUI.getLoc());
		location.setFont(new Font("Serif", Font.PLAIN, 20));
		
		Sunday.setBounds(285, 80, 75, 30);
		Monday.setBounds(350, 80, 75, 30);
		Tuesday.setBounds(415, 80, 75, 30);
		Wednesday.setBounds(480, 80, 75, 30);
		Thursday.setBounds(565, 80, 75, 30);
		Friday.setBounds(640, 80, 75, 30);
		Saturday.setBounds(705, 80, 75, 30);
		hilow.setBounds(210, 140, 75, 30);
		precip.setBounds(200, 300, 90, 30);
		location.setBounds(340, 30, 300, 30);
		dailyBut.setBounds(50, 120, 150, 30);
		weeklyBut.setBounds(50, 250, 150, 30);
		searchLocBut.setBounds(50, 400, 150, 30);
		warnBut.setBounds(670, 550, 120, 30);
		
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
		//Object line.setColor(Color.BLACK);
		
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {		
		if(arg0.getSource() == dailyBut) {
			dispose();
			new DailyGUI();
		}
		else if(arg0.getSource() == weeklyBut) {
		}
		else if(arg0.getSource() == searchLocBut) {
			dispose();
			new searchGUI().locationLookup();
			//System.exit(0);
		}
		else if(arg0.getSource() == warnBut) {
			dispose();
			//new warnGUI();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new forecastGUI().Forecast();
	}
}

