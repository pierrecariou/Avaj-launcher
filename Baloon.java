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
		coordinates = new Coordinates(longitude, latitude, height);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}
}
