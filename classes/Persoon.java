class Persoon {
   private String burgerservicenummer;
   private String voornaam;
   private String achternaam;
   private Datum geboortedatum;
   private char geslacht;

    public Persoon() {
        this.geslacht = 'O';
        this.geboortedatum = null;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Persoon{" +
                "burgerservicenummer=" + burgerservicenummer +
                ", voornaam=" + voornaam +
                ", achternaam=" + achternaam +
                ", geboortedatum=" + geboortedatum +
                ", geslacht=" + geslacht +
                '}';
    }

    public Persoon(String burgerservicenummer, String voornaam, String achternaam, Datum geboortedatum, String ges) {
        this.burgerservicenummer = burgerservicenummer;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setGeslacht(ges);
    }



    public void setBurgerservicenummer(String burgerservicenummer) {
        this.burgerservicenummer = burgerservicenummer;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(String ges) {
        boolean isSet = false;
        if (ges == "Man"){this.geslacht = 'M'; isSet = true;}
        if (ges == "Vrouw"){this.geslacht = 'V'; isSet = true;}
        if (!isSet){this.geslacht = 'O'; System.out.println("Setten van geslacht mislukt, geef op 'Man' of 'Vrouw'.");}

    };


//Getters van instantievariabellen
    public String getBurgerservicenummer() {
        return burgerservicenummer;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    //getDatumAsString is voor week 1 nog niet relevant!

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString;
    }

    public String getGeslacht() {
        if (geslacht == 'M') {return "Man";}
        if (geslacht == 'V') {return "Vrouw";};
        return "Onbekend";
    }




}