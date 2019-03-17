package Manufacturer;

import JDBC.DBConnection;
import JDBC.Fixiks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manufacturer {
    private static int i, j;
    private static String[][] matA = new String[100][2];
    private Scanner st = new Scanner(System.in);

    public Manufacturer() {
    }

    public void AddManufacturer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int key = (Fixiks.NumberOfLines("codeManufacturer", "manufacturer")) + 1;

            System.out.print("Назваине фирмы:");
            String name = st.next();

            String SQL = "insert into manufacturer (codeManufacturer,NameManu) " +
                    "values(" + key + ",'" + name + "')";

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

    public void DeleteManufacturer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Введите код производителя:");
            int key = st.nextInt();

            String SQL = "DELETE FROM manufacturer WHERE codeManufacturer=" + key + "";
            statement.executeUpdate(SQL);

            CorrectionManufacturer(key);

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

    private void CorrectionManufacturer(int key) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            int id = (Fixiks.NumberOfLines("codeManufacturer", "manufacturer"));
            int k = key;

            for (int i = key; i <= id; i++) {
                String SQL = "UPDATE  manufacturer SET  codeManufacturer=" + (k) + " WHERE codeManufacturer=" + (k + 1) + "";
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

    public void PrintManufacturer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String SQL = "CALL new_schema.PrintManufacturer()";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Производитель>");
            System.out.println("===========================================");
            System.out.println("|Код производителя   |Название            |");
            System.out.println("-------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String codeManufacturer = resultSet.getString(2);
                matA[i][j] = codeManufacturer;
                j++;
                String NameManu = resultSet.getString(3);
                matA[i][j] = NameManu;
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
            for (int w = 0; w < 2; w++) {
                if (matA[q][w] != null) {
                    System.out.printf("%-21s", "|" + matA[q][w]);
                } else break;
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void UpdateManufacturer() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Введиде код производителя:");
            int codeManufacturer = st.nextInt();
            System.out.print("Введиде название фирмы:");
            String NameManu = st.next();


            String SQL = "UPDATE  manufacturer SET  NameManu='" + NameManu + "' WHERE codeManufacturer=" + codeManufacturer + "";

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
