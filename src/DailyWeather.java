/**
 * This class will create a window
 * to display the daily weather forecast
 * of the selected location
 * @author denve
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DailyWeather extends JDialog {
	private JFrame frame;
	
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
	
	private double tempValue;
	private String forecastValue;
	private double humidityValue;
	
	public DailyWeather(double temp, String forecast, double humid) {
		frame = new JFrame("Today's Weather");
		
//		setTitle("Daily Weather Summary");
		frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		frame.getContentPane();
		//frame.setLayout(null);
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(null);
		//		createPane();
		
	
		
		location = new JLabel("Location");
		currentTemp = new JLabel("Current Temp");
		highTemp = new JLabel("High");
		lowTemp = new JLabel("Low");
		tempValue = temp;
		currentForecast = new JLabel("Current Forecast");
		forecastValue = forecast;
		dailyForecast = new JLabel("Daily Forecast");
		humidity = new JLabel("Humidity");
		humidityValue = humid;
		windspeed = new JLabel("Wind Speed");
		feelLike = new JLabel("Feel Like");
		
		checkDaily = new JButton("Check Daily");
		checkWeekly = new JButton("Check Weekly");
		search = new JButton("Search Location");

		ButtonListener listener = new ButtonListener();
		
		checkDaily.addActionListener(listener);
		checkWeekly.addActionListener(listener);
		search.addActionListener(listener);
		
		
		
		panel.add(currentTemp);
		panel.add(currentForecast);
		panel.add(humidity);
		panel.add(location);
		panel.add(feelLike);
		
		
		humidity.setBounds(50, -300, 800, 800);
		currentTemp.setBounds(50, -250, 800, 800);
		currentForecast.setBounds(50, -200, 800, 800);
		location.setBounds(50, -350, 800, 800);
		feelLike.setBounds(50, -150, 800, 800);
		
		frame.setSize(800, 800);
		frame.setVisible(true);

		

	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}	
	}
}