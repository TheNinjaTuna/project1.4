import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;


@Entity
@Table(name = "factuur")

public class Factuur implements Serializable{


@Id @GeneratedValue
@Column(name = "id", unique = true)
    private long id;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "korting", nullable = false)
    private double korting;

    @Column(name = "totaal", nullable = false)
    private double totaal;

    private ArrayList<FactuurRegel> regels;

    String uniqueID = UUID.randomUUID().toString();


    public Factuur(){
        totaal = 0;
        korting = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum){
        this();
        this.datum = datum;

        verwerkBestelling(klant);

    }

    public void verwerkBestelling(Dienblad klant){
        Persoon persoon = klant.getKlant();

        double kortingberekend = 0;
        double totaalprijs = klant.getTotalePrijs();

        if (persoon instanceof Docent){if (totaalprijs*0.75 >= 1){kortingberekend = 1.00;} else {kortingberekend = totaalprijs*0.75;}}
        else if (persoon instanceof KantineMedewerker){kortingberekend = totaalprijs*0.65;}


        totaal = totaalprijs;
        korting = kortingberekend;

        for (Artikel a : klant.getArtikelen()) {FactuurRegel regel = new FactuurRegel(this, a );};




    }

    public double getKorting() {
        return korting;
    }

    public double getTotaal() {
        return totaal;
    }

    @Override
    public String toString() {
     String bon = "FACTUUR:";
     System.out.println("Totaalprijs: " + getTotaal());
        System.out.println("Toegepaste korting: " + getKorting());
        System.out.println("Totaal te betalen: " + (totaal-korting));
        System.out.println(" ");
        System.out.println("Gekochte artikelen: ");
        for (FactuurRegel r : regels) {System.out.println("- " + r.getArtikel().getNaam());}

     return bon;
    }
}
