import static org.junit.Assert.*;

import javax.swing.JComboBox;

public class Test {

	@org.junit.Test
	public void Main() {
		
		searchGUI x = new searchGUI();
		x.setVisible(false);
		x.Long = -85.95365;
		x.Lat = 42.97225;
		//x.locList.getSelectedItem().
	}
	
	@org.junit.Test
	public void GetLong() {
		
		searchGUI x = new searchGUI();
		x.setVisible(false);
		searchGUI.Long = -85.95365;
		searchGUI.Lat = 42.97225;
	   double lat = x.getLong();
//	   if (lat = searchGUI.Long;) {
//   
//	}
	
	



}
}
