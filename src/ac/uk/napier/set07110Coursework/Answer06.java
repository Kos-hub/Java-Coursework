package ac.uk.napier.set07110Coursework;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110UserClasses.ReadList;
import ac.uk.napier.set07110UserClasses.WeatherStation;
import ac.uk.napier.set07110UserClasses.WeatherReading;
import gui.MapGui;

/**
 * QUESTION 06
 * 
 * If you decide to answer question 06 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer06 {
	public static void main(String[] args) {
		System.out.println("Question 06");
		/*
		 * Add your code below
		 */
		ReadList list = new ReadList();
		WeatherStation mostReadings = null;

		// Iterate through the HashMap.
		for (int key : list.listOfStations.keySet()) {
			// Get a single station.
			WeatherStation station = list.listOfStations.get(key);
			// Compare the size of the ArrayList of readings with the old station that holds
			// the highest number.
			// If the station that we got from the HashMap has an higher number, then the
			// station with most readings becomes that station.
			if (mostReadings == null || station.getReading().size() > mostReadings.getReading().size()) {
				mostReadings = station;
			}
		}

		System.out.println(mostReadings);

		double lat = mostReadings.getLatitude();
		double lon = mostReadings.getLongitude();
		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);
	}
}
