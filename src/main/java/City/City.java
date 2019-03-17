package City;

import JDBC.DBConnection;
import JDBC.Fixiks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Helig on 01.01.2019.
 */
public class City {
    private static int i, j;
    private static String[][] matA = new String[100][2];
    private Scanner st = new Scanner(System.in);

    public City() {}

    public void AddCity() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int CodeCity = (Fixiks.NumberOfLines("CodeCity", "city")) + 1;
            System.out.print("Название города:");
            String NameCity = st.next();

            String SQL = "insert into city (CodeCity,NameCity) " +
                    "values(" + CodeCity + ",'" + NameCity + "')";

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

    public void DeleteCity() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Введите код города:");
            int CodeCity = st.nextInt();


            String SQL = "DELETE FROM city WHERE CodeCity=" + CodeCity + "";

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

    public void PrintCity() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String SQL = "call new_schema.PrintCity()";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("<Города>");
            System.out.println("===========================================");
            System.out.println("|Код города          |Название            |");
            System.out.println("-------------------------------------------");

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String CodeCity = resultSet.getString(2);
                matA[i][j] = CodeCity;
                j++;
                String NameCity = resultSet.getString(3);
                matA[i][j] = NameCity;
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

    public void UpdateCity() throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            System.out.print("Введиде номер изменяемого города:");
            int CodeCity = st.nextInt();
            System.out.print("Введиде название города:");
            String NameCity = st.next();


            String SQL = "UPDATE  city SET  NameCity='" + NameCity + "' WHERE CodeCity=" + CodeCity + "";

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
