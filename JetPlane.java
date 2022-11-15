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
		coordinates = new Coordinates(longitude, latitude, height);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}
}
