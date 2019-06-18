public class Docent extends Persoon implements KortingskaartHouder {

    private String vierLetterAfkorting;
    private String afdeling;

    public Docent() {
        super();
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.25;
    }

    @Override
    public boolean heeftMaximum() {
        return true;
    }

    @Override
    public double geefMaximum() {
        return 1;
    }

    public Docent(String burgerservicenummer, String voornaam, String achternaam, Datum geboortedatum, String geslacht, String vierLetterAfkorting, String afdeling) {
        super(burgerservicenummer, voornaam, achternaam, geboortedatum, geslacht);
        this.vierLetterAfkorting = vierLetterAfkorting;
        this.afdeling = afdeling;
    }

    public Docent(String vierLetterAfkorting, String afdeling) {
        super();
        this.vierLetterAfkorting = vierLetterAfkorting;
        this.afdeling = afdeling;
    }

    public String getVierLetterAfkorting() {
        return vierLetterAfkorting;
    }

    public void setVierLetterAfkorting(String vierLetterAfkorting) {
        this.vierLetterAfkorting = vierLetterAfkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}
