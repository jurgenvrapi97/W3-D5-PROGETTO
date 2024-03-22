package org.example;

import DAO.ElementoCatalogoDAO;
import entities.ElementiCatalogo;
import entities.Libri;
import entities.Periodicità;
import entities.RIviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.SystemException;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");

    public static void main(String[] args) throws SystemException {

        EntityManager em = emf.createEntityManager();
        ElementoCatalogoDAO ec = new ElementoCatalogoDAO(em);

        //ggiunta di un libro
//        Libri libro1 = new Libri("1234-2343242-F", "GGG", 1997, 1000, "Peppe","fanatasy");
//        ec.saveElementoCatalogo(libro1);

        //aggiunta di una rivista

//        RIviste rivista = new RIviste("23454-2332423-G","Meteore",2017,100, Periodicità.SEMESTRALE);
//        ec.saveElementoCatalogo(rivista);

       //eliminazione di un elemento catalogo
//        ec.deleteElementoCatalogo("1234-2343242-F");


    }
}
