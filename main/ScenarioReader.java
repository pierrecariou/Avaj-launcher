package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ScenarioReader
{
	private ArrayList<String[]> scenarioWords;
	
	public void readFile(String fileName)
	{
		scenarioWords = new ArrayList<>();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				scenarioWords.add(line.split(" "));
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public ArrayList<String[]> getScenario()
	{
		return scenarioWords;	
	}
}
