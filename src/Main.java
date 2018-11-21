
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
	public static void main(String args[]) throws ForecastException {
		Main test = new Main();
		test.gather(-85.886879,42.966679);
	}
	
	Main(){}
	
	WeatherData gather(double lon, double lat) throws ForecastException{
		String APIKey = "5f3d14bc52bfc3ec10922d31be0e7e61";
		double currLong;
		double currLat,currPrecipProb;
		String summary2;
		int currTime;
		int hourly;
		double apptemp;
		Date date;
		WeatherData data = new WeatherData();
		
//		ForecastRequest request = new ForecastRequestBuilder()
//	        .key(new APIKey("5f3d14bc52bfc3ec10922d31be0e7e61"))
//	        .location(new GeoCoordinates(new Longitude(-85.886879), new Latitude(42.966679))).build();
//
//	    DarkSkyClient client = new DarkSkyClient();
//	    String forecast = client.forecastJsonString(request);
//	    System.out.println(forecast);
//		
	    ForecastRequest request = new ForecastRequestBuilder()
	            .key(new APIKey(APIKey))
	            .time(Instant.now().minus(5, ChronoUnit.DAYS))
	            .language(ForecastRequestBuilder.Language.en)
	            .units(ForecastRequestBuilder.Units.auto)
//	            .exclude(ForecastRequestBuilder.Block.minutely)
//	            .extendHourly()
	            .location(new GeoCoordinates(new Longitude(lon), new Latitude(lat))).build();

	        DarkSkyClient client = new DarkSkyClient();
	        String forecast = client.forecastJsonString(request);
	        System.out.println(forecast);
	        
	        JSONObject obj = new JSONObject(forecast);
	        
	        date = new Date();
	        data.currentTemp = obj.getJSONObject("currently").getDouble("temperature");
	        data.humidity = obj.getJSONObject("currently").getDouble("humidity");
	        data.currentForecast = obj.getJSONObject("currently").getString("summary");
	        data.weatherIcon = obj.getJSONObject("currently").getString("icon");
	        data.windspeed = obj.getJSONObject("currently").getDouble("windSpeed");
	        data.date = date;
	        
	        System.out.println(forecast);
	        
	        return data;
//	        // http://theoryapp.com/parse-json-in-java/
	
	}
}
