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
    @JoinColumn(name = "elementi_catalogo")
    private ElementiCatalogo elementoPrestato;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inizio_prestito")
    private Date dataInizioPrestito;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_restituzione_prevista")
    private Date dataRestituzionePrevista;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_restituzione_effettiva")
    private Date dataRestituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, ElementiCatalogo elementoPrestato, Date dataInizioPrestito, Date dataRestituzionePrevista, Date dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementiCatalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementiCatalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista + ", \n"+
                "utente=" + utente + ", \n" +
                "elementoPrestato=" + elementoPrestato +
                '}';
    }
}
