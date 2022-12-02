package aircraft;

import aircraft.observer.*;

public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception
	{
		try {
			Coordinates coordinates = new Coordinates(longitude, latitude, height);

			if (type.equals("Baloon"))
				return new Baloon(type, coordinates);
			if (type.equals("JetPlane"))
				return new JetPlane(name, coordinates);
			if (type.equals("Helicopter"))
				return new Helicopter(name, coordinates);
			else
				throw new InvalidAircraftTypeException
					("Invalid aircraft type provided in scenario file: must be Ballon, JetPlane, or Helicopter");
		} catch (HeightLessThanZeroException e) {
			throw e;
		}
	}
}
