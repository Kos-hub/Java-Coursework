package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110UserClasses.ReadList;
import ac.uk.napier.set07110UserClasses.WeatherReading;
import ac.uk.napier.set07110UserClasses.WeatherStation;
import gui.MapGui;

/**
 * QUESTION 07
 * 
 * If you decide to answer question 07 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer07 {
	public static void main(String[] args) {
		System.out.println("Question 07");
		/*
		 * Add your code below
		 */
		ReadList list = new ReadList();
		// We take the specific station Id that we get from the question.
		WeatherStation station = list.listOfStations.get(3065);
		WeatherReading highReading = null;

		ArrayList<WeatherReading> stationReadings = new ArrayList<>();
		stationReadings.addAll(station.getReading());

		// We iterate through all the readings of that specific station.
		for (int i = 0; i < stationReadings.size(); i++) {
			WeatherReading reading = stationReadings.get(i);
			// If the reading that we get from the ArrayList has an higher temperature than
			// the previous reading that had the previous higher temperature.
			// The reading with the highest temperature becomes the last reading that we
			// got.
			if (highReading == null || reading.getTemperature() > highReading.getTemperature()) {
				highReading = reading;
			}
		}

		System.out.println("Temperature = " + highReading.getTemperature() + ", Year = " + highReading.getYear()
				+ ", Month = " + highReading.getMonth() + ", Date = " + highReading.getDate());

		double lat = station.getLatitude();
		double lon = station.getLongitude();
		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);
	}
}
