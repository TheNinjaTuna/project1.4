import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {
    private LinkedList<Dienblad> klanten;

    /**
     * Constructor
     */
    public KassaRij() {
        klanten = new LinkedList<Dienblad>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        this.klanten.add(klant);

    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        Dienblad eersteKlant = null;
        if (this.klanten.size() >0) {
            eersteKlant = this.klanten.get(0);
            this.klanten.remove(0);
            return eersteKlant;

        }
        return eersteKlant;

    }
    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return
                !this.klanten.isEmpty();
    }

}