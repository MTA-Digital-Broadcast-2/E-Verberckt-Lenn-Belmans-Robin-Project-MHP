import java.lang.*;

public class Oef3
{
	public static void main(String args[])
	{
	
		double som = 1;
		double resultaat = 0;
		double a = 3;

		for (int term = 1; term < 5001; term++)
		{
			som -= (1/a);
			a+=2;
			som += (1/a);
			a+=2;
		}

		resultaat = 4 * som;
		
		System.out.println(resultaat);
	}

}