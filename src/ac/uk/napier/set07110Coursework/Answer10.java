package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110UserClasses.ReadList;
import ac.uk.napier.set07110UserClasses.WeatherReading;
import ac.uk.napier.set07110UserClasses.WeatherStation;
import gui.MapGui;

/**
 * QUESTION 10
 * 
 * If you decide to answer question 10 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer10 {
	public static void main(String[] args) {
		System.out.println("Question 10");
		/*
		 * Add your code below
		 */
		ReadList list = new ReadList();

		WeatherReading minTemp = null;
		WeatherReading maxTemp = null;

		WeatherReading mostVariationReadingMinTemp = null;
		WeatherReading mostVariationReadingMaxTemp = null;

		double variation = 0;
		double mostVariation = 0;

		// We iterate through the HashMap of WeatherStations.
		for (int key : list.listOfStations.keySet()) {

			// We get a Station and we get its readings.
			WeatherStation station = list.listOfStations.get(key);
			ArrayList<WeatherReading> readings = station.getReading();

			// We iterate through the readings to find the minimum and maximum temperatures
			// recorded in each single station.
			for (int i = 0; i < readings.size(); i++) {
				if (minTemp == null || readings.get(i).getTemperature() < minTemp.getTemperature()) {
					minTemp = readings.get(i);
				}
				if (maxTemp == null || readings.get(i).getTemperature() > maxTemp.getTemperature()) {
					maxTemp = readings.get(i);
				}
			}

			// For each single minimum and maximum temperature, we check the variation
			// calculating the difference between these two.
			variation = maxTemp.getTemperature() - minTemp.getTemperature();

			// Then we check which is the highest variation.
			if (mostVariation == 0 || variation > mostVariation) {
				mostVariation = variation;
				// And we use the highest temperature and the lowest temperature reading in
				// order to trace the station.
				mostVariationReadingMaxTemp = maxTemp;
				mostVariationReadingMinTemp = minTemp;
			}

			minTemp = null;
			maxTemp = null;

		}
		WeatherStation mostVariationStation = list.listOfStations.get(mostVariationReadingMaxTemp.getSiteId());
		System.out.println(mostVariationStation.getSiteId() + ", " + mostVariationStation.getSiteName() + ", lat = "
				+ mostVariationStation.getLatitude() + ", lon = " + mostVariationStation.getLongitude()
				+ ", minimum temperature = " + mostVariationReadingMinTemp.getTemperature() + ", maximum temperature = "
				+ mostVariationReadingMaxTemp.getTemperature());

		double lat = mostVariationStation.getLatitude();
		double lon = mostVariationStation.getLongitude();

		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);

	}
}
