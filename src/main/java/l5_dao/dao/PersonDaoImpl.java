package l5_dao.dao;

import l4_jbdc.Connector;
import l5_dao.dto.Person;

import java.io.Serializable;
import java.sql.*;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person save(Person person) throws SQLException {

        String sql = "INSERT INTO people.person (age, salary, passport, address, dateOfBirthday, dateTimeCreate, " +
                "timeToLunch, letter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = Connector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, person.getAge());
            pstmt.setDouble(2, person.getSalary());
            pstmt.setString(3, person.getPassport());
            pstmt.setString(4, person.getAddress());
            pstmt.setDate(5, Date.valueOf(person.getDateOfBirthday()));
            pstmt.setTimestamp(6, Timestamp.valueOf(person.getDateTimeCreate()));
            pstmt.setTime(7, Time.valueOf(person.getTimeToLunch()));
            pstmt.setString(8, person.getLetter());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer primaryKey = rs.getInt(1);
                    person.setId(primaryKey);
                }
            }
            return person;
        }
    }

    @Override
    public Person get(Serializable id) throws SQLException {
        Person person = new Person();
        try (Connection connection = Connector.getConnection(); Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM people.person WHERE id = " + id)) {
                if (rs.next()) {
                    person.setId(rs.getInt("id"));
                    person.setAge(rs.getInt("age"));
                    person.setSalary(rs.getDouble("salary"));
                    person.setPassport(rs.getString("passport"));
                    person.setAddress(rs.getString("address"));
                    person.setDateOfBirthday(rs.getDate("dateOfBirthday").toLocalDate());
                    person.setDateTimeCreate(rs.getTimestamp("dateTimeCreate").toLocalDateTime());
                    person.setTimeToLunch(rs.getTime("timeToLunch").toLocalTime());
                    person.setLetter(rs.getString("letter"));
                }
            }
        }
        return person;
    }

    @Override
    public boolean update(Person person) throws SQLException {

        String sql = "UPDATE people.person SET age = ?, salary = ?, passport = ?, address = ?, dateOfBirthday = ?," +
                " dateTimeCreate = ?, timeToLunch = ?, letter = ? WHERE id = ?";
        try (Connection connection = Connector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, person.getAge());
            pstmt.setDouble(2, person.getSalary());
            pstmt.setString(3, person.getPassport());
            pstmt.setString(4, person.getAddress());
            pstmt.setDate(5, Date.valueOf(person.getDateOfBirthday()));
            pstmt.setTimestamp(6, Timestamp.valueOf(person.getDateTimeCreate()));
            pstmt.setTime(7, Time.valueOf(person.getTimeToLunch()));
            pstmt.setString(8, person.getLetter());
            pstmt.setLong(9, person.getId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    @Override
    public boolean delete(Serializable id) throws SQLException {

        String sql = "DELETE FROM people.person WHERE id = ?";
        try (Connection connection = Connector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, (Integer) id);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}