import java.lang.*;

public class Oef3{
	public static void main(String args[])
	{
		double total = 0.0;
		for (long j=1; j<=10000; j+=4)
		{
			total +=1.0/j-1.0/(j+2);
		}
		

		System.out.println(4*total);
		
	}
	
}
