import java.lang.*;

public class Oef2
{
	public static void main(String args[])
	{
		String dag[] = {"zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"};
		int counter = 0;

		for (int i = 1; i < 29; i++)
		{
			System.out.println(dag[counter] + " " + i + " februari \n");
			counter++;

			if (counter == 6)
			{
				counter = 0;
			}
		}
	}
}


/*

		MET SWITCH



		String dagNaam = null;		

		for (int dag = 1 ; dag < 29; dag++)
		{
			switch(dag)
			{
				case 2:
				case 9:
				case 16:
				case 23:
					dagNaam = "maandag";
					break;

				case 3:
				case 10:
				case 17:
				case 24:
					dagNaam = "dinsdag";
					break;

				case 4:
				case 11:
				case 18:
				case 25:
					dagNaam = "woensdag";
					break;

				case 5:
				case 12:
				case 19:
				case 26:
					dagNaam = "donderdag";
					break;

				case 6:
				case 13:
				case 20:
				case 27:
					dagNaam = "vrijdag";
					break;

				case 7:
				case 14:
				case 21:
				case 28:
					dagNaam = "zaterdag";
					break;

				case 1:
				case 8:
				case 15:
				case 22:
					dagNaam = "zondag";
					break;
			}

		System.out.println(dagNaam + " " + dag + " " + "februari\n");

		}


	}

} */