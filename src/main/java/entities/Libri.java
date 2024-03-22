package entities;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")
public class Libri extends ElementiCatalogo{
    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    private String Genere;
}
