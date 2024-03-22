package org.example;

import DAO.ElementoCatalogoDAO;
import DAO.PrestitoDAO;
import DAO.UtenteDAO;
import Exeptions.ExeptionNotFind;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.SystemException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");

    public static void main(String[] args) throws SystemException, ExeptionNotFind {

        EntityManager em = emf.createEntityManager();
        ElementoCatalogoDAO ec = new ElementoCatalogoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd= new PrestitoDAO(em);

        LocalDate localDate = LocalDate.of(2024, 3, 14);
        Date data = convertiData(localDate);
        Date dataRestituzione = convertiData(localDate.plusDays(30));

        //aggiunta Utente
        Utente utente1 = new Utente("1278kI","giulio", "verdi", data);
//        ud.saveUtente(utente1);

        //ggiunta di un libro
      Libri libro1 = new Libri("1234-2343242-F", "GGG", 2017, 1000, "Peppe","fanatasy");
//        ec.saveElementoCatalogo(libro1);

        //aggiunta di una rivista

       RIviste rivista = new RIviste("23454-2332423-G","Meteore",2017,100, Periodicità.SEMESTRALE);
//        ec.saveElementoCatalogo(rivista);


        //inserimetno di un prestito
        Prestito prestito1 = new Prestito(utente1,rivista,data,dataRestituzione,null);
//        pd.savePrestito(prestito1);


       //eliminazione di un elemento catalogo
//        ec.deleteElementoCatalogo("1234-2343242-F");

        //ricerca di un elemento del catalogo
        //caso in cui non ci sia
//        try {
//            System.out.println(ec.findByISBN("23454-3-G"));
//       } catch (ExeptionNotFind e){
//
//            System.out.println(e.getMessage());
//        }
        //caso in cui sia presente
//        try {
//            System.out.println(ec.findByISBN("23454-2332423-G"));
//        } catch (ExeptionNotFind e){
//            System.out.println(e.getMessage());
//        }

        //ricerca per anno pubblicazione
//       try{
//            List<ElementiCatalogo> elementiTrovatiAnno = ec.findBYear(2017);
//            elementiTrovati.forEach(System.out::println);
//       }catch (ExeptionNotFind e){
//           System.out.println(e.getMessage());
//       }


        //ricerca per autore
//        try{
//            List<ElementiCatalogo> elementiTrovatiAutore = ec.findByAutore("Peppe");
//            elementiTrovatiAutore.forEach(System.out::println);
//        } catch (ExeptionNotFind e){
//            System.out.println(e.getMessage());
//        }

        //ricerca titolo
//        try {
//            List<ElementiCatalogo> elementiTrovatiTitolo = ec.findByTitolo("met");
//            elementiTrovatiTitolo.forEach(System.out::println);
//        } catch (ExeptionNotFind e){
//            System.out.println(e.getMessage());
//        }


        //ricerca prestiti attivi dato il nuemro di tessera
//        try {
//           List<Prestito> prestiti = pd.findPrestitiByNumeroTessera("1278kI");
//           prestiti.forEach(System.out::println);
//        } catch (ExeptionNotFind e){
//            System.out.println(e.getMessage());
//        }

        //ricerca dei prestiti scaduti

        try {
            List<Prestito> presiti = pd.findPrestitiScaduti();
            presiti.forEach(System.out::println);
        } catch (ExeptionNotFind e){
            System.out.println(e.getMessage());
        }


    }

    public static Date convertiData (LocalDate data){
        return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
