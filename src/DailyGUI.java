import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;
import java.util.Date;
import java.util.*;
import java.lang.Object.*;

public class DailyGUI extends JFrame implements ActionListener 
{
	/**Updates the checkDaily window*/
	JButton checkDaily;
	/**Changes to the checkWeekly window for the same location*/
	JButton checkWeekly;
	/**Opens the search window to change locations*/
	JButton search;
	/**Opens a window that displays any weather warnings*/
	JButton warning;

	/**Displays the location*/
	JLabel location;
	/**Displays the current temperature of the location*/
	JLabel currentTemp;
	/**Displays the daily high and low temperature for the location*/
	JLabel highlowTemp;
	/**An icon image that represents the current forecast for the location*/
	JLabel currentForecast;
	/**Displays the daily expected forecast for the location*/
	JLabel dailyForecast;
	/**Displays the daily humidity for the location*/
	JLabel humidity;
	/**Displays the average windspeed for the day for the location*/
	JLabel windspeed;
	/**Displays what it currently feels like at the location*/
	JLabel feelsLike;

	/**Holds the icon to be used for the currentForecast label*/
	ImageIcon icon;
	/**Holds the URL to the image to be display on the currentForecast label*/
	Image image = null;
	
	/**Holds the weather data obtained from the API*/
	static WeatherData data = new WeatherData();

	/////////////////////////DELETE/////////////////////////
	public static void main(String[] args) {
		DailyGUI gui = new DailyGUI(data);
	}

	/**
	 * Initializes each label and sets it onto the frame
	 */
	public DailyGUI(WeatherData d) {
		data = d;
		
		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();
		position.insets.left = 20;
		position.insets.right = 20;
		position.insets.bottom = 20;

		/**checkDaily Button*/
		checkDaily = new JButton("Check Daily");
		checkDaily.addActionListener(this);
		position.gridx = 0;
		position.gridy = 2;
		add(checkDaily, position);

		/**checkWeekly Button*/
		checkWeekly = new JButton("Check Weekly");
		checkWeekly.addActionListener(this);
		position.gridx = 0;
		position.gridy = 4;
		add(checkWeekly, position);

		/**search Button*/
		search = new JButton("Search");
		search.addActionListener(this);
		position.gridx = 0;
		position.gridy = 6;
		add(search, position);

		/**warning Button*/
		warning = new JButton();
		warning.setBackground(Color.RED);
		warning.addActionListener(this);
		position.gridx = 5;
		position.gridy = 6;
		warning.setPreferredSize(new Dimension(20,20));
		add(warning, position);
		
		/**location Label*/
		location = new JLabel(data.cityName);
		location.setFont(new Font("Serif", Font.PLAIN, 20));
		position.gridx = 1;
		position.gridy = 0;
		add(location, position);

		/**currentTemp Label*/
		currentTemp = new JLabel("Current Temp");
		position.gridx = 1;
		position.gridy = 2;
		add(currentTemp, position);

		/**highTemp Label*/
		highlowTemp = new JLabel("<html><div style='text-align: center;'>High<br>-------<br>Low</div></html>");
		position.gridx = 2;
		position.gridy = 2;
		add(highlowTemp, position);

		//For testing purposes
		data.currentForecast = "Snowing";
	
		/**Sets the icon image that will be displayed*/
		try {
			if (data.currentForecast.equals("Overcast")) {
				image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/cloudyIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
			}
			else if (data.currentForecast.equals("Clear")) {
				image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/sunnyIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
			}
			else if (data.currentForecast.equals("Raining")) {
				image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/rainIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
			}
			else if (data.currentForecast.equals("Thunder Storms")) {
				image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/thunderstormIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
			}
			else if (data.currentForecast.equals("Snowing")) {
				image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/snowIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
			}
			else {
				image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/sunnyIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
			}
		} catch(IOException e) {}
		icon = new ImageIcon(image);
		
		/**currentForecast Label*/
		currentForecast = new JLabel(icon);
		position.gridx = 3;
		position.gridy = 2;
		add(currentForecast, position);

		/**dailyForecast Label*/
		dailyForecast = new JLabel("Daily Forecast");
		position.gridx = 1;
		position.gridy = 4;
		add(dailyForecast, position);

		/**humidity Label*/
		humidity = new JLabel("Humidity");
		position.gridx = 2;
		position.gridy = 4;
		add(humidity, position);

		/**windspeed Label*/
		windspeed = new JLabel("Windspeed");
		position.gridx = 3;
		position.gridy = 4;
		add(windspeed, position);

		/**feelsLike Label*/
		feelsLike = new JLabel("Feels Like");
		position.gridx = 1;
		position.gridy = 6;
		add(feelsLike, position);

		/**Sets the frame*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Daily Weather");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	/**
	 * Sets the functionality of the buttons
	 * @param arg0 the user pressing a button
	 */
	public void actionPerformed(ActionEvent arg0) {		
		if(arg0.getSource() == checkDaily) {
			new DailyGUI(data);
			dispose();
		}
		else if(arg0.getSource() == checkWeekly) {
			new forecastGUI(data);
			dispose();
		}
		else if(arg0.getSource() == search) {
			new searchGUI();
			dispose();
		}
		else if(arg0.getSource() == warning) {
			new WarnGUI(data);
		}
	}
}

