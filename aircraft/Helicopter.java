package aircraft;

import tower.*;
import aircraft.observer.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates)
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
				longitude+=10;
				height+=2;
				break;
			case "RAIN":
				longitude+=5;
				break;
			case "FOG":
				longitude+=1;
				break;
			case "SNOW":
				height-=12;
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
				System.out.println(": great Weather!");
				break;
			case "RAIN":
				System.out.println(": I'm as slippery as soap.");
				break;
			case "SNOW":
				System.out.println(": My rotor blades are freezing.");
				break;
			case "FOG":
				System.out.println(": I can't see anything in this fog...");
				break;
		}
	}
}
