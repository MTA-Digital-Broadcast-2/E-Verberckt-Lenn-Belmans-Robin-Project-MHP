import java.lang.*;

public class Oef1
{
	public static void main(String args[])
	{
        	int arrayLengte[] = new int[9];
        
        	for (int i=1; i < 10; i++)
        	{
		System.out.println("DIT IS DE MAALTAFEL VAN " + i + "\n");

			for (int a=1; a<=arrayLengte.length; a++)
			{ 
                		System.out.println(i + "x" + a + "="+ i*a + "\n");
			}              
        	}
	}
}