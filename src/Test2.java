import static org.junit.Assert.*;

import org.junit.Test;
/*****************************************************************
* Test Cases
* 
* @author Brandon Thedorff
* @author Nick Pydyn
* @author Denver DeBoer
* @author Ryan De Jong
* @version Fall 2007
******************************************************************/
public class Test2 {

	@org.junit.Test
	public void Main() {

		searchGUI x = new searchGUI();
		x.setVisible(false);
		x.Long = -0.12574;
		x.Lat = 51.50853;

	}

	@org.junit.Test
	public void checkLongLat() {
		
		searchGUI x = new searchGUI();
		x.setVisible(false);
		searchGUI.Long = -85.95365;
		searchGUI.Lat = 42.97225;
	   if (searchGUI.Long < 180 || searchGUI.Long > -180) {
		   fail ("Invalid Longitude");
	   }
	   if (searchGUI.Lat < 90 || searchGUI.Lat > -90) {
		   fail ("Invalid Latitude");
	   }
	}
}
