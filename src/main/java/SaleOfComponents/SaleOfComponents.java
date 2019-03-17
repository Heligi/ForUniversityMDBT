package SaleOfComponents;

import JDBC.DBConnection;
import JDBC.Fixiks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class SaleOfComponents {
    private static int i, j;
    private static String[][] matA = new String[100][5];
    private Scanner st = new Scanner(System.in);

    public SaleOfComponents() {
    }

    public void AddSaleOfComponents() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int SalesCode = (Fixiks.NumberOfLines("SalesCode", "saleofcomponents")) + 1;

            System.out.print("Код комплектующего:");
            int AccessoryCode = st.nextInt();
            System.out.print("Количество:");
            int Amount = st.nextInt();
            System.out.print("Код покупателя:");
            int CodeCustomer = st.nextInt();
            String DateS = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

            String SQL = "insert into saleofcomponents(SalesCode,AccessoryCode,Amount,CodeCustomer,DateS) " +
                    "values (" + SalesCode + "," + AccessoryCode + "," + Amount + "," + CodeCustomer + ",'" + DateS + "');";

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

    public void DeleteSaleOfComponents() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код продажи:");
            int SalesCode = st.nextInt();

            String SQL = "DELETE FROM saleofcomponents WHERE SalesCode=" + SalesCode + "";
            statement.executeUpdate(SQL);

            CorrectionSaleOfComponents(SalesCode);

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

    private void CorrectionSaleOfComponents(int key) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            int id = (Fixiks.NumberOfLines("SalesCode", "saleofcomponents"));
            int k = key;

            for (int i = key; i <= id; i++) {
                String SQL = "UPDATE  saleofcomponents SET  SalesCode=" + (k) + " WHERE SalesCode=" + (k + 1) + "";
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

    public void PrintSaleOfComponents() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            String SQL = "call new_schema.PrintSaleOfComponents()";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Продажа комплектующих>");
            System.out.println("=========================================================================================================");
            System.out.println("|Код продажи         |Код комплектующего  |Количество          |Код покупателя      |Дата продажи        |");
            //                   System.out.println("|                    |                    |                    |                    |");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String SalesCode = resultSet.getString(2);
                matA[i][j] = SalesCode;
                j++;
                String AccessoryCode = resultSet.getString(3);
                matA[i][j] = AccessoryCode;
                j++;
                String Amount = resultSet.getString(4);
                matA[i][j] = Amount;
                j++;
                String CodeCustomer = resultSet.getString(5);
                matA[i][j] = CodeCustomer;
                j++;
                String DateS = resultSet.getString(6);
                matA[i][j] = DateS;
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
            for (int w = 0; w < 5; w++) {
                if (matA[q][w] != null) {
                    System.out.printf("%-21s", "|" + matA[q][w]);
                } else break;
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void UpdateSaleOfComponents() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Код изменяемой продажи продажи:");
            int SalesCode = st.nextInt();
            System.out.print("Код комплектующего:");
            int AccessoryCode = st.nextInt();
            System.out.print("Количество:");
            int Amount = st.nextInt();
            System.out.print("Код покупателя:");
            int CodeCustomer = st.nextInt();
            System.out.print("Введите дата продажи. \n" +
                    "Обращаем внимание, что дата должна быть следующего формата :<2000-01-01>.");
            String DateS = st.next();


            String SQL = "UPDATE  saleofcomponents " +
                    "SET  DateS='" + DateS + "', AccessoryCode=" + AccessoryCode + ",Amount=" + Amount + ",CodeCustomer=" + CodeCustomer + " " +
                    "WHERE SalesCode=" + SalesCode + "";

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
