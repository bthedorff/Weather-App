import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*****************************************************************
* Search Gui, used to pick a pre-coded location or input a
* new location based on Longitude and Latitude
* 
* @author Brandon Thedorff
* @author Nick Pydyn
* @author Denver DeBoer
* @author Ryan De Jong
* @version Fall 2007
******************************************************************/
public class searchGUI extends JFrame implements ActionListener {
	/**Displays the weather information*/
	private JPanel Panel;
	/**Label for Location*/
	private JLabel location;
	/**Label for Longitude input*/
	private JLabel enterLongitude;
	/**Label for Latitude input*/
	private JLabel enterLatitude;
	/**Used to search for a location*/
	private JButton enterBut;
	/**Allows the user to enter a location*/
	private JTextField inpLat;
	/**text field for long input for Location*/
	private JTextField inpLong;
	/** Defaults for longitude and latitude */
	public double Long = -0.12574, Lat = 51.50853;
	/**Creates the JCombobox of locations */
	JComboBox<String> locList;

	/**Initializes each variable*/
	public searchGUI() {
		setTitle("Set Location");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** creates a string of locations for the combobox */
		String[] Locations = new String[] {"Custom", "Allendale, MI", "Denver, CO", "Los Angeles, CA", "New York, NY",
				"Detroit, MI", "London, UK"};
		locList = new JComboBox<>(Locations);

		Panel = (JPanel) getContentPane();
		Panel.setLayout(null);

		/**Initializes search button*/
		enterBut = new JButton("Enter");
		enterBut.addActionListener(this);

		/**Initializes search bar*/
		inpLat = new JTextField("",10);
		inpLong = new JTextField("",10);
		location = new JLabel("Choose Desired Location:");
		enterLongitude = new JLabel("Enter Longitude:");
		enterLatitude = new JLabel("Enter Latitude:");

		/**Organizes components on the panel*/
		location.setBounds(10, 20, 250, 30);
		locList.setBounds(175, 20, 160, 30);
		enterBut.setBounds(160, 155, 130, 30);
		inpLat.setBounds(120, 70, 250, 30);
		enterLatitude.setBounds(16, 70, 250, 30);
		inpLong.setBounds(120, 110, 250, 30);
		enterLongitude.setBounds(10, 110, 250, 30);
		
		/** adds to the panel */
		Panel.add(enterBut);
		Panel.add(inpLat);
		Panel.add(inpLong);
		Panel.add(location);
		Panel.add(enterLongitude);
		Panel.add(enterLatitude);
		Panel.add(locList);

		/** sets size, location and visiblity of the box */
		setSize(450, 250);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/********************************************
	 * Returns the location the user entered
	 ********************************************/
	public void setCoordinates(String Location)
	{
		if (Location.equals("Allendale, MI") )
		{
			Long = -85.95365;
			Lat = 42.97225;
		} else if (Location.equals("Denver, CO"))
		{
			Long = -104.9847;
			Lat = 39.73915;
		} else if (Location.equals("Los Angeles, CA"))
		{
			Long = -118.24368;
			Lat = 34.05223;
		} else if (Location.equals("Detroit, MI"))
		{
			Long = -83.04575;
			Lat = 42.33143;
		} else if  (Location.equals("New York, NY"))
		{
			Long = -74.00597;
			Lat = 40.71427;
		} else if (Location.equals("London, UK"))
		{
			Long = -0.12574;
			Lat = 51.50853;
		} else
		{
			Long = -85.95365;
			Lat = 42.97225;
		}
	}
	/****************************************
	 * Gets the longitude
	 * @return Long The longitude inputed
	 ***************************************/
	public double getLong() {
		return Long;
	}
	/****************************************
	 * Gets the latitude
	 * @return Lat The latitude inputed
	 ***************************************/
	public double getLat() {
		return Lat;
	}

	/*************************************************
	 * Stores user's input and calls API
	 * @param e the user pressing the search button
	 ************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == enterBut) {
			if (locList.getSelectedItem() != "Custom")
			{
				this.setCoordinates((String) locList.getSelectedItem());
			} else {
				try {
				Long = Double.parseDouble(inpLong.getText());
				Lat = Double.parseDouble(inpLat.getText());
				if ((!(-180.0 <= Long && Long <= 180.0) || !(-90 <= Lat && Lat <= 90))) {
					inpLong.setText("");
					inpLat.setText("");
					return;
				} 
				} catch (Exception ex) {
					inpLong.setText("");
					inpLat.setText("");
					return;
				}
				
			}
			dispose();
			/** Code to call the API with given coordinates and the DailyGUI */
			WeatherData data = new WeatherData();
			double[] coords = new double[2];
			APIPuller pull = new APIPuller();
			
			coords[0] = this.getLong();
			coords[1] = this.getLat();
			try {
				data = pull.gather(coords);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}
}
