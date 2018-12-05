import java.util.Date;

import javax.swing.JLabel;
public class WeatherData {

	/**current date/time */
	public Date[] date;
	//icon correlating to current weather
	public String[] weatherIcon;
	//current temperature
	public double[] temp;
	//current high temperature
	public double[] highTemp;
	//current low temperature
	public double[] lowTemp;
	//description of current weather conditions ex: "cloudy"
	public String[] forecast;
	//current humidity
	public double[] humidity;
	//current windspeed
	public double[] windSpeed;
	//currently feels like... temperature
	public double[] feelsLike;
	//city location
	public String cityName;
	//state location
	public String StateName;
	//warning start time
	public Date warnStart;
	//warning end time
	public Date warnStop;
	//description of warning
	public String warning;
	
	public String warnTitle;
	
	WeatherData(){
		//current date/time
		date = new Date[8];
		//icon correlating to current weather
		weatherIcon = new String[8];
		//current temperature
		temp = new double[8];
		//current high temperature
		highTemp = new double[8] ;
		//current low temperature
		lowTemp = new double[8];
		//description of current weather conditions ex: "cloudy"
		forecast = new String[8];
		//current humidity
		humidity = new double[8];
		//current windspeed
		windSpeed = new double[8];
		//currently feels like... temperature
		feelsLike = new double[8];
	}

}
