package Customer;

import JDBC.DBConnection;
import JDBC.Fixiks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
    private static int i, j;
    private static String[][] matA = new String[100][3];
    private Scanner st = new Scanner(System.in);

    public Customer() {
    }

    public void AddCustomer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int CodeCustomer = (Fixiks.NumberOfLines("CodeCustomer", "customer")) + 1;
            System.out.print("ФИО:");
            String FullName = st.next();
            System.out.print("Адрес:");
            String Address = st.next();

            String SQL = "insert into customer (CodeCustomer, FullName, Address) " +
                    "values (" + CodeCustomer + ", '" + FullName + "', '" + Address + "')";

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

    public void DeleteCustomer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код покупателя:");
            int CodeCustomer = st.nextInt();

            String SQL = "DELETE FROM customer WHERE CodeCustomer=" + CodeCustomer + "";
            statement.executeUpdate(SQL);

            CorrectionCustomer(CodeCustomer);

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

    private void CorrectionCustomer(int key) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            int id = (Fixiks.NumberOfLines("CodeCustomer", "customer"));
            int k = key;

            for (int i = key; i <= id; i++) {
                String SQL = "UPDATE  customer SET  CodeCustomer=" + (k) + " WHERE CodeCustomer=" + (k + 1) + "";
                statement.executeUpdate(SQL);
                k++;
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

    public void PrintCustomer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            String SQL = "CALL new_schema.PrintcCustomer()";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Покупатели>");
            System.out.println("================================================================");
            System.out.println("|Код покупателя      |Фамилия И.О.        |Адрес               |");
            System.out.println("----------------------------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String CodeCustomer = resultSet.getString(2);
                matA[i][j] = CodeCustomer;
                j++;
                String FullName = resultSet.getString(3);
                matA[i][j] = FullName;
                j++;
                String Address = resultSet.getString(4);
                matA[i][j] = Address;
                i++;
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
        for (int q = 0; q < i; q++) {
            for (int w = 0; w < 3; w++) {
                if (matA[q][w] != null) {
                    System.out.printf("%-21s", "|" + matA[q][w]);
                } else break;
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void UpdateCustomer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код зменяемого покупателя:");
            int CodeCustomer = st.nextInt();
            System.out.print("ФИО:");
            String FullName = st.next();
            System.out.print("Адрес:");
            String Address = st.next();


            String SQL = "UPDATE  customer " +
                    "SET  FullName=" + FullName + ",Address=" + Address + " " +
                    "WHERE CodeCustomer=" + CodeCustomer + "";

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
