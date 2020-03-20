package ac.uk.napier.set07110UserClasses;

import java.util.ArrayList;
import java.util.HashMap;

import weather.WeatherData;

/**
 * This class reads all the WeatherReadings from a .csv file and then puts each single WeatherReading into an ArrayList and each WeatherStation in an HashMap 
 * @author Gianmarco(40439919)
 *
 */
public class ReadList {

	String[] data = WeatherData.getData();
	public ArrayList<WeatherReading> listOfReadings = new ArrayList<>();
	public HashMap<Integer, WeatherStation> listOfStations = new HashMap<>();

	public ReadList() {

		//For loop that iterates through all the readings in the Array.
		for (int i = 1; i < data.length; i++) {

			/*
			 * We take each single element of the array and we use the method .split() to split the comma separated data 
			 * so we have separated variables for each single type of data.
			 */
			String line = data[i];

			String[] elements = line.split(",");

			int siteId = Integer.parseInt(elements[0]);
			String siteName = elements[1];
			double latitude = Double.parseDouble(elements[2]);
			double longitude = Double.parseDouble(elements[3]);

			int year = Integer.parseInt(elements[4]);
			int month = Integer.parseInt(elements[5]);
			int date = Integer.parseInt(elements[6]);
			int hour = Integer.parseInt(elements[7]);
			int windSpeed = Integer.parseInt(elements[8]);
			double temperature = Double.parseDouble(elements[9]);

			//We put all the data regarding a WeatherReading in a variable called reading.
			WeatherReading reading = new WeatherReading(siteId, year, month, date, hour, windSpeed, temperature);
			//We use a temporary station in order to check if a single reading's siteId corresponds to a specific siteId.
			WeatherStation tempStat = listOfStations.get(siteId);

			if (tempStat != null) {
				ArrayList<WeatherReading> tempListReadings = tempStat.getReading();
				tempListReadings.add(reading);

				tempStat.setReading(tempListReadings);
				listOfStations.put(siteId, tempStat);
			} else {
				ArrayList<WeatherReading> tempListReadings = new ArrayList<WeatherReading>();
				tempListReadings.add(reading);

				WeatherStation station = new WeatherStation(siteId, siteName, latitude, longitude, tempListReadings);
				listOfStations.put(siteId, station);
			}
			listOfReadings.add(reading);
		}
	}
}
