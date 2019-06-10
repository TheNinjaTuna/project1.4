public class Administratie {

    private final static int DAYS_IN_WEEK = 7;

    private Administratie() {
    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        double som = 0;
        double aan = 0;
        for (int get : aantal){
            som += get;
            aan ++;
        }

        return som/aan;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double som = 0;
        double aan = 0;
        for (double get : omzet){
            som += get;
            aan ++;
        }

        return som/omzet.length;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];


        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;

           while(i + (7 * j) < omzet.length) {
                temp[i] += omzet[i + (7 * j)];
                j++;
            }
        }
        return temp;
    }



   //testor voor berekenGemiddeldAantal
    public static void testor1() {
        int[] testarray = new int[]{45, 56, 34, 39, 40, 31};
        System.out.println("Testor 1: moet 40.8333 geven.");
        System.out.println("Uitkomst: " + berekenGemiddeldAantal(testarray));
    }

    //testor voor berekenGemiddeldeOmzet
    public static void testor2() {
        double[] testarray = new double[]{567.70, 498.25, 458.9};
        System.out.println("Testor 2: moet 508.2833 geven.");
        System.out.println("Uitkomst: " +  berekenGemiddeldeOmzet(testarray));
    }

    //testor voor berekenDagOmzet
    public static void testor3() {
        double[] testarray = new double[]{321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35};

        System.out.println("Testor 3: moet "+ (321.35+220.90) +" geven.");
        System.out.println("Uitkomst: " + berekenDagOmzet(testarray)[0] );
    }





}



