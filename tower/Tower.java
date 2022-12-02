package tower;

import java.util.*;
import aircraft.observer.*;

public class Tower
{
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
		System.out.println("Tower says: " + flyable.getAllInfo() + " registered to weather tower.");
	}

	public void unregister(Flyable flyable)
	{
		observers.remove(flyable);
		System.out.println("Tower says: " + flyable.getAllInfo() + " unregistered to weather tower.");
	}

	protected void conditionsChanged()
	{
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).logMessage();
			observers.get(i).updateConditions();
		}
	}
}
