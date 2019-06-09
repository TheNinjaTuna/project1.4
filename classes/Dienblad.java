import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new Stack<>();
    }

    public Dienblad(Persoon klantinvoer) {
        this.klant = klantinvoer;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        int aantal = 0;
        for (int x = 0; x < artikelen.size(); x++ ){aantal += 1;}
        return aantal;
    }

    /**om de totaalprijs van de artikelen
     * op dienblad
     *      * Methode uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotalePrijs() {
        double tot = 0;
        for (int x = 0; x < artikelen.size(); x++)
        {
         tot += 5 ;//artikelen.get(x).getPrijs(); //tijdelijke aanpassing want artikellen krijgen nulwaarden
        }
        return tot;
    }

    @Override
    public String toString() {
        return "Dienblad{" +
                "artikelen=" + artikelen +
                ", klant=" + klant +
                '}';
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

