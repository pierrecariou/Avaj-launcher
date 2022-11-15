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
		coordinates = new Coordinates(longitude, latitude, height);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}
}
