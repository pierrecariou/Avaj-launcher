/*************************************************************
 * File              : WeatherProvider.java
 * Author            : Pierre Cariou <pierrecariou@outlook.fr>
 * Date              : 15.11.2022
 * Last Modified Date: 15.11.2022
 * Last Modified By  : Pierre Cariou <pierrecariou@outlook.fr>
 *************************************************************/

// Singleton Design Pattern Class
public class WeatherProvider
{
	private volatile static WeatherProvider weatherProvider;
	private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

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
		return "";
	}
}
