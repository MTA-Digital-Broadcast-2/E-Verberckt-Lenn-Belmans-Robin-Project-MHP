import java.lang.*;

public class Main
{
    	public static void main(String args[])
	{
            	Werknemer herman = new Werknemer("Herman", "Hermans", 1, 1000);
            	Werknemer robin = new Werknemer("Robin", "Belmans", 2, 750);
            	Werknemer alex = new Werknemer("Alex", "Verslegers", 3, 500);
            	Werknemer jey = new Werknemer("Jey", "Maestro", 4, 250);

            	System.out.println("Voornaam: " + herman.voornaam + "\n" + "Achternaam: " + herman.achternaam + " \n" + "werknemernummer: " + herman.werknemerNummer + "\n" + "Salaris: " + herman.getSalaris() + " \n\n");

            	System.out.println("Voornaam: " + robin.voornaam + "\n" + "Achternaam: " + robin.achternaam + " \n" + "werknemernummer: " + robin.werknemerNummer + "\n" + "Salaris: " + robin.getSalaris() + " \n\n");

            	System.out.println("Voornaam: " + alex.voornaam + "\n" + "Achternaam: " + alex.achternaam + " \n" + "werknemernummer: " + alex.werknemerNummer + "\n" + "Salaris: " + alex.getSalaris() + " \n\n");

            	System.out.println("Voornaam: " + jey.voornaam + "\n" + "Achternaam: " + jey.achternaam + " \n" + "werknemernummer: " + jey.werknemerNummer + "\n" + "Salaris: " + jey.getSalaris() + " \n\n");

		herman.salarisVerhogen(10);
		robin.salarisVerhogen(10);

		System.out.println("Nieuw salaris van " + herman.voornaam + " " + herman.achternaam + " = " + herman.getSalaris() + "\n\n");
		System.out.println("Nieuw salaris van " + robin.voornaam + " " + robin.achternaam + " = " + robin.getSalaris() + "\n\n");

		PartTimeWerknemer mokkie = new PartTimeWerknemer("Erika", "White", 5, 125, 20);
		PartTimeWerknemer ezzy = new PartTimeWerknemer("Ezra", "Williams", 6, 75, 40);

		System.out.println("Voornaam: " + mokkie.voornaam + "\n" + "Achternaam: " + mokkie.achternaam + " \n" + "werknemernummer: " + mokkie.werknemerNummer + "\n" + "Salaris: " + mokkie.getSalaris() + "\n" + "Uren Gewerkt: " + mokkie.urenGewerkt + "\n\n");

		System.out.println("Voornaam: " + ezzy.voornaam + "\n" + "Achternaam: " + ezzy.achternaam + " \n" + "werknemernummer: " + ezzy.werknemerNummer + "\n" + "Salaris: " + ezzy.getSalaris() + "\n" + "Uren Gewerkt: " + ezzy.urenGewerkt +"\n\n");
    	}
}