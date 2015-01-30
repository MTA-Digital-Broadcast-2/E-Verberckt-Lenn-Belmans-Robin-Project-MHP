import java.lang.*;

public class EersteProg // Constructor and Description: "EersteProg()"
{
   public static void main(String args[]) // Modifier and Type: "static void" Method and Description: "main(java.lang.String[] args)" 
   {
	drukaf(100);
   }

   public static void drukaf(int m) // Modifier and Type: "static void"	Method and Description: "drukaf(int m)"
   {
	int a;
	for (a=0; a<m; a++)
	{
	    System.out.println(a);
	}
   }
}