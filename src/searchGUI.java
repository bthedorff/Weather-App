import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class searchGUI extends JFrame implements ActionListener{
	/**Displays the weather information*/
	private JPanel Panel;
	/**Instructs the user*/
	private JLabel location;
	private JLabel enterLongitude;
	private JLabel enterLatitude;
	/**Used to search for a location*/

	private JButton enterBut;
	/**Allows the user to enter a location*/
	private JTextField inpLat;
	private JTextField inpLong;
	/**Holds the user's desired location*/
	public static String userLoc = "Choose Location";
	public static double Long = -0.12574, Lat = 51.50853;
	public boolean waiting = true;
	
	private JComboBox<String> locList;

	/**Initializes each variable*/
	public searchGUI() {
		setTitle("Set Location");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] Locations = new String[] {"Custom", "Allendale, MI", "Denver, CO", "Los Angeles, CA", "New York, NY",
				"Detroit, MI", "London, UK"};
		locList = new JComboBox<>(Locations);

		Panel = (JPanel) getContentPane();
		Panel.setLayout(null);

		/**Initializes search button*/
		enterBut = new JButton("Enter");
		enterBut.addActionListener(this);

		/**Initializes search bar*/
		inpLat= new JTextField("",10);
		inpLong= new JTextField("",10);
		location = new JLabel("Choose Desired Location:");
		enterLongitude = new JLabel("Enter Longitude:");
		enterLatitude = new JLabel("Enter Latitude:");

		/**Organizes components on the panel*/
		location.setBounds(10, 20, 250, 30);
		locList.setBounds(175, 20, 160, 30);
		enterBut.setBounds(160, 155, 130, 30);
		inpLat.setBounds(120, 70, 250, 30);
		enterLatitude.setBounds(16, 110, 250, 30);
		inpLong.setBounds(120, 110, 250, 30);
		enterLongitude.setBounds(10, 70, 250, 30);
		
		
		Panel.add(enterBut);
		Panel.add(inpLat);
		Panel.add(inpLong);
		Panel.add(location);
		Panel.add(enterLongitude);
		Panel.add(enterLatitude);
		Panel.add(locList);
		
		setSize(450, 215);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	/////////////////DELETE FOR FINAL///////////////////
	/////////////////RUN IN MAIN////////////////////////
	//public static void main(String[] args) {
	//	new searchGUI();
	//}
	////////////////////////////////////////////////////

	/**
	 * Returns the location the user entered
	 * @return userLoc user's location
	 */

	
	public void setCoordinates(String Location)
	{
		if(Location == "Allendale, MI")
		{
			Long = -85.95365;
			Lat = 42.97225;
		}
		else if(Location == "Denver, CO")
		{
			Long = -104.9847;
			Lat = 39.73915;
		}
		else if(Location == "Los Angeles, CA")
		{
			Long = -118.24368;
			Lat = 34.05223;
		}
		else if(Location == "Detroit, MI")
		{
			Long = -83.04575;
			Lat = 42.33143;
		}
		else if(Location == "New York, NY")
		{
			Long = -74.00597;
			Lat = 40.71427;
		}
		else if(Location == "London, UK")
		{
			Long = -0.12574;
			Lat = 51.50853;
		}
		else
		{
			Long = -85.95365;
			Lat = 42.97225;
		}
	}
	
	public double getLong()
	{
		return Long;
	}
	
	public double getLat()
	{
		return Lat;
	}

	/**
	 * Stores user's input
	 * @param e the user pressing the search button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == enterBut) {
			if(locList.getSelectedItem() != "Custom")
			{
				this.setCoordinates((String) locList.getSelectedItem());
			}
			else
			{
				Long = Double.parseDouble(inpLong.getText());
				Lat = Double.parseDouble(inpLat.getText());
			}
			dispose();
			WeatherData data = new WeatherData();
			double[] coords = new double[2];
			APIPuller pull = new APIPuller();
			
			coords[0] = sgui.getLong();
			coords[1] = sgui.getLat();
			try {
				data = pull.gather(coords);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			//^ replace null with call to search gui. have gui return the longitude and latitude values as an array of 2 doubles. 
			
			DailyGUI dgui = new DailyGUI(data);
		}
	}
}