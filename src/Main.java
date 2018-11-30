
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
		Main test = new Main();
		test.gather(-85.886879,42.966679); //replace hard code with user input from relevant GUI
		
	}
	
	Main(){}
	
	public WeatherData gather(double lon, double lat) throws Exception{
		String APIKey = "5f3d14bc52bfc3ec10922d31be0e7e61";
		double currLong;
		double currLat,currPrecipProb;
		String summary2;
		int currTime;
		int hourly;
		double apptemp;
		Date date;
		GoogleGeoCode googGeo;
		WeatherData data = new WeatherData();
		
//		GooglesMain goog = new GooglesMain();
//		//JSONObject obj2 = new JSONObject(goog);
//		googGeo = goog.getGeoCode(lon,lat,true); //parse this object and store relevant stuff in data (WeatherData object)
//		googGeo.cityName = obj.getJSONObject("results").getJSONArray("address_components").getJSONObject(3).getString("long_name");
//        googGeo.StateName = obj.getJSONObject("results").getJSONArray("address_components").getJSONObject(5).getString("long_name");
//		
		
		
//		ForecastRequest request = new ForecastRequestBuilder()
//	        .key(new APIKey("5f3d14bc52bfc3ec10922d31be0e7e61"))
//	        .location(new GeoCoordinates(new Longitude(-85.886879), new Latitude(42.966679))).build();
//
//	    DarkSkyClient client = new DarkSkyClient();
//	    String forecast = client.forecastJsonString(request);
	    
	
	    ForecastRequest request = new ForecastRequestBuilder()
	            .key(new APIKey(APIKey))
	            //.time(Instant.now().minus(5, ChronoUnit.DAYS))
	            .language(ForecastRequestBuilder.Language.en)
	            .units(ForecastRequestBuilder.Units.auto)
	            .exclude(ForecastRequestBuilder.Block.minutely)
	            .extendHourly()
	            .location(new GeoCoordinates(new Longitude(lon), new Latitude(lat))).build();

	        DarkSkyClient client = new DarkSkyClient();
	        String forecast = client.forecastJsonString(request);
	        
	        JSONObject obj = new JSONObject(forecast);
	       // System.out.println(obj.toString());
	        
	        date = new Date();
	        data.currentTemp = obj.getJSONObject("currently").getDouble("temperature");
	        data.humidity = obj.getJSONObject("currently").getDouble("humidity");
	        data.currentForecast = obj.getJSONObject("currently").getString("summary");
	        data.weatherIcon = obj.getJSONObject("currently").getString("icon");
	        data.windspeed = obj.getJSONObject("currently").getDouble("windSpeed");
	        data.date = date;
	        //data.warning = obj.getJSONObject("alerts").getString("description");
	        
	        GooglesMain goog = new GooglesMain();
			//JSONObject obj2 = new JSONObject(goog);
	        obj = new JSONObject(goog.getGeoCode(lon,lat,true)); //parse this object and store relevant stuff in data (WeatherData object)
			data.cityName = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(3).getString("long_name");
	        data.StateName = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(5).getString("long_name");
	        System.out.println(data.StateName);
	        //data.cityName = googGeo.cityName;
	        //data.StateName = googGeo.StateName;
	        
	        System.out.println(forecast);
	        
	        System.out.println(data.cityName);
	        
	        
	        ForecastRequest request2 = new ForecastRequestBuilder()
		            .key(new APIKey(APIKey))
		            .extendHourly()
		           
		            //.time(Instant.now().minus(5, ChronoUnit.DAYS))
		            .language(ForecastRequestBuilder.Language.en)
		            .units(ForecastRequestBuilder.Units.auto)
		            .exclude(ForecastRequestBuilder.Block.minutely)
		            .exclude(ForecastRequestBuilder.Block.currently)
		            .exclude(ForecastRequestBuilder.Block.hourly)
		            
		            .location(new GeoCoordinates(new Longitude(lon), new Latitude(lat))).build();

	        //https://api.darksky.net/forecast/5f3d14bc52bfc3ec10922d31be0e7e61/42.966679,-85
		        DarkSkyClient client2 = new DarkSkyClient();
		        String forecast2 = client2.forecastJsonString(request2);
		        
		        //System.out.println(forecast2);
		        //JSONObject obj = new JSONObject(forecast2);
	        return data;
//	        // http://theoryapp.com/parse-json-in-java/
	
	}
}
