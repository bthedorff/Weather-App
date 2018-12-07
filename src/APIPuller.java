import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.json.JSONObject;

import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.DarkSkyClient;
import tk.plogitech.darksky.forecast.ForecastRequest;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

/*****************************************************************
* Pulls data from the API and parses the data needed
* 
* @author Brandon Thedorff
* @author Nick Pydyn
* @author Denver DeBoer
* @author Ryan De Jong
* @version Fall 2007
******************************************************************/
public class APIPuller {
	/**Data objects to home */
	WeatherData data = new WeatherData();
	
	//for testing only
	public static void main(String args[])throws Exception{
		APIPuller pull = new APIPuller();
		double[] coords= new double[2];
		coords[0] = -118.24368;
		coords[1] = 34.05223;
		pull.gather(coords);
	}
	
	/**create object to call */
	APIPuller(){
		
	}
	/*****************************************************************
    Constructor creates a die of specified size X size pixels
    @param coords The coordinates of the location 
    *****************************************************************/
	public WeatherData gather(double[] coords) throws Exception{
		
		String APIKey = "5f3d14bc52bfc3ec10922d31be0e7e61";
		
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
	    
		DarkSkyClient client = new DarkSkyClient();
		JSONObject obj;
		
		//creates a request for the current day (more accu rate)
		ForecastRequest current = new ForecastRequestBuilder()
	            .key(new APIKey(APIKey))
	            .time(Instant.now().plus(0, ChronoUnit.DAYS))
	            .language(ForecastRequestBuilder.Language.en)
	            .units(ForecastRequestBuilder.Units.us)
	            .exclude(ForecastRequestBuilder.Block.minutely)
	            .exclude(ForecastRequestBuilder.Block.hourly)
	            .location(new GeoCoordinates(new Longitude(coords[0]), new Latitude(coords[1]))).build();

	    //creates a string containing API data
	    String forecast = client.forecastJsonString(current);
	        
	    //stores this data to a JSONObject for parsing
	    obj = new JSONObject(forecast);
	        
	    //locates data and stores to WeatherData object
	    data.highTemp[0] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("temperatureHigh");
	    data.lowTemp[0] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("temperatureLow");
	    data.temp[0] = obj.getJSONObject("currently").getDouble("temperature");
	    data.feelsLike[0] = obj.getJSONObject("currently").getDouble("apparentTemperature");
	    data.humidity[0] = (int)(obj.getJSONObject("currently").getDouble("humidity") * 100);
	    data.precipProb[0] = (int)(obj.getJSONObject("currently").getDouble("precipProbability") * 100);
	    data.forecast[0] = obj.getJSONObject("currently").getString("summary");
	    data.weatherIcon[0] = obj.getJSONObject("currently").getString("icon");
	    data.windSpeed[0] = obj.getJSONObject("currently").getLong("windSpeed");
	    data.date[0] = new Date(obj.getJSONObject("currently").getLong("time"));
	    if (forecast.contains("alerts")){
	    	data.warnStart = new Date(obj.getJSONObject("alerts").getLong("time"));
	    	data.warnStop = new Date(obj.getJSONObject("alerts").getLong("expires"));
	    	data.warnTitle = obj.getJSONObject("alerts").getString("title");
	    	data.warning = obj.getJSONObject("alerts").getString("description");
	    }
	    
	    //System.out.println(forecast);  
	
		//repeats API calling process for the week in the future (not at all efficient but daily 
	        //does not work as described in API docs
		for (int i = 1;i <= 7;i++){ //maybe move to new method that forecastGUI could call? would reduce initial lag and API calls
			//sets specifications on how API data should be called
		    ForecastRequest request = new ForecastRequestBuilder()
		            .key(new APIKey(APIKey))
		            .time(Instant.now().plus(i, ChronoUnit.DAYS))
		            .language(ForecastRequestBuilder.Language.en)
		            .units(ForecastRequestBuilder.Units.us)
		            .exclude(ForecastRequestBuilder.Block.minutely)
		            .exclude(ForecastRequestBuilder.Block.hourly)
		            .location(new GeoCoordinates(new Longitude(coords[0]), new Latitude(coords[1]))).build();

		        
		    forecast = client.forecastJsonString(request);
		        
		    obj = new JSONObject(forecast);
		        
		        
		    data.highTemp[i] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("temperatureHigh");
		    data.lowTemp[i] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("temperatureLow");
		    data.temp[i] = (int)(((data.highTemp[i] + data.lowTemp[i]) / 2));
		    data.feelsLike[0] = (int) ((obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("apparentTemperatureHigh")
		    						+obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("apparentTemperatureLow"))/2);
		    data.humidity[i] = (int)(obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("humidity") * 100);
		    data.precipProb[i] = (int)(obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("precipProbability") * 100);
		    data.forecast[i] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getString("summary");
		    data.weatherIcon[i] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getString("icon");
		    data.windSpeed[1] = obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getLong("windSpeed");
		    data.date[1] = new Date(obj.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getLong("time"));
		}
	
		
	        
	        GooglesMain goog = new GooglesMain();
	        obj = new JSONObject(goog.getGeoCode(coords[0],coords[1],true)); //parse this object and store relevant stuff in data (WeatherData object)
			data.cityName = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(3).getString("long_name");
	        data.StateName = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(5).getString("long_name");
	        
	        
	        
	       

	        //System.out.println(data.cityName);
	        
	        //System.out.println(data.StateName);
	        
//	        ForecastRequest request2 = new ForecastRequestBuilder()
//		            .key(new APIKey(APIKey))
//		            .extendHourly()
//		           
//		            .time(Instant.now())
//		            .language(ForecastRequestBuilder.Language.en)
//		            .units(ForecastRequestBuilder.Units.auto)
//		            .exclude(ForecastRequestBuilder.Block.minutely)
//		            .exclude(ForecastRequestBuilder.Block.currently)
//		            .exclude(ForecastRequestBuilder.Block.hourly)
//		            
//		            .location(new GeoCoordinates(new Longitude(lon), new Latitude(lat))).build();
//
//	        //https://api.darksky.net/forecast/5f3d14bc52bfc3ec10922d31be0e7e61/42.966679,-85
//		        DarkSkyClient client2 = new DarkSkyClient();
//		        String forecast2 = client2.forecastJsonString(request2);
		        
		        //System.out.println(forecast2);
		        //JSONObject obj = new JSONObject(forecast2);
	        return data;
//	        // http://theoryapp.com/parse-json-in-java/
	
	}
}
