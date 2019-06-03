public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan() {
        Persoon person = new Persoon();
        Dienblad dienblad = new Dienblad();
        Artikel artikel1 = new Artikel();
        Artikel artikel2 = new Artikel();

        dienblad.setKlant(person);
        dienblad.voegToe(artikel1);
        dienblad.voegToe(artikel2);

        kassarij.sluitAchteraan(dienblad);

    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
            kassarij.eerstePersoonInRij();
        }
    }


    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen en "leegt" de inhoud van de kassa.
     */
    public void resetKassa() {
       kassa.resetKassa();
       System.out.println("De kassa is gereset!");
    }

    public KantineAanbod getKantineaanbod() {
        return kantineaanbod;
    }

    public void setKantineaanbod(KantineAanbod kantineaanbod) {
        this.kantineaanbod = kantineaanbod;
    }
}