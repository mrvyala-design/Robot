package l6_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myPersistenceUnit");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        entityManagerFactory.close();
    }
}
