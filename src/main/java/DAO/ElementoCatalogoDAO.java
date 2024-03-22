package DAO;

import entities.ElementiCatalogo;
import entities.Libri;
import entities.RIviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class ElementoCatalogoDAO {
    private final EntityManager em;


    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveElementoCatalogo(ElementiCatalogo elementiCatalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (elementiCatalogo instanceof Libri) {

            em.persist((Libri) elementiCatalogo);
        } else if (elementiCatalogo instanceof RIviste) {

            em.persist((RIviste) elementiCatalogo);
        }
        transaction.commit();
        System.out.println("Elemento catalogo salvato");
    }

    public void deleteElementoCatalogo(String codiceISBN) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        ElementiCatalogo elementiCatalogo = em.find(ElementiCatalogo.class, codiceISBN);
        if (elementiCatalogo != null) {
            em.remove(elementiCatalogo);
            System.out.println("Elemento catalogo eliminato");
        } else {
            System.out.println("Nessun elemento catalogo trovato con il codice ISBN fornito");
        }
        transaction.commit();
    }

}
