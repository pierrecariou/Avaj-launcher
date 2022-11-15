/*************************************************************
 * File              : Aircraft.java
 * Author            : Pierre Cariou <pierrecariou@outlook.fr>
 * Date              : 30.10.2022
 * Last Modified Date: 30.10.2022
 * Last Modified By  : Pierre Cariou <pierrecariou@outlook.fr>
 *************************************************************/

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private long idCounter;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
	}

	private Long nextId()
	{
		return id + 1;
	}
}
