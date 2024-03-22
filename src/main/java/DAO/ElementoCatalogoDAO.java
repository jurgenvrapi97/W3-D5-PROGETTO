package DAO;

import Exeptions.ExeptionNotFind;
import entities.ElementiCatalogo;
import entities.Libri;
import entities.RIviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;


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

    public ElementiCatalogo findByISBN(String codiceISBN) throws ExeptionNotFind {
        ElementiCatalogo elemento = em.find(ElementiCatalogo.class, codiceISBN);
        if (elemento == null) {
            throw new ExeptionNotFind("Elemento con ISBN " + codiceISBN + " non trovato");
        }
        return elemento;
    }



    public List<ElementiCatalogo> findBYear(int anno) throws ExeptionNotFind {
        TypedQuery<ElementiCatalogo> query = em.createQuery("SELECT e FROM ElementiCatalogo e WHERE e.annoPubblicazione = :annoPubblicazione", ElementiCatalogo.class);
        query.setParameter("annoPubblicazione", anno);
        List<ElementiCatalogo> riusltati = query.getResultList();
        if (riusltati.isEmpty()){
            throw new ExeptionNotFind("nessun elemento trovato per l'anno "+ anno);
        }
        return riusltati;
    }


    public List<ElementiCatalogo> findByAutore(String autore) throws ExeptionNotFind {
        TypedQuery<ElementiCatalogo> query = em.createQuery("SELECT e FROM ElementiCatalogo e WHERE e.autore = :autore", ElementiCatalogo.class);
        query.setParameter("autore", autore);
        List<ElementiCatalogo> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ExeptionNotFind("Nessun elemento trovato per l'autore " + autore);
        }
        return risultati;
    }

    public List<ElementiCatalogo> findByTitolo(String titolo) throws ExeptionNotFind {
        TypedQuery<ElementiCatalogo> query = em.createQuery("SELECT e FROM ElementiCatalogo e WHERE LOWER(e.titolo) LIKE :titolo", ElementiCatalogo.class);
        query.setParameter("titolo", "%" + titolo.toLowerCase() + "%");
        List<ElementiCatalogo> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ExeptionNotFind("Nessun elemento trovato con il titolo " + titolo);
        }
        return risultati;
    }




}
