import java.lang.*;

public class Oef5
{
	public static void main(String args[])
	{
		System.out.println("DIT ZIJN DE PRIEMGETALLEN OP EEN RIJTJE:\n");

		boolean notPrime = false;

		for (int i = 3; i < 100; i++)
		{
			
			notPrime = false;			

			for (int divider = 2; divider < 10 && !notPrime; divider++)
			{
				if (i != divider)
				{
					if (i % divider == 0)
					{
				   		notPrime = true;
					}
				}
			}

			if (!notPrime)
			{
				System.out.println(i);
			}
		}			
			
	}

}