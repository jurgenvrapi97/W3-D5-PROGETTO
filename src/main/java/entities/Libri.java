package entities;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")
public class Libri extends ElementiCatalogo{
    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    private String Genere;

    public Libri(){}

    public Libri(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        Genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", Genere='" + Genere + '\'' +
                "} " + super.toString();
    }
}
