class Persoon {
   private string burgerservicenummer;
   private string voornaam;
   private string achternaam;
   private Date geboortedatum;
   private char geslacht;

    public Persoon() {
        this.geslacht = null;
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

    public Persoon(string burgerservicenummer, string voornaam, string achternaam, date geboortedatum, char geslacht) {
        this.burgerservicenummer = burgerservicenummer;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setGeslacht(this.geslacht);
    }



    public void setBurgerservicenummer(string burgerservicenummer) {
        this.burgerservicenummer = burgerservicenummer;
    }

    public void setVoornaam(string voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(string achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(char geslacht) {
        if (geslacht == "Man"){this.geslacht ==  "Man"};
        if (geslacht == "Vrouw")(this.geslacht == "Vrouw"};
        this.geslacht == null;
        System.out.println("Setten van geslacht is niet gelukt; vul in 'Man' of 'Vrouw'");
    }


//Getters van instantievariabellen
    public string getBurgerservicenummer() {
        return burgerservicenummer;
    }

    public string getVoornaam() {
        return voornaam;
    }

    public string getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString;
    }

    public String getGeslacht() {
        if (geslacht == "Man") {return "Man"};
        if (geslacht == "Vrouw") {return "Vrouw"};
        return "Onbekend";
    }




}