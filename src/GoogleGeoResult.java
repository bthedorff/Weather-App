/*****************************************************************
* Part of parsing the google API, not coded by us
* can be found here:
* https://halexv.blogspot.com/2015/07/java-geocoding-using-google-maps-api.html
*
*****************************************************************/
public class GoogleGeoResult   {
    private GoogleGeoAdressComponent [] address_components;
    private String formatted_address;
    private GoogleGeoGeometry geometry;
    private Boolean partial_match;
    private String place_id;
    private String [] types;

}  