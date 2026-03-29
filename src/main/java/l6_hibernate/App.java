package l6_hibernate;

import jakarta.persistence.EntityManagerFactory;
import l5_dao.dto.Person;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        PersonDaoHibernateImpl dao = new PersonDaoHibernateImpl();

        Person person = Person.builder()
                .age(25)
                .salary(6578.95)
                .passport("MP4768721")
                .address("Minsk, Lenina 27/1")
                .dateOfBirthday(LocalDate.of(2001, 5, 8))
                .dateTimeCreate(LocalDateTime.now())
                .timeToLunch(LocalTime.of(12, 0))
                .letter("Random letter")
                .build();

        dao.save(person);

        Person personFromDb = dao.get(person.getId());
        System.out.println(personFromDb);

        personFromDb.setAge(30);
        personFromDb.setLetter("UPDATED LETTER");
        dao.update(personFromDb);

        dao.delete(personFromDb.getId());

        List<Person> persons = dao.findPersonsOlderThan(21);
        System.out.println(persons);
    }
}