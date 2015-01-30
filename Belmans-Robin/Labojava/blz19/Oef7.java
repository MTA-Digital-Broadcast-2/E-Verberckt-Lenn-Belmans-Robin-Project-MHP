import java.lang.*;

public class Oef7
{
	public static void main(String args[])
	{
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		int b[] = new int[8];
		int highestNumber = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length; j++)
			{
				if(a[j] > a[highestNumber])
				{
					highestNumber = j;
				}	
			}
			b[i] = a[highestNumber];
			a[highestNumber] = 0;
			highestNumber = 0;	
		}

		for (int k=0; k < b.length; k++)
		{
			System.out.println(b[k]);
		}
	}
}