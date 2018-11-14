import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DailyGUI extends JFrame implements ActionListener
{
	JButton checkDaily;
	JButton checkWeekly;
	JButton search;
	
	JLabel location;
	JLabel currentTemp;
	JLabel highlowTemp;
	JLabel currentForecast;
	JLabel dailyForecast;
	JLabel humidity;
	JLabel windspeed;
	JLabel feelsLike;
	
	ImageIcon icon;
	Image image = null;
	
	
	public static void main(String[] args) {
		DailyGUI gui = new DailyGUI();
	}
	
	public DailyGUI() {
		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();
		position.insets.left = 20;
		position.insets.right = 20;
		position.insets.bottom = 20;
		
		//checkDaily Button
		checkDaily = new JButton("Check Daily");
		checkDaily.addActionListener(this);
		position.gridx = 0;
		position.gridy = 2;
		add(checkDaily, position);
		
		//checkWeekly Button
		checkWeekly = new JButton("Check Weekly");
		checkWeekly.addActionListener(this);
		position.gridx = 0;
		position.gridy = 4;
		add(checkWeekly, position);
		
		//search Button
		search = new JButton("Search");
		search.addActionListener(this);
		position.gridx = 0;
		position.gridy = 6;
		add(search, position);
		
		//location Label
		location = new JLabel("Location");
		position.gridx = 1;
		position.gridy = 0;
		add(location, position);
		
		//currentTemp Label
		currentTemp = new JLabel("Current Temp");
		position.gridx = 1;
		position.gridy = 2;
		add(currentTemp, position);
		
		//highTemp Label
		highlowTemp = new JLabel("High / Low");
		position.gridx = 2;
		position.gridy = 2;
		add(highlowTemp, position);
		
		//currentForecast Label
		try {
		image = ImageIO.read(new URL("https://raw.githubusercontent.com/bthedorff/Weather-App/master/Icons/sunnyIcon.png")).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
		} catch(IOException e) {}
		icon = new ImageIcon(image);
		currentForecast = new JLabel(icon);
		position.gridx = 3;
		position.gridy = 2;
		add(currentForecast, position);
		
		//dailyForecast Label
		dailyForecast = new JLabel("Daily Forecast");
		position.gridx = 1;
		position.gridy = 4;
		add(dailyForecast, position);
		
		//humidity Label
		humidity = new JLabel("Humidity");
		position.gridx = 2;
		position.gridy = 4;
		add(humidity, position);
		
		//windspeed Label
		windspeed = new JLabel("Windspeed");
		position.gridx = 3;
		position.gridy = 4;
		add(windspeed, position);
		
		//feelsLike Label
		feelsLike = new JLabel("Feels Like");
		position.gridx = 1;
		position.gridy = 6;
		add(feelsLike, position);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Daily Weather");
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		if(arg0.getSource() == checkDaily) {
			dispose();
			new DailyGUI();
		}
		else if(arg0.getSource() == checkWeekly) {
			dispose();
			//new WeeklyGUI();
			System.exit(0);
		}
		else if(arg0.getSource() == search) {
			dispose();
			//new searchGUI();
			System.exit(0);
		}
	}
}

