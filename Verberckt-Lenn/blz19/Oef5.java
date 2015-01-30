import java.lang.*;

public class Oef5{
	public static void main(String args[])
	{
		int i = 0;
		int num = 0;
		
		for(i=1; i<=100;i++)
		{
			int counter = 0;
			for (num=i; num>=1; num--)
			{
				if (i%num==0)
				{
					counter++;
				}
			}
			if (counter==2)
			{
				System.out.println(i);	

			}	
	

		
		
		}
	
	}
}