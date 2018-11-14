import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class forecastGUI{
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
		JFrame locFrame = new JFrame("Weekly Forecast");
		locFrame.getContentPane();
		locFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = (JPanel) locFrame.getContentPane();
		Panel.setLayout(null);
		
		searchLocBut = new JButton("Search Location");
		searchLocBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		weeklyBut = new JButton("Weekly Forecast");
		weeklyBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		dailyBut = new JButton("Daily Weather");
		dailyBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		warnBut = new JButton("Daily Weather");
		warnBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel Sunday = new JLabel("Sunday");
		JLabel Monday = new JLabel("Monday");
		JLabel Tuesday = new JLabel("Tuesday");
		JLabel Wednesday = new JLabel("Wednesday");
		JLabel Thursday = new JLabel("Thursday");
		JLabel Friday = new JLabel("Friday");
		JLabel Saturday = new JLabel("Saturday");
		JLabel hilow = new JLabel("High/Low");
		JLabel precip = new JLabel("Precipitation");
		JLabel location = new JLabel("Location");
		
		Sunday.setBounds(285, 80, 75, 30);
		Monday.setBounds(350, 80, 75, 30);
		Tuesday.setBounds(415, 80, 75, 30);
		Wednesday.setBounds(480, 80, 75, 30);
		Thursday.setBounds(565, 80, 75, 30);
		Friday.setBounds(640, 80, 75, 30);
		Saturday.setBounds(705, 80, 75, 30);
		hilow.setBounds(210, 140, 75, 30);
		precip.setBounds(200, 300, 90, 30);
		location.setBounds(200, 30, 90, 30);
		
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
		
		//Object line.setColor(Color.BLACK);
		
		
		locFrame.setSize(800, 600);
		locFrame.setLocationRelativeTo(null);
		locFrame.setVisible(true);
	}
	public static void main(String[] args) {
		new forecastGUI().Forecast();
	}
}

