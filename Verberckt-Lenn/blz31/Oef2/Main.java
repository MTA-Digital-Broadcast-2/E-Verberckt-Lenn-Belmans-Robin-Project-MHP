package Oef2;
public class Main
{
public static void main(String [] args)
	{
	//oef 1
	Werknemer herman=new Werknemer("Herman", "Hermans", 1, 1000.0f);
	Werknemer bert=new Werknemer("Bert", "Blokker", 2, 100.0f);
	Werknemer werker=new Werknemer("Werker", "Werkmans", 3, 2000.0f);
	Werknemer koen=new Werknemer("Koen", "Soontjens", 4, 3000.0f);


	//oef 2
	herman.salarisVerhogen(10);
	bert.salarisVerhogen(10);

	System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
	System.out.println(bert.voornaam + " verdient " + bert.getSalaris());
	System.out.println(werker.voornaam + " verdient " + werker.getSalaris());
	System.out.println(koen.voornaam + " verdient " + koen.getSalaris());
	}
}