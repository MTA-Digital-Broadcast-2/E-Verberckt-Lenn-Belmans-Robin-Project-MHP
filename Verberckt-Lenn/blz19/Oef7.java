import java.lang.*;
import java.util.Arrays	;

public class Oef7{
	public static void main(String args[])
	{
		int a[] = {12,34,56,78,123,234,99,88};
		int b[] = new int [8];
		int grootste=0;
		int plaats = -1;
		int indexb = 0;
		while (indexb<a.length)
		{
		for (int i=0; i<a.length; i++) 
		{
			if (a[i] > grootste)
		{
		plaats = i;
		grootste = a[i];
		a[i]=0;
		}
		}
		b[indexb] = grootste;
		indexb ++;
		}

		System.out.println(Arrays.toString(b));
		
	}
	
}
