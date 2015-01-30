package oef10;

public class Faktuur implements Betaalbaar {
    
    public int faktuurNr;
    public float faktuurBedrag;
    
    public Faktuur(int nr, float bedrag) {
        this.faktuurNr = nr;
        this.faktuurBedrag = bedrag;
    }
    
    public void betaal() {
        System.out.println("Betaal het faktuur " + faktuurNr + " voor een bedrag van " + faktuurBedrag + ".");
    }

}
