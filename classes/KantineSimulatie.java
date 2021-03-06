//2
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class KantineSimulatie {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();


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
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;


    //administratievars
    private double[] omzetA;
    private int[] aantalpersonen;
    private int[] aantalartikelen;


    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine(manager);
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
        for (int i = 0; i < lengte; i++) {
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

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    public void runVoorbeeld() { manager = ENTITY_MANAGER_FACTORY.createEntityManager();  manager.close(); ENTITY_MANAGER_FACTORY.close(); }


    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
       // runVoorbeeld();
        // for lus voor dagen
        omzetA = new double[dagen];
        aantalartikelen = new int[dagen];
        aantalpersonen = new int[dagen];
        for (int i = 0; i < dagen; i++) {
        int aantalPersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
        int aantalstudent = 0;
        int aantaldocent = 0;
        int aantalmedw = 0;
            for (int j = 0; j < aantalPersonen; j++) {
                int r = random.nextInt(100);
                // maak per persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt

                if (r < 89) {
                    aantalstudent++;
                    Student genStudent = new Student();
                    Dienblad genDienblad = new Dienblad();
                    genDienblad.setKlant(genStudent);
                    int aantalartikelen = getRandomValue(1, 3);

                    // genereer de "artikelnummers", dit zijn indexen
                    // van de artikelnamen
                    int[] tepakken = getRandomArray(
                            aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                    // vind de artikelnamen op basis van
                    // de indexen hierboven
                    String[] artikelen = geefArtikelNamen(tepakken);

                    // loop de kantine binnen, pak de gewenste
                    // artikelen, sluit aan

                    for (String str : artikelen) {
                        // System.out.println("Er is: " + str + " gepakt.");
                        genDienblad.voegToe(kantineaanbod.getArtikel(str));
                        // System.out.println(genDienblad.toString());
                        //  System.out.println(kantineaanbod.getArtikel(str));
                    }
                    kantine.getKassarij().sluitAchteraan(genDienblad);
                }
                else if (r < 99) {
                    aantaldocent++;
                    Docent genDocent = new Docent();
                    Dienblad genDienblad = new Dienblad();

                    genDienblad.setKlant(genDocent);

                    int aantalartikelen = getRandomValue(1, 3);

                    // genereer de "artikelnummers", dit zijn indexen
                    // van de artikelnamen
                    int[] tepakken = getRandomArray(
                            aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                    // vind de artikelnamen op basis van
                    // de indexen hierboven
                    String[] artikelen = geefArtikelNamen(tepakken);

                    // loop de kantine binnen, pak de gewenste
                    // artikelen, sluit aan

                    for (String str : artikelen) {
                        // System.out.println("Er is: " + str + " gepakt.");
                        genDienblad.voegToe(kantineaanbod.getArtikel(str));
                        // System.out.println(genDienblad.toString());
                        //  System.out.println(kantineaanbod.getArtikel(str));
                    }
                    kantine.getKassarij().sluitAchteraan(genDienblad);

                } else {
                    aantalmedw++;
                    KantineMedewerker genMedw = new KantineMedewerker();
                    Dienblad genDienblad = new Dienblad();

                    genDienblad.setKlant(genMedw);


                    int aantalartikelen = getRandomValue(1, 3);

                    // genereer de "artikelnummers", dit zijn indexen
                    // van de artikelnamen
                    int[] tepakken = getRandomArray(
                            aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                    // vind de artikelnamen op basis van
                    // de indexen hierboven
                    String[] artikelen = geefArtikelNamen(tepakken);

                    // loop de kantine binnen, pak de gewenste
                    // artikelen, sluit aan

                    for (String str : artikelen) {
                        // System.out.println("Er is: " + str + " gepakt.");
                        genDienblad.voegToe(kantineaanbod.getArtikel(str));
                        // System.out.println(genDienblad.toString());
                        //  System.out.println(kantineaanbod.getArtikel(str));
                    }
                    kantine.getKassarij().sluitAchteraan(genDienblad);
                }


            }


            kantine.verwerkRijVoorKassa();

            // verwerk rij voor de kassa

            //System.out.println((kantine.getKassarij().eerstePersoonInRij().toString()));
            // System.out.println(kantineaanbod.toString());


            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen

            aantalpersonen[i] = aantalPersonen;
            aantalartikelen[i] = kantine.getKassa().aantalArtikelen();
            omzetA[i] = kantine.getKassa().hoeveelheidGeldInKassa();


            System.out.println("--- Het is vandaag dag: " + (i + 1) + " ---");
            System.out.println("Hoeveelheid geld in kassa: €" + kantine.getKassa().hoeveelheidGeldInKassa() + ".");
            System.out.println("Aantal artikellen verkocht: " + kantine.getKassa().aantalArtikelen() + ".");
            System.out.println("Aantalbezoekers vandaag: " + aantalPersonen + ".");
            System.out.println(" ");
            System.out.println("-Aantal bezoekers per categorie-");
            System.out.println("Aantal studenten vandaag: " + aantalstudent);
            System.out.println("Aantal docenten vandaag: " + aantaldocent);
            System.out.println("Aantal kantine-medewerkers vandaag: " + aantalmedw);
            System.out.println(" ");
            System.out.println("-Statistieken tot nu toe-");
            System.out.println("Gemmidelde omzet tot nu toe: €" + Administratie.berekenGemiddeldeOmzet(omzetA));
            System.out.println("Gemiddeld aantal personen tot nu toe: " + Administratie.berekenGemiddeldAantal(aantalpersonen));
            System.out.println("Gemmidelde artikelen tot nu toe: " + Administratie.berekenGemiddeldAantal(aantalartikelen));
            System.out.println(" ");
            System.out.println("-Opgrengsten per Weekdag tot nu toe:-");
            System.out.println("Maandag: €" + Administratie.berekenDagOmzet(omzetA)[0]);
            System.out.println("Dinsdag: €" + Administratie.berekenDagOmzet(omzetA)[1]);
            System.out.println("Woensdag: €" + Administratie.berekenDagOmzet(omzetA)[2]);
            System.out.println("Donderdag: €" + Administratie.berekenDagOmzet(omzetA)[3]);
            System.out.println("Vrijdag: €" + Administratie.berekenDagOmzet(omzetA)[4]);
            System.out.println("Zaterdag: €" + Administratie.berekenDagOmzet(omzetA)[5]);
            System.out.println("Zondag: €" + Administratie.berekenDagOmzet(omzetA)[6]);
            System.out.println("-------------------------------");
            System.out.println(" ");




            // reset de kassa voor de volgende dag

            kantine.resetKassa();


        }

        Session session = manager.unwrap(Session.class);
        List<Double> nummer = session.createQuery("SELECT SUM(f.korting) FROM Factuur f").getResultList();
        Double totalekorting = nummer.get(0);

        List<Double> nummer2 = session.createQuery("SELECT SUM(f.totaal - f.korting) FROM Factuur f").getResultList();
        Double totaleopbrengst = nummer2.get(0);

        List<Double> nummer3 = session.createQuery("SELECT AVG(f.korting) FROM Factuur f").getResultList();
        Double gemiddeldekorting = nummer3.get(0);

        List<Double> nummer4 = session.createQuery("SELECT AVG(f.totaal - f.korting) FROM Factuur f").getResultList();
        Double gemiddeldeomzet = nummer4.get(0);

        List<Double> nummer5 = session.createQuery("SELECT f.totaal FROM Factuur f ORDER BY f.totaal DESC").setMaxResults(3).getResultList();
        Double top1 = nummer5.get(0);
        Double top2 = nummer5.get(1);
        Double top3 = nummer5.get(2);



        System.out.println("SIMULATIE OVER:");
        System.out.println("Totale korting toegepast: €" + totalekorting);
        System.out.println("Totale opbrengst: €" + totaleopbrengst);
        System.out.println(" ");
        System.out.println("Gemiddelde korting: €" + gemiddeldekorting);
        System.out.println("Gemiddelde omzet: €" + gemiddeldeomzet);
        System.out.println(" ");
        System.out.println("TOP 3 Hoogste facturen: ");
        System.out.println("1: €" + top1);
        System.out.println("2: €" + top2);
        System.out.println("3: €" + top3);


        ENTITY_MANAGER_FACTORY.close();
    }
}

