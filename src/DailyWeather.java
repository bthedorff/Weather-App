/**
 * This class will create a window
 * to display the daily weather forecast
 * of the selected location
 * @author denve
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyWeather extends JDialog {
	private JLabel location;
	private JLabel currentTemp;
	private JLabel highTemp;
	private JLabel lowTemp;
	private JLabel currentForecast;
	private JLabel dailyForecast;
	private JLabel humidity;
	private JLabel windspeed;
	private JLabel feelLike;
	
	private JButton checkDaily;
	private JButton checkWeekly;
	private JButton search;
	
	public DailyWeather() {
		location = new JLabel("Location");
		currentTemp = new JLabel("Current Temp");
		highTemp = new JLabel("High");
		lowTemp = new JLabel("Low");
		currentForecast = new JLabel("Current Forecast");
		dailyForecast = new JLabel("Daily Forecast");
		humidity = new JLabel("Humidity");
		windspeed = new JLabel("Wind Speed");
		feelLike = new JLabel("Feel Like");
		
		checkDaily = new JButton("Check Daily");
		checkWeekly = new JButton("Check Weekly");
		search = new JButton("Search Location");

		ButtonListener listener = new ButtonListener();
		
		checkDaily.addActionListener(listener);
		checkWeekly.addActionListener(listener);
		search.addActionListener(listener);
		
		setTitle("Daily Weather Summary");
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		getContentPane();
//		createPane();
		setSize(500, 500);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}	
	}
}