import java.lang.*;
import java.util.Arrays	;

public class Oef2{

	public static void main(String args[])
	{
		String[] dagnamen= {"zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"};
		int index = 0;
		int dag = 1;
		while (index<7)
		{	
			

		
			while (dag<29)
			{

				System.out.println(dagnamen[index] +" " + dag + " februari 2009 \n");
				index++;
				dag++;
				if (index == 7)
				{
					index = 0;
				}
			}
			
		}			
	}
	
}