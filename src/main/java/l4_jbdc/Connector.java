package l4_jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {

    public static Connection getConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("database");
        String url = rb.getString("url");
        String username = rb.getString("user");
        String password = rb.getString("password");
        return DriverManager.getConnection(url,username,password);
    }
}