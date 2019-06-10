public class Student extends Persoon {

    private int studentNummer;
    private String studieRichting;

    public Student(String burgerservicenummer, String voornaam, String achternaam, Datum geboortedatum, String geslacht, int studentNummer, String studieRichting) {
        super(burgerservicenummer, voornaam, achternaam, geboortedatum, geslacht);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    public Student(int studentNummer, String studieRichting) {
        super();
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getStudieRichting() {
        return studieRichting;
    }

    public void setStudieRichting(String studieRichting) {
        this.studieRichting = studieRichting;
    }
}
