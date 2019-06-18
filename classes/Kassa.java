import java.util.Iterator;

public class Kassa {

    private int aantalverkocht;
    private double totaleopbrengst;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        aantalverkocht = 0;
        totaleopbrengst = 0;
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
        if (bezoeker.getBetaalwijze().betaal(klant.getTotalePrijs())) {
        if (bezoeker instanceof Docent || bezoeker instanceof KantineMedewerker){aantalverkocht += klant.getAantalArtikelen();
            if (((KortingskaartHouder) bezoeker).heeftMaximum() && (klant.getTotalePrijs() * 0.25) >= 1){totaleopbrengst += (klant.getTotalePrijs() - 1);}
            else if(((KortingskaartHouder) bezoeker).heeftMaximum()){totaleopbrengst += (klant.getTotalePrijs() * 0.75); aantalverkocht += klant.getAantalArtikelen(); bezoeker.getBetaalwijze().betaal((klant.getTotalePrijs() * 0.75));}
            else {totaleopbrengst += (klant.getTotalePrijs()*0.65); aantalverkocht += klant.getAantalArtikelen(); bezoeker.getBetaalwijze().betaal((klant.getTotalePrijs() * 0.65));}}
        aantalverkocht += klant.getAantalArtikelen();
        totaleopbrengst += klant.getTotalePrijs();
        klant.getKlant().getBetaalwijze().betaal(klant.getTotalePrijs());
    }
        else{System.out.println("Een klant heeft de betaling niet kunnen voltooien.");}
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