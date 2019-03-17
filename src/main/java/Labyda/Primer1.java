package Labyda;


import JDBC.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Primer1 {

    private static int i, j;
    private static String[][] matA = new String[100][2];

    public static void main(String[] args) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//
//            String SQL = "SELECT * FROM manufacturer";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            System.out.println("Производитель");
//            System.out.println("===========================================");
//            System.out.println("|Код производителя   |Название            |");
//            System.out.println("-------------------------------------------");
//
//            i = 0;
//            while (resultSet.next()) {
//                j = 0;
//                String codeManufacturer = resultSet.getString(2);
//                matA[i][j] = codeManufacturer;
//                j++;
//                String NameManu = resultSet.getString(3);
//                matA[i][j] = NameManu;
//                i++;
//
////                System.out.println("Код производителя: " + codeManufacturer);
////                System.out.println("Название: " + NameManu);
////                System.out.println("----------------------------");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//
//        for (int q = 0; q < i; q++) {
//            for (int w = 0; w < 2; w++) {
//                if (matA[q][w] != null) {
//                    System.out.printf("%-21s", "|" + matA[q][w]);
//                } else break;
//            }
//            System.out.print("|");
//            System.out.println();
//        }
    }
}
