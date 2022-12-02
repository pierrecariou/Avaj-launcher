package main;

import java.util.ArrayList;

import aircraft.AircraftFactory;
import tower.WeatherTower;
import aircraft.observer.*;
import tower.*;

class Main
{
	private static void createAircrafts(ArrayList<String[]> scenario, WeatherTower weatherTower)
	{
		final AircraftFactory aircraftFactory = new AircraftFactory();

		for (String[] infos : scenario) {
			try {
				Flyable flyable = aircraftFactory.newAircraft(infos[0], infos[1], Integer.parseInt(infos[2]),
						Integer.parseInt(infos[3]), Integer.parseInt(infos[4]));
				flyable.registerTower(weatherTower);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Invalid scenario file");
				System.exit(1);
			}
		}
	}

	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.out.println("You need to provide a scenario file");
			return ;
		}
		ScenarioReader scenarioReader = new ScenarioReader();
		scenarioReader.readFile(args[0]);
		ArrayList<String[]> scenario = scenarioReader.getScenario();

		try {
			int numSimulations = Integer.parseInt(scenario.get(0)[0]);
			scenario.remove(0);
			WeatherTower weatherTower = new WeatherTower();

			createAircrafts(scenario, weatherTower);
			new Simulation(weatherTower).simulate(numSimulations);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid scenario file");
			System.exit(1);
		}
	}
}
