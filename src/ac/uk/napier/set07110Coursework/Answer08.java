package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110UserClasses.ReadList;
import ac.uk.napier.set07110UserClasses.WeatherReading;
import ac.uk.napier.set07110UserClasses.WeatherStation;
import gui.MapGui;

/**
 * QUESTION 08
 * 
 * If you decide to answer question 08 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer08 {
	public static void main(String[] args) {
		System.out.println("Question 08");
		/*
		 * Add your code below
		 */

		ReadList list = new ReadList();

		// We take the specific station using the siteId provided in the question.
		WeatherStation station = list.listOfStations.get(3609);
		// We get all the readings of that specific station.
		ArrayList<WeatherReading> readings = new ArrayList<>();
		readings.addAll(station.getReading());

		double minTemp = 0;
		double maxTemp = 0;
		double sumOfTemps = 0;

		ArrayList<WeatherReading> augustReadings = new ArrayList<>();

		// Then we iterate through the ArrayList of readings.
		for (int i = 0; i < readings.size(); i++) {
			// We want to keep only the readings that have been recorded in august, so we
			// use an if statement to do that and we use another ArrayList to store these.
			if (readings.get(i).getMonth() == 8 && readings.get(i).getHour() == 15) {
				augustReadings.add(readings.get(i));
			}
		}

		// Then we check which is the maximum and the minimum temperature recorded in
		// August in the same way as we did before.
		for (int i = 0; i < augustReadings.size(); i++) {

			WeatherReading reading = augustReadings.get(i);

			if (minTemp == 0 || reading.getTemperature() < minTemp) {
				minTemp = reading.getTemperature();
			}

			if (maxTemp == 0 || reading.getTemperature() > maxTemp) {
				maxTemp = reading.getTemperature();
			}

			// Then, in order to get the sum out of it, we take each single reading and we
			// add them into the variable sumOfTemps.
			sumOfTemps += reading.getTemperature();
		}

		System.out.println("The minimum temperature is = " + minTemp);
		System.out.println("The maximum temperature is = " + maxTemp);

		// In the end, we want to get the average so we divide the sum of all the august
		// readings with the length of the ArrayList of augustReadings.
		System.out.println("The average temperature is = " + sumOfTemps / augustReadings.size());

		double lat = station.getLatitude();
		double lon = station.getLongitude();

		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);

	}
}
