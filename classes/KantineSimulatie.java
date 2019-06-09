//2
import java.util.*;

public class KantineSimulatie {

    // kantine
    private static Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        //System.out.println(artikelnamen.toString());
        //System.out.println(artikelprijzen.toString());
        //System.out.println(hoeveelheden.toString());
        kantineaanbod = new KantineAanbod(
                artikelnamen, artikelprijzen, hoeveelheden);
       System.out.println(kantineaanbod.toString());
        kantine.setKantineaanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = 20 ;

            // laat de personen maar komen...
            for(int j = 0; j < aantalpersonen; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt

                Persoon genPersoon = new Persoon();
                Dienblad genDienblad = new Dienblad();

                genDienblad.setKlant(genPersoon);


                int aantalartikelen = 2;

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan

                for(String str : artikelen){
                  //  System.out.println("Er is: " + str + " gepakt.");
                    genDienblad.voegToe(kantineaanbod.getArtikel("str"));
                }
                kantine.getKassarij().sluitAchteraan(genDienblad);
            }


            // verwerk rij voor de kassa
           // System.out.println((kantine.getKassarij().eerstePersoonInRij().toString()));
           // System.out.println(kantineaanbod.toString());
            kantine.verwerkRijVoorKassa(kantine.getKassarij().eerstePersoonInRij());

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen

            System.out.println("---Het is vandaag dag: " + i + " ---");
            System.out.println("Hoeveelheid geld in kassa: €" + kantine.getKassa().hoeveelheidGeldInKassa() + ".");
            System.out.println("Aantal artikellen verkocht: " + kantine.getKassa().aantalArtikelen() + ".");
            System.out.println("Aantalbezoekers vandaag: " + aantalpersonen + ".");
            System.out.println("---------------------------");


            // reset de kassa voor de volgende dag

            kantine.resetKassa();

        }
    }


}