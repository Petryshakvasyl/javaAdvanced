package ua.lviv.lgs.jdbc.crud.conneciton;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionManager {

    private ConnectionManager() {
    }

    private static final String URL = "jdbc:mysql://localhost:3306/demo";

    private static final String USER_NAME = "user";

    private static final String PASSWORD = "1111";

    public static Connection createConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("error when creating connection", e);
        }
        return connection;
    }
}
