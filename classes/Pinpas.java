public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet is het kredietlimiet van de pas.
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     * @param tebetalen is het verschuldigt bedrag.
     */
    public boolean betaal(double tebetalen) {
        if (tebetalen <= kredietlimiet){ return true;} //kredietlimiet -= tebetalen;
        return false;
    }
}
