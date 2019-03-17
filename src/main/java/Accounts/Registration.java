package Accounts;

import JDBC.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {

    private Scanner st = new Scanner(System.in);

    public Registration(){}

    public void AddUsers() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        System.out.print("Введите имя пользователя:");
        String name = st.next();
        System.out.print("Введите пароль:");
        String pass = st.next();

        try {
            statement = connection.createStatement();
            String SQL = "insert into users (UsersName, Password) values ('" + name + "', '" + pass + "')";

            statement.executeUpdate(SQL);

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
