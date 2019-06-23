import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "factuur")

public class FactuurRegel implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "factuur", nullable = false)
    private Factuur factuur;

    @Column(name = "artikel", nullable = false)
    private Artikel artikel;

    public FactuurRegel() {
    }

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    /**
     *  * @return een printbare factuurregel
     *
     */
    public String toString() {
        // method body omitted
    }
}