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
    @return data Holds the data parsed out
    *****************************************************************/
	public WeatherData gather(double[] coords) throws Exception{

		String APIKey = "5f3d14bc52bfc3ec10922d31be0e7e61";

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
		//repeats API calling process for the week in the future 
		for (int i = 1;i <= 7;i++){
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
		    /** Parses JSON for weekly weather */
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

			/** parses from the google API*/
	        GooglesMain goog = new GooglesMain();
	        obj = new JSONObject(goog.getGeoCode(coords[0],coords[1],true)); //parse this object and store relevant stuff in data (WeatherData object)
			data.cityName = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(3).getString("long_name");
	        data.StateName = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(5).getString("long_name");

	        return data;
	}
}
