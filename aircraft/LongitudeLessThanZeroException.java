package aircraft;

class LongitudeLessThanZeroException extends Exception
{
	LongitudeLessThanZeroException()
	{
		super("Longitude is less than zero.");
	}
}
