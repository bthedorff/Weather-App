import java.util.Date;

import javax.swing.JLabel;
public class WeatherData {

	//current date/time
	public Date date;
	//icon correllating to curret weather
	public String weatherIcon;
	//current temperature
	public double currentTemp;
	//current high temperature
	public double highTemp;
	//current low temperature
	public double lowTemp;
	//description of current weather conditions ex: "cloudy"
	public String currentForecast;
	//current humidity
	public double humidity;
	//current windspeed
	public double windspeed;
	//currently feels like... temperature
	public double feelsLike;
	//notification of dangerous weather
	public String warning;
	//city location
	public String cityName;
	//state location
	public String StateName;
	
	WeatherData(){
		
	}

}
