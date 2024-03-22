package entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    private String numeroTessera;
    private String cognome;
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;

    // Costruttore, getter e setter
}