package aircraft;

class HeightLessThanZeroException extends Exception
{
	HeightLessThanZeroException()
	{
		super("Height is less than zero.");
	}
}
