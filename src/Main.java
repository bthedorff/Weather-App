import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

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
		double currLong;
		double currLat,currPrecipProb;
		int currTime,sec = 0,min = 0,hour = 0, day = 0,year = 0;
		String summary;
		String summary2;
		String currTime2;
		double temp;
		double apptemp;
		double humid;
		
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
	            .exclude(ForecastRequestBuilder.Block.minutely)
	            .extendHourly()
	            .location(new GeoCoordinates(new Longitude(-85.886879), new Latitude(42.966679))).build();

	        DarkSkyClient client = new DarkSkyClient();
	        String forecast = client.forecastJsonString(request);
	        System.out.println(forecast);
	        

//	        
//	        String str = "{ \"name\": \"Alice\", \"age\": 20 }";
	        JSONObject obj = new JSONObject(forecast);
	        
	        currLong = obj.getDouble("longitude");
	        currLat = obj.getDouble("latitude");
	        currTime = obj.getJSONObject("currently").getInt("time");
//	        currTime2 = obj.getJSONObject("currently").getString("time");
	        String icon = obj.getJSONObject("currently").getString("icon");
	        summary = obj.getJSONObject("currently").getString("summary");
	        currPrecipProb = obj.getJSONObject("currently").getDouble("precipProbability");
	        temp = obj.getJSONObject("currently").getDouble("temperature");
	        apptemp = obj.getJSONObject("currently").getDouble("apparentTemperature");
	        
	        humid = obj.getJSONObject("currently").getDouble("humidity");
	        int hourly = obj.getJSONObject("hourly").getJSONArray("data").getJSONObject(0).getInt("time");
	        
	        
	        
	        
	        
/**	        
	        for (; currTime > 0;currTime--){
	        	sec++;
	        	if (sec == 60){
	        		sec = 0;
	        		min++;
	        	}
	        	if (min == 60){
	        		min = 0;
	        		hour++;
	        	}
	        	if (hour == 24){
	        		hour = 0;
	        		day++;
	        	}
	        	if (day == 365){
	        		day = 0;
	        		year++;
	        	}
	        }
	        **/
	        String time = hour + ":" + min + ":" + sec;
	        
	        System.out.println(currLong + ", " + currLat );
	        System.out.println(currTime + ", " + currPrecipProb);
	        System.out.println(summary);
//	        System.out.println(time);
	        System.out.println(hourly);

//	        // http://theoryapp.com/parse-json-in-java/
	        
//	        create date class
//	        time * 1000
//	        getdate() 

	        
	}
}
