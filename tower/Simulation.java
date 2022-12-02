package tower;

public class Simulation
{
	private final WeatherTower weatherTower;

	public Simulation(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}

	public void simulate(int numSimulations)
	{
		for (int i = 0; i < numSimulations; i++) {
			weatherTower.changeWeather();
		}
	}
}
