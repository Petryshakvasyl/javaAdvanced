package ua.lviv.lgs.jdbc.simple;

import java.sql.*;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/demo";

    private static final String USER_NAME = "user";

    private static final String PASSWORD = "1111";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            String query = "SELECT * FROM employee";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("nex user: --> ");
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("firstName: " + resultSet.getString("first_name"));
                System.out.println("lastName: " + resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                //no op
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                //no op
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //no op
            }

        }

    }
}
