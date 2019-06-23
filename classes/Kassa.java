import javax.persistence.EntityManager;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Iterator;

public class Kassa {

    private int aantalverkocht;
    private double totaleopbrengst;

    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager manage) {
        aantalverkocht = 0;
        totaleopbrengst = 0;

        manager = manage;
    }



    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Persoon bezoeker = klant.getKlant();
        Betaalwijze betaalwijze = bezoeker.getBetaalwijze();
        LocalDate datum = LocalDate.now();
        Factuur factuur = new Factuur(klant, datum);

        double korting = factuur.getKorting();
        double totaalprijs = factuur.getTotaal();

        try {betaalwijze.betaal(totaalprijs-korting);
            aantalverkocht += klant.getAantalArtikelen();
            totaleopbrengst += totaalprijs - korting;
        }

        catch (TeWeinigGeldException e){System.out.println("Een klant heeft de betaling gefaald...");}


    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalverkocht;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return totaleopbrengst;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        totaleopbrengst = 0;
        aantalverkocht = 0;
    }
}