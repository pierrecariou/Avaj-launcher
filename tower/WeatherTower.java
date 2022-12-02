package tower;

import tower.provider.*;
import aircraft.*;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates)
	{
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather()
	{
		conditionsChanged();
	}
}
