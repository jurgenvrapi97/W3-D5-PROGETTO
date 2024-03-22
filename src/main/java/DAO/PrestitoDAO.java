package DAO;

import Exeptions.ExeptionNotFind;
import entities.Prestito;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TemporalType;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;


    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void savePrestito(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito salvato");
    }


    public List<Prestito> findPrestitiByNumeroTessera(String numeroTessera) throws ExeptionNotFind {

        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        List<Prestito> prestiti = query.getResultList();

        if (prestiti.isEmpty()) {
            throw new ExeptionNotFind("Nessun prestito trovato per l'utente con numero di tessera " + numeroTessera);
        }
        return prestiti;
    }



    public List<Prestito> findPrestitiScaduti() throws ExeptionNotFind {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("oggi", new Date(), TemporalType.DATE);
        List<Prestito> prestiti = query.getResultList();
        if (prestiti.isEmpty()){
            throw new ExeptionNotFind("non ci prestiti scaduti");
        }

        return  prestiti;
    }


}
