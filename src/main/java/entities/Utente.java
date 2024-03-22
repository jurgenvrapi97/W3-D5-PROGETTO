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

   public Utente(){}

    public Utente(String numeroTessera, String cognome, Date dataDiNascita) {
        this.numeroTessera = numeroTessera;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera='" + numeroTessera + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}