import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*****************************************************************
* GUI for the weather for the next 7 days 
*
* @author Brandon Thedorff
* @author Nick Pydyn
* @author Denver DeBoer
* @author Ryan De Jong
* @version Fall 2018
*****************************************************************/
public class forecastGUI extends JFrame implements ActionListener {
	/**Displays the weather forecast for the week*/
	private JPanel Panel;
	/**Displays data for current day*/
	private JLabel day1;
	/**Displays data for tomorrow*/
	private JLabel day2;
	/**Displays data for Day 3 for forecast*/
	private JLabel day3;
	/**Displays data for Day 4*/
	private JLabel day4;
	/**Displays data for Day 5*/
	private JLabel day5;
	/**Displays data for Day 6*/
	private JLabel day6;
	/**Displays data for Day 7*/
	private JLabel day7;
	/**Displays data for daily high and low*/
	private JLabel hilow;
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
	
	/**Holds the weather data obtained from the API*/
	static WeatherData data = new WeatherData();
	
	/***************************************
	 * Sets up the forecastGUI panel
	 * @param d WeatherData object holding 
	 * the weather data
	 ***************************************/
	public forecastGUI(WeatherData d) {
		/** Initializes data */
		data = d;
		//data.setTestData();
		
		/**Initializes GUI window*/
		setTitle("Weekly Forecast");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**Sets up the JPanel */
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
		
		/**Initializes the calendar and sets time*/
		Calendar calendar = Calendar.getInstance();
		Date day = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("E");
		
		/**Initailizes JLabels*/
		day1 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[0]
				+ "*F<br>-------<br>" + data.lowTemp[0] + "*F</div></div></html>");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		day = calendar.getTime();
		day2 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[1]
				+ "*F<br>-------<br>" + data.lowTemp[1] + "*F</div></div></html>");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		day = calendar.getTime();
		day3 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[2]
				+ "*F<br>-------<br>" + data.lowTemp[2] + "*F</div></div></html>");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		day = calendar.getTime();
		day4 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[3]
				+ "*F<br>-------<br>" + data.lowTemp[3] + "*F</div></div></html>");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		day = calendar.getTime();
		day5 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[4]
				+ "*F<br>-------<br>" + data.lowTemp[4] + "*F</div></div></html>");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		day = calendar.getTime();
		day6 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[5]
				+ "*F<br>-------<br>" + data.lowTemp[5] + "*F</div></div></html>");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		day = calendar.getTime();
		day7 = new JLabel("<html><div style='text-align: center;'>" + format.format(day)
		+ "<br><br>" + "<div style='text-align: center;'>" + data.highTemp[6]
				+ "*F<br>-------<br>" + data.lowTemp[6] + "*F</div></div></html>");
		hilow = new JLabel("<html><div style='text-align: center;'>High<br>-------<br>Low</div></html>");
		location = new JLabel(data.cityName + ", " + data.StateName);
		location.setFont(new Font("Serif", Font.PLAIN, 20));
		
		/**Sets location of components on the panel*/
		day1.setBounds(285, 42, 75, 200);
		day2.setBounds(350, 42, 75, 200);
		day3.setBounds(415, 42, 75, 200);
		day4.setBounds(480, 42, 75, 200);
		day5.setBounds(545, 42, 75, 200);
		day6.setBounds(610, 42, 75, 200);
		day7.setBounds(675, 42, 75, 200);
		hilow.setBounds(210, 107, 75, 100);
		location.setBounds(340, 30, 300, 30);
		dailyBut.setBounds(30, 120, 150, 30);
		weeklyBut.setBounds(30, 150, 150, 30);
		searchLocBut.setBounds(30, 180, 150, 30);
		warnBut.setBounds(730, 275, 20, 20);
		
		/**Adds components to panel*/
		Panel.add(day1);
		Panel.add(day2);
		Panel.add(day3);
		Panel.add(day4);
		Panel.add(day5);
		Panel.add(day6);
		Panel.add(day7);
		Panel.add(hilow);
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

	/******************************************
	 * Sets the functionality of the buttons
	 * @param arg0 the user pressing a button
	 *****************************************/
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == dailyBut) {
			new DailyGUI(data);
			dispose();
		} else if (arg0.getSource() == weeklyBut) {
			new forecastGUI(data);
			dispose();
		} else if (arg0.getSource() == searchLocBut) {
			String args[] = new String[0];
			try {
				Main.main(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dispose();
		} else if (arg0.getSource() == warnBut) {
			new WarnGUI(data);
		}
	}
}

