public class Main {

    private static KantineSimulatie sim;

    public static void main(String[] args) {

        Administratie.testor1();
        Administratie.testor2();
        Administratie.testor3();
        sim = new KantineSimulatie();

        sim.simuleer(365);

}}
