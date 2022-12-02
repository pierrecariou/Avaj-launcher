package aircraft;

import tower.*;
import aircraft.observer.Flyable;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates)
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
				latitude+=10;
				height+=2;
				break;
			case "RAIN":
				latitude+=5;
				break;
			case "FOG":
				latitude+=1;
				break;
			case "SNOW":
				height-=7;
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
				System.out.println(": I might have a sunburn.");
				break;
			case "RAIN":
				System.out.println(": Where is my umbrella?");
				break;
			case "SNOW":
				System.out.println(": Winter is coming.");
				break;
			case "FOG":
				System.out.println(": I'm blind.");
				break;
		}
	}
}
