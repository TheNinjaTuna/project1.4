

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "factuurregel")
public class FactuurRegel implements Serializable {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private Factuur factuur;

    @Embedded
    private Artikel artikel;

    public FactuurRegel() {
    }

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    public Artikel getArtikel() {
        return artikel;
    }
}

