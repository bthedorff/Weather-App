
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;
import java.util.Date;
import java.util.*;
import java.lang.Object.*;



import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import tk.plogitech.darksky.forecast.*;

// API Key   5f3d14bc52bfc3ec10922d31be0e7e61
//test
public class Main {
	
	
	
	public static void main(String args[]) throws Exception {
		WeatherData data = new WeatherData();
		double[] coords = new double[2];
		APIPuller pull = new APIPuller();
		
		searchGUI sgui = new searchGUI();
		coords[0] = sgui.getLong();
		coords[1] = sgui.getLat();
		//^ replace null with call to search gui. have gui return the longitude and latitude values as an array of 2 doubles. 
		data = pull.gather(coords); 
		//call DailyGUI using data as parameter(I think that's the initial one?) I assume from here all GUIs 
		//call each other when needed.
		//if it's necessary to call any other GUIs from main class, do that here
		DailyGUI dgui = new DailyGUI(data);
		//how to use data from WeatherData in your GUIS:
		//I've made each piece of relevant info into an array
		//to get data from the current day, just use the first value of each array
		//ex: data.temp[0]
		//for weekly data, replace 0 with the number of days in the future you want that data for
		//for tomorrow's humidity: data.humidity[1]
		//for high temperature 4 days from now: data.highTemp[4]
		//I've got it set to collect data for 7 days in the future, so 8 total
		//you can decide whether to include the 8th day or not (7 days ahead)
	}
	
}