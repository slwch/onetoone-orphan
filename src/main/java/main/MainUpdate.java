package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class MainUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1L);
        user.setDetails(null);
        
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
