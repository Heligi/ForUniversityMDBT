package AdditionalRequests;

import JDBC.DBConnection;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdditionalRequests {
    private static int i, j;
    private static String[][] matA = new String[100][3];
    private static String[][] matB = new String[100][2];
    private PrintWriter out = new PrintWriter("output.txt");
    private Scanner st = new Scanner(System.in);

    public AdditionalRequests() throws FileNotFoundException {}

    public void AdditionalRequests_1() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            System.out.println("Введите название города для просмотра запчастей." +
                    "");
            String NameCity = st.next();

            String SQL = "SELECT manufacturer.NameManu, accessories.NameAccessories, stock.QuantityInStock " +
                    "FROM  stock, city, accessories, manufacturer " +
                    "WHERE stock.CodeCity=city.CodeCity " +
                    "AND manufacturer.codeManufacturer=accessories.codeManufacturer " +
                    "AND accessories.AccessoryCode=stock.AccessoryCode " +
                    "AND city.NameCity='" + NameCity + "';";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Запчасти в " + NameCity + ".>");
            System.out.println("================================================================");
            System.out.println("|Название_фирмы      |Название_детали     |Количество_деталей  |");
            //System.out.println("|                    |                    |                    |                    |");
            System.out.println("----------------------------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String NameManu = resultSet.getString(1);
                matA[i][j] = NameManu;
                j++;
                String NameAccessories = resultSet.getString(2);
                matA[i][j] = NameAccessories;
                j++;
                String QuantityInStock = resultSet.getString(3);
                matA[i][j] = QuantityInStock;

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

    public void AdditionalRequests_2() throws SQLException, FileNotFoundException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String SQL = "select customer.FullName, count(customer.FullName) " +
                    "from customer, saleofcomponents " +
                    "where customer.CodeCustomer=saleofcomponents.CodeCustomer " +
                    "group by customer.FullName;\n";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Общее количество покупок по фамилиям.");
            System.out.println("===========================================");
            System.out.println("|ФИО                 |Количество покупок  |");
            //System.out.println("|                    |                    |                    |                    |");
            System.out.println("-------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String FIO = resultSet.getString(1);
                matB[i][j] = FIO;
                j++;
                String count = resultSet.getString(2);
                matB[i][j] = count;

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
            out.println("<Общее количество покупок по фамилиям.");
            out.println("===========================================");
            out.println("|ФИО                 |Количество покупок  |");
            out.println("-------------------------------------------");
        }

        for (int q = 0; q < i; q++) {
            for (int w = 0; w < 2; w++) {
                if (matB[q][w] != null) {
                    System.out.printf("%-21s", "|" + matB[q][w]);
                    out.print(matB[q][w] + "                   |");
                } else break;
            }
            System.out.print("|");
            System.out.println();
            out.println();
        }
        out.close();
    }

    public void AdditionalRequests_3() throws SQLException, FileNotFoundException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String SQL = "SELECT manufacturer.NameManu, count(saleofcomponents.SalesCode) AS Число_покупок  " +
                    "FROM manufacturer, accessories,saleofcomponents " +
                    "where manufacturer.codeManufacturer=accessories.codeManufacturer " +
                    "and accessories.AccessoryCode=saleofcomponents.AccessoryCode  " +
                    "group by NameManu " +
                    "order by Число_покупок desc;";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Общее количество покупок по фамилиям.");
            System.out.println("===========================================");
            System.out.println("|Название фирмы      |Количество покупок  |");
            //System.out.println("|                    |                    |                    |                    |");
            System.out.println("-------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String NameManu = resultSet.getString(1);
                matB[i][j] = NameManu;
                j++;
                String count = resultSet.getString(2);
                matB[i][j] = count;

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
                if (matB[q][w] != null) {
                    System.out.printf("%-21s", "|" + matB[q][w]);
                } else break;
            }
            System.out.print("|");
            System.out.println();
            out.println();
        }
        out.close();
    }

    public void AdditionalRequests_4() throws SQLException, FileNotFoundException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String SQL = "select customer.FullName, (Amount*Price) AS Счёт " +
                    "from customer, saleofcomponents,accessories " +
                    "where customer.CodeCustomer=saleofcomponents.CodeCustomer " +
                    "and accessories.AccessoryCode=saleofcomponents.AccessoryCode;";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Итоговоая сумма по одну покупку.");
            System.out.println("===========================================");
            System.out.println("|ФИО                 |Чек                 |");
            // System.out.println("|                    |                    |                    |                    |");
            System.out.println("-------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String Name = resultSet.getString(1);
                matB[i][j] = Name;
                j++;
                String count = resultSet.getString(2);
                matB[i][j] = count;

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
                if (matB[q][w] != null) {
                    System.out.printf("%-21s", "|" + matB[q][w]);
                } else break;
            }
            System.out.print("|");
            System.out.println();
            out.println();
        }
        out.close();
    }
}
