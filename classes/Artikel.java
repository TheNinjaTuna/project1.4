class Artikel
{
    private String naam;
    private float prijs;

    public Artikel() {

    }

    public Artikel(String naam, float prijs) {

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
    public float getPrijs() {
        return prijs;
    }
    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

}
