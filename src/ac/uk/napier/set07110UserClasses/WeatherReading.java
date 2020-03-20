package ac.uk.napier.set07110UserClasses;
/**
 * This class is an object called WeatherReadings which holds all the information about a specific WeatherReading 
 * (year, month, date, hour, windSpeed and temperature).
 * Each WeatherReading has been taken in a specific WeatherStation, 
 * that's why this object holds the siteId variable which we will use in order to identify the station in which the reading has been taken.
 * @author Gianmarco(40439919)
 *
 */
public class WeatherReading {

	private int siteId;
	private int year;
	private int month;
	private int date;
	private int hour;
	private int windSpeed;
	private double temperature;

	public WeatherReading(int siteId, int year, int month, int date, int hour, int windSpeed, double temperature) {
		this.siteId = siteId;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
	}

	public int getSiteId() {
		return siteId;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public int getHour() {
		return hour;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public double getTemperature() {
		return temperature;
	}

	@Override
	public String toString() {
		return "WeatherReadings [siteId=" + siteId + ", year=" + year + ", month=" + month + ", date=" + date
				+ ", hour=" + hour + ", windSpeed=" + windSpeed + ", temperature=" + temperature + "]";
	}
}
