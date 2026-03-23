import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.*;
import l5_dao.dto.Person;
import l6_hibernate.PersonDaoHibernateImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class PersonDaoHibernateImplTest {

    private static EntityManagerFactory emf;
    private PersonDaoHibernateImpl dao;

    @BeforeAll
    static void init() {
        emf = HibernateUtilTest.getEntityManager().getEntityManagerFactory();

    }

    @BeforeEach
    void setUp() {
        dao = new PersonDaoHibernateImpl();
        clearDb();
    }

    @AfterAll
    static void close() {
        emf.close();
    }

    @Test
    void saveTest() throws SQLException {
        Person person = createPerson();
        dao.save(person);

        Person fromDb = dao.get(person.getId());

        assertNotNull(fromDb);
    }

    @Test
    void getTest() throws SQLException {
        Person person = createPerson();
        dao.save(person);

        Person fromDb = dao.get(person.getId());

        assertNotNull(fromDb);
        assertEquals(person.getId(), fromDb.getId());
    }

    @Test
    void updateTest() throws SQLException {
        Person person = createPerson();
        dao.save(person);

        person.setAge(50);
        person.setLetter("UPDATED");

        dao.update(person);

        Person updated = dao.get(person.getId());

        assertEquals(50, updated.getAge());
        assertEquals("UPDATED", updated.getLetter());
    }

    @Test
    void deleteTest() throws SQLException {
        Person person = createPerson();
        dao.save(person);

        dao.delete(person.getId());

        Person deleted = dao.get(person.getId());

        assertNull(deleted);
    }

    @Test
    void findPersonsOlderThanTest() throws SQLException {
        dao.save(createPersonWithAge(18));
        dao.save(createPersonWithAge(30));

        List<Person> result = dao.findPersonsOlderThan(21);

        assertTrue(result.get(0).getAge() > 21);
    }

    private Person createPerson() {
        return Person.builder()
                .age(25)
                .salary(1000.00)
                .passport("TEST")
                .address("TEST")
                .dateOfBirthday(LocalDate.of(2000, 1, 1))
                .dateTimeCreate(LocalDateTime.now())
                .timeToLunch(LocalTime.of(12,0))
                .letter("TEST")
                .build();
    }

    private Person createPersonWithAge(int age) {
        Person person = createPerson();
        person.setAge(age);
        return person;
    }

    void clearDb() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Person").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}