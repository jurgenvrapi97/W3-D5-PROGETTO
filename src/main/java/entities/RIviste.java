package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "riviste")
public class RIviste extends ElementiCatalogo {
    @Column(name = "periodicità")
    private Periodicità periodicità;
    public RIviste(){}
    public RIviste(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "RIviste{" +
                "periodicità=" + periodicità +
                "} " + super.toString();
    }
}
