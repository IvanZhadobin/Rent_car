package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/RentAuto";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "Zhad02iv";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
