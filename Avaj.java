/*************************************************************
 * File              : Avaj.java
 * Author            : Pierre Cariou <pierrecariou@outlook.fr>
 * Date              : 30.10.2022
 * Last Modified Date: 30.10.2022
 * Last Modified By  : Pierre Cariou <pierrecariou@outlook.fr>
 *************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Avaj
{
	public static void lineSimulation(String line)
	{		
		System.out.println(line);
	}

	public static void fileSimulation(String fileName)
	{
		try {
			File myfile = new File(fileName);
			Scanner openfile = new Scanner(myfile);
			while (openfile.hasNextLine()) {
				lineSimulation(openfile.nextLine());
			}
			openfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exists");
			//e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		if (args.length != 1) {
			System.err.println("You need to povide a scenario file");
			return ;
		}
		fileSimulation(args[0]);

		//Coordinates coor = new Coordinates(1, 2, 3);
		//Aircraft plane = new Aircraft("Airbus", coor);
	}
}
