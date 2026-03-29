package l6_hibernate;

import jakarta.persistence.EntityManager;
import l5_dao.dto.Person;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoHibernateImpl implements PersonDao2 {

    @Override
    public List<Person> findPersonsOlderThan(int age) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Person p WHERE p.age > :age ORDER BY p.dateTimeCreate",
                            Person.class)
                    .setParameter("age", age)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Person save(Person person) throws SQLException {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person;
    }

    @Override
    public Person get(Serializable id) throws SQLException {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Person.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean update(Person person) throws SQLException {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean delete(Serializable id) throws SQLException {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Person.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
}