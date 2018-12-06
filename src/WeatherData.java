import java.util.Date;

import javax.swing.JLabel;
/*****************************************************************
* Stores all the things parsed from the Darksky API for use 
* throughout the app
* 
* @author Brandon Thedorff
* @author Nick Pydyn
* @author Denver DeBoer
* @author Ryan De Jong
* @version Fall 2018
******************************************************************/
public class WeatherData {

	/**current date/time */
	public Date[] date;
	/**icon correlating to current weather */
	public String[] weatherIcon;
	/**current temperature */
	public double[] temp;
	/**current high temperature */
	public double[] highTemp;
	/**current low temperature */
	public double[] lowTemp;
	/**description of current weather conditions ex: "cloudy" */
	public String[] forecast;
	/**current humidity */
	public int[] humidity;
	/**current chance of rain */
	public int[] precipProb;
	/**current windspeed */
	public double[] windSpeed;
	/**currently feels like... temperature */
	public double[] feelsLike;
	/**city location */
	public String cityName;
	/**state location */
	public String StateName;
	/**warning start time */
	public Date warnStart;
	/**warning end time */
	public Date warnStop;
	/**description of warning */
	public String warning;
	/**Name/type of the warning*/
	public String warnTitle;
	
	WeatherData(){
		//current date/time
		date = new Date[8];
		//icon correlating to current weather
		weatherIcon = new String[8];
		//current temperature
		temp = new double[8];
		//current high temperature
		highTemp = new double[8];
		//current low temperature
		lowTemp = new double[8];
		//description of current weather conditions ex: "cloudy"
		forecast = new String[8];
		//current humidity
		humidity = new int[8];
		//current chance of precipitation
		precipProb = new int[8];
		//current windspeed
		windSpeed = new double[8];
		//currently feels like... temperature
		feelsLike = new double[8];
	}
	
	public void setTestData() {
		cityName = "TEST";
		StateName = "DATA";
		for(int i = 0; i < 8; i++) {
			date[i] = new Date();
			weatherIcon[i] = "rain";
			temp[i] = 0.0;
			highTemp[i] = 0.0;
			lowTemp[i] = 0.0;
			forecast[i] = "Rain";
			humidity[i] = 0.0;
			windSpeed[i] = 0.0;
			feelsLike[i] = 0.0;
		}
	}

}
