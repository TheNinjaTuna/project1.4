public class KantineSimulatie {

    private static Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen is het aantal dagan dat hij al draaiende is
     */
    public static void simuleer(int dagen) {
        kantine = new Kantine();
        // herhaal voor elke dag
        for(int i = 0; i >= 0; i ++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for(int j = 0; j < 10 + i; j++){
                kantine.loopPakSluitAan();
            }

            kantine.verwerkRijVoorKassa();

            System.out.println("Vandaag is het: Dag " + i);
            System.out.println("Bedrag in Kassa: " + kantine.getKassa().hoeveelheidGeldInKassa() + " Euro.");
            System.out.println("Aantal verkochte artikelen: " + kantine.getKassa().aantalArtikelen() + ".");

            kantine.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        simuleer(dagen);
    }
}