package tower.provider;

import aircraft.*;
import tower.Weather;

public class WeatherProvider
{
	private volatile static WeatherProvider weatherProvider;
	private static Weather[] weather = Weather.values();

	private WeatherProvider()
	{
	}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null) {
			synchronized (WeatherProvider.class) {
				if (weatherProvider == null) {
					weatherProvider = new WeatherProvider();
				}
			}
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int select = 0;

		if (coordinates.getLongitude() < 30 || coordinates.getLongitude() > 60)
			select++;
		if (coordinates.getLatitude() < 45 || coordinates.getLatitude() > 80)
			select++;
		if (coordinates.getLongitude() > 85 || coordinates.getLatitude() > 85)
			select = 3;
		return weather[select].toString();
	}
}
