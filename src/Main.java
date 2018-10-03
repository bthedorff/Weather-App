import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;
import tk.plogitech.darksky.forecast.*;

// API Key   5f3d14bc52bfc3ec10922d31be0e7e61
//test
public class Main {
	public static void main(String args[]) throws ForecastException {
		ForecastRequest request = new ForecastRequestBuilder()
	        .key(new APIKey("5f3d14bc52bfc3ec10922d31be0e7e61"))
	        .location(new GeoCoordinates(new Longitude(-85.886879), new Latitude(42.966679))).build();

	    DarkSkyClient client = new DarkSkyClient();
	    String forecast = client.forecastJsonString(request);
	    System.out.println(forecast);

	}
}

//test test

//ytr
//hello