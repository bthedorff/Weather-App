
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
		String APIKey = "5f3d14bc52bfc3ec10922d31be0e7e61";
		DailyWeather gui;
		double currLong;
		double currLat,currPrecipProb;
		String summary;
		String summary2;
		String icon;
		int currTime;
		int hourly;
		double temp;
		double apptemp;
		double humid;
		Date date;
		
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
	            .location(new GeoCoordinates(new Longitude(-85.886879), new Latitude(42.966679))).build();

	        DarkSkyClient client = new DarkSkyClient();
	        String forecast = client.forecastJsonString(request);
	        System.out.println(forecast);
	        
	        JSONObject obj = new JSONObject(forecast);
	        
	        currLong = obj.getDouble("longitude");
	        currLat = obj.getDouble("latitude");
	        currTime = obj.getJSONObject("currently").getInt("time");
	        icon = obj.getJSONObject("currently").getString("icon");
	        summary = obj.getJSONObject("currently").getString("summary");
	        currPrecipProb = obj.getJSONObject("currently").getDouble("precipProbability");
	        temp = obj.getJSONObject("currently").getDouble("temperature");
	        apptemp = obj.getJSONObject("currently").getDouble("apparentTemperature");
	        humid = obj.getJSONObject("currently").getDouble("humidity");
	        hourly = obj.getJSONObject("hourly").getJSONArray("data").getJSONObject(0).getInt("time");
	        date = new Date(currTime);
	        
	        
	        gui = new DailyWeather(temp,summary,humid);
	        
	        
	        
	        System.out.println(currLong + ", " + currLat );
	        System.out.println(currTime + ", " + currPrecipProb);
	        System.out.println(summary);
	        System.out.println(currTime);
	        System.out.println(hourly);

//	        // http://theoryapp.com/parse-json-in-java/
	        
//	        create date class
//	        time * 1000
//	        getdate() 

	        
	}
	
	public void Date (long currTime) {
		
		
	}
}
