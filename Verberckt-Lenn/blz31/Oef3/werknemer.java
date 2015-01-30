package Oef3;
public class Werknemer{
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    public float salaris;

    public Werknemer (String voornaam, String achternaam, int wNummer, float salaris)
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        werknemerNummer = wNummer;
        this.salaris = salaris;
    }
	public void salarisVerhogen(int percentage)
	{
        float verhogingsfactor = (float)percentage/100;
        salaris += salaris * verhogingsfactor;
	}
    public float getSalaris()
	{
        return salaris;
	}
}