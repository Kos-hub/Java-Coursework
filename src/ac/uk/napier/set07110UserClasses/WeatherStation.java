package ac.uk.napier.set07110UserClasses;

import java.util.ArrayList;
/**
 * This class is an object called "WeatherStation" that holds all the informations about a WeatherStation (siteId, siteName, latitude and longitude),
 * including an ArrayList of the readings recorded at that specific WeatherStation. 
 * @author Gianmarco(40439919)
 *
 */
public class WeatherStation {

	private int siteId;
	private String siteName;
	private double latitude;
	private double longitude;
	private ArrayList<WeatherReading> reading = new ArrayList<>();

	public WeatherStation(int siteId, String siteName, double latitude, double longitude,
			ArrayList<WeatherReading> reading) {
		this.siteId = siteId;
		this.siteName = siteName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.reading = reading;
	}

	public int getSiteId() {
		return siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public ArrayList<WeatherReading> getReading() {
		return reading;
	}

	public void setReading(ArrayList<WeatherReading> reading) {
		this.reading = reading;
	}

	@Override
	public String toString() {
		return "WeatherStation [siteId=" + siteId + ", siteName=" + siteName + ", latitude=" + latitude + ", longitude="
				+ longitude + ", readings= " + reading.size() + "]";
	}
}
