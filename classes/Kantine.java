import javax.persistence.EntityManager;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;

    private EntityManager manager;

    /**
     * Constructor
     */
    public Kantine(EntityManager manage) {
        manager = manage;
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij, manager);

    }


    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
           kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    public KassaRij getKassarij() {
        return kassarij;
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
       //System.out.println("De kassa is gereset!");
    }

    public KantineAanbod getKantineaanbod() {
        return kantineaanbod;
    }

    public void setKantineaanbod(KantineAanbod kantineaanbod) {
        this.kantineaanbod = kantineaanbod;
    }
}