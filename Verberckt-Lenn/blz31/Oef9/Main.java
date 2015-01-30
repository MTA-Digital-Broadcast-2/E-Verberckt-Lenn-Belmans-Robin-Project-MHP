package oef9;

public class Main {

    public static void main(String[] args) {
        StudentWerknemer sw1 = new StudentWerknemer("Hendrik", "Winckelmans", 1, 1800, 20);
        Werknemer w1 = new Werknemer("Pol", "Kanselier", 2, 1900);
        PartTimeWerknemer ptw = new PartTimeWerknemer("Jean", "Duchateaux", 121, 700, 20);
        
        sw1.betaal();
        w1.betaal();
        ptw.betaal();
    }

}
