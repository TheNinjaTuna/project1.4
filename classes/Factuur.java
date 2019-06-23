import net.bytebuddy.asm.Advice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.io.Serializable;
@Entity
@Table(name = "factuur")

public class Factuur implements Serializable{


@Id
@Column(name = "id", unique = true)
    private long id;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "korting", nullable = false)
    private double korting;

    @Column(name = "totaal", nullable = false)
    private double totaal;


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


    }

    public double getKorting() {
        return korting;
    }

    public double getTotaal() {
        return totaal;
    }

    @Override
    public String toString() {
        return "FACTUUR: " +
                //"id=" + id +
                "Datum:" + datum +
                ", Totaalprijs: " + totaal +
                ", Ontvangen korting: " + korting +
                ", Totaal te betalen: " + (totaal-korting) +
                '}';
    }
}
