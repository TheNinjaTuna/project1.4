public class KantineMedewerker extends Persoon {

    private int medewerkersNummer;
    private boolean magAchterKassa;


    public KantineMedewerker() {
        super();
    }

    public KantineMedewerker(String burgerservicenummer, String voornaam, String achternaam, Datum geboortedatum, String geslacht, String vierLetterAfkorting, String afdeling) {
        super(burgerservicenummer, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersNummer = medewerkersNummer;
        this.magAchterKassa = magAchterKassa;
    }

    public KantineMedewerker(int medewerkersNummer, boolean magAchterKassa) {
        super();
        this.medewerkersNummer = medewerkersNummer;
        this.magAchterKassa = magAchterKassa;
    }

    public int getMedewerkersNummer() {
        return medewerkersNummer;
    }

    public void setMedewerkersNummer(int medewerkersNummer) {
        this.medewerkersNummer = medewerkersNummer;
    }

    public boolean isMagAchterKassa() {
        return magAchterKassa;
    }

    public void setMagAchterKassa(boolean magAchterKassa) {
        this.magAchterKassa = magAchterKassa;
    }
}