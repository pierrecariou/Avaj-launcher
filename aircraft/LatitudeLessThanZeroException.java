package aircraft;

class LatitudeLessThanZeroException extends Exception
{
	LatitudeLessThanZeroException()
	{
		super("Latitude is less than zero.");
	}
}
