package l6_hibernate;

import l5_dao.dao.DAO;
import l5_dao.dto.Person;

import java.util.List;

public interface PersonDao2 extends DAO<Person> {

    List<Person> findPersonsOlderThan(int age);
}
