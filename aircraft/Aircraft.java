package aircraft;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		id = nextId();
	}

	private Long nextId()
	{
		return ++idCounter;
	}

	public String getAllInfo()
	{
		return (this.getClass().getSimpleName() + '#' + name + "(" + id + ")");
	}
}
