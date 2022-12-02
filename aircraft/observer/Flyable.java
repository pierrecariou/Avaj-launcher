package aircraft.observer;

import tower.*;

public interface Flyable
{
	public void updateConditions();				
	public void registerTower(WeatherTower weatherTower);
	public void logMessage();
	public String getAllInfo();
}
