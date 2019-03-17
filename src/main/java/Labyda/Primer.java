package Labyda;

import JDBC.DBConnection;

import java.sql.*;


// Получения данных
public class Primer {

    public static void main(String[] args) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            System.out.println("Getting records...");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                int idusers = resultSet.getInt(1);
                String  UsersName = resultSet.getString(2);
                String Password = resultSet.getString(3);

                System.out.println("id: " + idusers);
                System.out.println("UsersName: " + UsersName);
                System.out.println("Password: " + Password);
                System.out.println("===================\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
