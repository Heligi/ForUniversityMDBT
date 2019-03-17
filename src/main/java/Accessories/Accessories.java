package Accessories;

import JDBC.DBConnection;
import JDBC.Fixiks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Accessories {
    private static int i, j;
    private static String[][] matA = new String[100][4];
    private Scanner st = new Scanner(System.in);

    public Accessories() {}

    public void AddAccessories() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int AccessoryCode = (Fixiks.NumberOfLines("AccessoryCode", "accessories")) + 1;
            System.out.print("Код производителя:");
            int codeManufacturer = st.nextInt();
            System.out.print("Название, :");
            String NameAccessories = st.next();
            System.out.print("Цена):");
            int Price = st.nextInt();

            String SQL = "insert into accessories(AccessoryCode, codeManufacturer, NameAccessories, Price) " +
                    "values (" + AccessoryCode + "," + codeManufacturer + ",'" + NameAccessories + "'," + Price + ")";

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

    public void DeleteAccessories() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код комплектующего:");
            int AccessoryCode = st.nextInt();

            String SQL = "DELETE FROM accessories WHERE AccessoryCode=" + AccessoryCode + "";
            statement.executeUpdate(SQL);

            CorrectionAccessories(AccessoryCode);

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

    private void CorrectionAccessories(int key) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            int id = (Fixiks.NumberOfLines("AccessoryCode", "accessories"));
            int k = key;

            for (int i = key; i <= id; i++) {
                String SQL = "UPDATE  accessories SET  AccessoryCode=" + (k) + " WHERE AccessoryCode=" + (k + 1) + "";
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

    public void PrintAccessories() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            String SQL = "call new_schema.PrintAccessories()";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Комплектующие >");
            System.out.println("=====================================================================================");
            System.out.println("|Код комплектующего  |Код производителя   |Название            |Цена                |");
            System.out.println("-------------------------------------------------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String AccessoryCode = resultSet.getString(2);
                matA[i][j] = AccessoryCode;
                j++;
                String codeManufacturer = resultSet.getString(3);
                matA[i][j] = codeManufacturer;
                j++;
                String NameAccessories = resultSet.getString(4);
                matA[i][j] = NameAccessories;
                j++;
                String Price = resultSet.getString(5);
                matA[i][j] = Price;
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
            for (int w = 0; w < 4; w++) {
                if (matA[q][w] != null) {
                    System.out.printf("%-21s", "|" + matA[q][w]);
                } else break;
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void UpdateAccessories() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код изменяемого комплектующего:");
            int AccessoryCode = st.nextInt();
            System.out.print("Код производителя:");
            int codeManufacturer = st.nextInt();
            System.out.print("Название, :");
            String NameAccessories = st.next();
            System.out.print("Цена):");
            int Price = st.nextInt();


            String SQL = "UPDATE  accessories " +
                    "SET  codeManufacturer='" + codeManufacturer + "',NameAccessories=" + NameAccessories + ",Price=" + Price + " " +
                    "WHERE AccessoryCode=" + AccessoryCode + "";

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
