package entities;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private ElementiCatalogo elementoPrestato;
    @Temporal(TemporalType.DATE)
    private Date dataInizioPrestito;
    @Temporal(TemporalType.DATE)
    private Date dataRestituzionePrevista;
    @Temporal(TemporalType.DATE)
    private Date dataRestituzioneEffettiva;

    // Costruttore, getter e setter
}
