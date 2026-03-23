
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilTest {

    private static final EntityManagerFactory emf =
            new Configuration()
                    .configure("hibernate-test.cfg.xml")
                    .buildSessionFactory();

    static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}