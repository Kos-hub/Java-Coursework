package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110UserClasses.ReadList;
import ac.uk.napier.set07110UserClasses.WeatherReading;
import ac.uk.napier.set07110UserClasses.WeatherStation;
import gui.MapGui;

/**
 * QUESTION 09
 * 
 * If you decide to answer question 09 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer09 {
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Question 09");
		/*
		 * Add your code below
		 */
		ReadList list = new ReadList();
		ArrayList<WeatherReading> readings = new ArrayList<>();
		ArrayList<Integer> siteIDs = new ArrayList<>();
		ArrayList<Coordinate> coordinates = new ArrayList<>();

		// We iterate through the HashMap of WeatherStations.
		for (int key : list.listOfStations.keySet()) {
			// We take a station from the HashMap.
			WeatherStation station = list.listOfStations.get(key);
			// We iterate through the ArrayList of readings of each single station.
			for (int i = 0; i < station.getReading().size(); i++) {
				// We check if the ArrayList of readings contains at least a temperature of 25
				// degrees or more
				if (station.getReading().get(i).getTemperature() >= 25) {
					// If that's the case, we break out of the for loop and we go to the next
					// station.
					readings.add(station.getReading().get(i));
					break;
				}
			}
		}

		System.out.println("There are " + readings.size() + " Weather Stations that have recorded 25 degrees or more.");

		// We create a for loop that gets the siteIDs from the readings
		for (int i = 0; i < readings.size(); i++) {
			siteIDs.add(readings.get(i).getSiteId());
		}

		// Then we use a for loop to iterate through the ArrayList of siteIDs. We use
		// the various keys to get each single station and for each single station we
		// get the lat and the lon.
		for (int x = 0; x < siteIDs.size(); x++) {
			WeatherStation station = list.listOfStations.get(siteIDs.get(x));
			double lat = station.getLatitude();
			double lon = station.getLongitude();
			Coordinate stationCoordinates = new Coordinate(lat, lon);
			coordinates.add(stationCoordinates);
		}

		MapGui.showMap(coordinates);

	}
}
