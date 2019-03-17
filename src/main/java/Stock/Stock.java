package Stock;

import JDBC.DBConnection;
import JDBC.Fixiks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Stock {
    private static int i, j;
    private static String[][] matA = new String[100][4];
    private Scanner st = new Scanner(System.in);

    public Stock() {}

    public void AddStock() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int StockCode = (Fixiks.NumberOfLines("StockCode", "stock")) + 1;
            System.out.print("Код комплектующего:");
            int AccessoryCode = st.nextInt();
            System.out.print("Количество:");
            int QuantityInStock = st.nextInt();
            System.out.print("Код города):");
            int CodeCity = st.nextInt();

            String SQL = "insert into stock(StockCode, AccessoryCode, QuantityInStock, CodeCity) " +
                    "values (" + StockCode + "," + AccessoryCode + ",'" + QuantityInStock + "'," + CodeCity + ")";

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

    public void DeleteStock() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код на складе:");
            int StockCode = st.nextInt();

            String SQL = "DELETE FROM stock WHERE StockCode=" + StockCode + "";
            statement.executeUpdate(SQL);

            CorrectionStock(StockCode);

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

    private void CorrectionStock(int key) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            int id = (Fixiks.NumberOfLines("StockCode", "stock"));
            int k = key;

            for (int i = key; i <= id; i++) {
                String SQL = "UPDATE  stock SET  StockCode=" + (k) + " WHERE StockCode=" + (k + 1) + "";
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

    public void PrintStock() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            String SQL = "call new_schema.PrintStock()";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Склад>");
            System.out.println("=====================================================================================");
            System.out.println("|Код на складе       |Код комплектующего  |Количество          |Код города          |");
            //System.out.println("|                    |                    |                    |                    |");
            System.out.println("-------------------------------------------------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String StockCode = resultSet.getString(2);
                matA[i][j] = StockCode;
                j++;
                String AccessoryCode = resultSet.getString(3);
                matA[i][j] = AccessoryCode;
                j++;
                String QuantityInStock = resultSet.getString(4);
                matA[i][j] = QuantityInStock;
                j++;
                String CodeCity = resultSet.getString(5);
                matA[i][j] = CodeCity;
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

    public void UpdateStock() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код изменяемого склада:");
            int StockCode = st.nextInt();
            System.out.print("Код комплектующего:");
            int AccessoryCode = st.nextInt();
            System.out.print("Количество:");
            int QuantityInStock = st.nextInt();
            System.out.print("Код города):");
            int CodeCity = st.nextInt();


            String SQL = "UPDATE  stock " +
                    "SET  AccessoryCode='" + AccessoryCode + "',QuantityInStock=" + QuantityInStock + ",CodeCity=" + CodeCity + " " +
                    "WHERE StockCode=" + StockCode + "";

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
