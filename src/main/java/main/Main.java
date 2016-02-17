package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;
import model.UserDetails;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        UserDetails details = new UserDetails("John", "Doe", "NYC 11");
        User user = new User("uname", "pass", "mail", details);
        em.merge(user);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
