import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void Main() {
		
		searchGUI x = new searchGUI();
		x.setVisible(false);
		x.Long = -85.95365;
		x.Lat = 42.97225;
	
	}
	
	@org.junit.Test
	public void GetLong() {
		
		searchGUI x = new searchGUI();
		x.setVisible(false);
		searchGUI.Long = -85.95365;
		searchGUI.Lat = 42.97225;
	   double lat = x.getLong();
	   if (searchGUI.Long = lat) {
		   
	   }	   
	}
	
	



}
