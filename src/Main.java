import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.json.JSONObject;

import tk.plogitech.darksky.forecast.*;

// API Key   5f3d14bc52bfc3ec10922d31be0e7e61
//test
public class Main {
	private String APIKey;
	public static void main(String args[]) throws ForecastException {
		String APIKey = "5f3d14bc52bfc3ec10922d31be0e7e61";
		double currLong;
		double currLat;
		JSONObject currTime;
		String Summary;
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
	//        System.out.println(forecast);
	        

//	        
//	        String str = "{ \"name\": \"Alice\", \"age\": 20 }";
	        JSONObject obj = new JSONObject(forecast);
	        
	        currLong = obj.getDouble("longitude");
	        currLat = obj.getDouble("latitude");
	        //currTime = obj.getString("time");\
	        currTime = obj.getJSONObject("time");
	        //Summary = obj.getString("summary");
	        
	        System.out.println(currLong + ", " + currLat );
//	        int a = obj.getInt("age");
//	        System.out.println(n + " " + a);  // prints "Alice 20"
//	        
//	        // http://theoryapp.com/parse-json-in-java/

	        
	}
}
