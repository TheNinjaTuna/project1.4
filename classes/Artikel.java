class Artikel
{
    private String naam;
    private double prijs;

    public Artikel() {
       naam = "nonameyet";
    }

    public Artikel(String naamI, double prijsI) {
        naam = naamI;
        prijs = prijsI;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Artikel{" +
                "naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }


    /// Getters en setters van naam
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /// Getters en setters van prijs
    public double getPrijs() {
        return prijs;
    }
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

}
