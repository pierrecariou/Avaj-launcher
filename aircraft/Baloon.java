package aircraft;

import tower.*;
import aircraft.observer.Flyable;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();

		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				longitude+=2;
				height+=4;
				break;
			case "RAIN":
				height-=5;
				break;
			case "FOG":
				height-=3;
				break;
			case "SNOW":
				height-=15;
				break;
		}
		try {
			coordinates = new Coordinates(longitude, latitude, height);
		} catch (HeightLessThanZeroException hltze) {
			System.out.println(getAllInfo() + ": landing.");
			weatherTower.unregister(this);
		} catch (Exception e) {}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

	public void logMessage()
	{
		System.out.print(getAllInfo());
		String weather = weatherTower.getWeather(coordinates);
		switch (weather)  {
			case "SUN":
				System.out.println(": I'm swetting.");
				break;
			case "RAIN":
				System.out.println(": I'm singing in the rain!");
				break;
			case "SNOW":
				System.out.println(": The climate is weird nowdays.");
				break;
			case "FOG":
				System.out.println(": I'm scared.");
				break;
		}
	}
}
