package Accounts;

import JDBC.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Authorization {

    private Scanner st = new Scanner(System.in);

    public Authorization() {}

    public boolean Check() throws SQLException {

        boolean check = false;

        System.out.print("Enter User Name:");
        String name = st.next();
        System.out.print("Enter Password:");
        String pass = st.next();

        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String SQL = "SELECT UsersName,Password \n" +
                    "FROM users\n" +
                    "WHERE (UsersName='" + name + "')AND(Password='" + pass + "')";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                String UsersName = resultSet.getString(1);
                String Password = resultSet.getString(2);

                if (name.equals(UsersName) && pass.equals(Password)) {
                    check = true;
                }
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

        return check;
    }

}
