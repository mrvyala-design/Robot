package l4_jbdc;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle("database");
        String url = rb.getString("url");
        String username = rb.getString("user");
        String password = rb.getString("password");

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            createPersons(conn);
            selectPersons(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void selectPersons(Connection conn) throws SQLException {
        String sql = "SELECT * FROM people.person WHERE person.age > 21 ORDER BY person.dateTimeCreate";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                String tableName = metaData.getTableName(1);
                System.out.println("Table Name: " + tableName);
                System.out.println("======================================");

                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        String columnTypeName = metaData.getColumnTypeName(i);
                        Object columnValue = rs.getObject(columnName);

                        System.out.println(columnName + "(" + columnTypeName + "): " + columnValue);
                    }
                    System.out.println("--------------------------------");
                }
            }
        }
    }

    private static void createPersons(Connection conn) throws SQLException {
        String sql = "INSERT INTO people.person (age, salary, passport, address, dateOfBirthday, dateTimeCreate, " +
                "timeToLunch, letter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, 32);
            ps.setDouble(2, 5200.50);
            ps.setString(3, "AB1234567");
            ps.setString(4, "Minsk, Nezavisimosti 12/5");
            ps.setDate(5, Date.valueOf(LocalDate.of(1994, 4, 17)));
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.of(2025, 9, 14,
                    9, 15)));
            ps.setTime(7, Time.valueOf(LocalTime.of(12, 15)));
            ps.setString(8, "Random letter 6");
            ps.executeUpdate();

            ps.setInt(1, 20);
            ps.setDouble(2, 1750.75);
            ps.setString(3, "CD7654321");
            ps.setString(4, "Grodno, Sovetskaya 8/1");
            ps.setDate(5, Date.valueOf(LocalDate.of(2006, 11, 23)));
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.of(2025, 8, 2,
                    11, 45)));
            ps.setTime(7, Time.valueOf(LocalTime.of(13, 10)));
            ps.setString(8, "Random letter 7");
            ps.executeUpdate();

            ps.setInt(1, 27);
            ps.setDouble(2, 4100.00);
            ps.setString(3, "EF9081726");
            ps.setString(4, "Brest, Moskovskaya 44/3");
            ps.setDate(5, Date.valueOf(LocalDate.of(1999, 1, 30)));
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.of(2025, 10, 20,
                    14, 5)));
            ps.setTime(7, Time.valueOf(LocalTime.of(12, 50)));
            ps.setString(8, "Random letter 8");
            ps.executeUpdate();

            ps.setInt(1, 18);
            ps.setDouble(2, 1500.00);
            ps.setString(3, "GH5647382");
            ps.setString(4, "Vitebsk, Pobedy 19/6");
            ps.setDate(5, Date.valueOf(LocalDate.of(2008, 3, 12)));
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.of(2025, 7, 18,
                    16, 20)));
            ps.setTime(7, Time.valueOf(LocalTime.of(13, 25)));
            ps.setString(8, "Random letter 9");
            ps.executeUpdate();

            ps.setInt(1, 24);
            ps.setDouble(2, 2950.30);
            ps.setString(3, "IJ1122334");
            ps.setString(4, "Mogilev, Leninskaya 27/4");
            ps.setDate(5, Date.valueOf(LocalDate.of(2002, 12, 5)));
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.of(2025, 11, 25,
                    12, 40)));
            ps.setTime(7, Time.valueOf(LocalTime.of(12, 40)));
            ps.setString(8, "Random letter 10");
            ps.executeUpdate();
        }
    }
}
