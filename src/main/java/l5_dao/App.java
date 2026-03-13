package l5_dao;

import l5_dao.dao.PersonDao;
import l5_dao.dao.PersonDaoImpl;
import l5_dao.dto.Person;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) throws SQLException {

        PersonDao personDao = new PersonDaoImpl();

        Person person = new Person();
        person.setAge(30);
        person.setSalary(2000);
        person.setPassport("MP3058094");
        person.setAddress("Minsk, Lenina 16/2");
        person.setDateOfBirthday(LocalDate.of(1990, 5, 10));
        person.setDateTimeCreate(LocalDateTime.now());
        person.setTimeToLunch(LocalTime.of(13, 0));
        person.setLetter("Random letter 11");
        personDao.save(person);

        Person personFromDatabase = personDao.get(1);
        System.out.println(personFromDatabase.toString());

        personFromDatabase.setSalary(3850);
        personDao.update(personFromDatabase);
        System.out.println(personFromDatabase.toString());

        personDao.delete(11);
    }
}