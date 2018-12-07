import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

/*****************************************************************
* Part of parsing the google API, not coded by us
* But edited by us
* can be found here:
* https://halexv.blogspot.com/2015/07/java-geocoding-using-
* google-maps-api.html
*****************************************************************/

/****************************************************************
 * Googles main method used to parse out the Google API
 * data from a JSON file
 * 
 ****************************************************************/
public class GooglesMain {
	public String getGeoCode(double lon, double lat, boolean ssl) throws Exception {
	    // build url
	    StringBuilder url = new StringBuilder("http");
	    if ( ssl ) {
	        url.append("s");
	    }
	    url.append("://maps.googleapis.com/maps/api/geocode/json?");
	    String API_KEY = "AIzaSyC-R5ltDUdew5JR_LpFQWOlLla9Y4Wdxog";
	    url.append("latlng=");
	    url.append(lat);   // latitude
	    url.append(",");
	    url.append(lon);    // longitude
	    url.append("&");
	    if ( ssl ) {
	        url.append("key=");
	        url.append(API_KEY);
	    }
	    
	  
	    // request url like: http://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address) + "&sensor=false"
	    // do request
	    try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
	        HttpGet request = new HttpGet(url.toString());

	        // set common headers (may useless)
	        request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.6.0");
	        request.setHeader("Host", "maps.googleapis.com");
	        request.setHeader("Connection", "keep-alive");
	        request.setHeader("Accept-Language", "en-US,en;q=0.5");
	        request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	        request.setHeader("Accept-Encoding", "gzip, deflate");

	        try (CloseableHttpResponse response = httpclient.execute(request)) {
	            HttpEntity entity = response.getEntity();

	            // recover String response (for debug purposes)
	            StringBuilder result = new StringBuilder();
	            try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    result.append(inputLine);
	                    result.append("\n");
	                }
	            }            
	            return result.toString();
	        }
	    }
	}
}
