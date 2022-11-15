public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type == "Baloon")
			return new Baloon(type, coordinates);
		if (type == "JetPlane")
			return new JetPlane(name, coordinates);
		if (type == "Helicopter")
			return new Helicopter(name, coordinates);
		return null;
	}
}
