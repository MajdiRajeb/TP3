package dao;

import model.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class GestionImp implements InterfaceGestionLivre {

    EntityManager em;
    public GestionImp() {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("newPersistanceUnit");
            System.out.println("connected");
            em = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

    }
    @Override
    public List<Livre> GetAllProduits() {
        try {
            Query query = em.createQuery("SELECT l FROM Livre  l");
            List<Livre> Livres = query.getResultList();
            return Livres;
        } catch (Exception e) {
            System.out.println("error in Selection of product ");
            return null;

        }
    }




    @Override
    public Livre GetLivretByID(int idpdt) {
        try {
            return em.find(Livre.class, idpdt);
        } catch (Exception e) {
            System.out.println("no book with this id");
            return null;
        }

    }


    @Override
    public void insert(Livre categorie) {
        try {
            System.out.println("this is" + em);
            em.getTransaction().begin();
            em.persist(categorie);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("action not accomplished !!");
        }

    }

    @Override
    public void delete(int idpdt) {
        em.getTransaction().begin();
        Livre livre = em.find(Livre.class, idpdt);
        System.out.println("the book to delete is "+livre.getTitre());
        em.remove(livre);
        em.getTransaction().commit();

    }

    @Override
    public void update(Livre livre) {
        em.getTransaction().begin();
        Livre livre1= em.find(Livre.class, livre.getId());
        livre1.setTitre(livre.getTitre());
        em.merge(livre1);
        em.getTransaction().commit();
    }


}

