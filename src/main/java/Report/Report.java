package Report;

import JDBC.DBConnection;
import JDBC.Fixiks;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.FacetImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Report {
    private static String[][] matA = new String[100][3];
    private static String[][] matB = new String[100][4];
    private Scanner st = new Scanner(System.in);
    private static int i, j;

    private void report_1() throws SQLException, IOException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            System.out.println("Введите название города.");
            String NameCity = st.next();

            String SQL = "SELECT manufacturer.NameManu, accessories.NameAccessories, stock.QuantityInStock " +
                    "FROM  stock, city, accessories, manufacturer " +
                    "WHERE stock.CodeCity=city.CodeCity " +
                    "AND manufacturer.codeManufacturer=accessories.codeManufacturer " +
                    "AND accessories.AccessoryCode=stock.AccessoryCode " +
                    "AND city.NameCity='" + NameCity + "';";
            ResultSet resultSet = statement.executeQuery(SQL);

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

        //Пустой документ
        XWPFDocument document = new XWPFDocument();
        //Записать документ в файловую систему
        FileOutputStream out = new FileOutputStream(new File("Отчёт№1.docx"));
        //создаь образец
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setFontSize(10);
        run.setFontFamily("Courier New");
        run.setText("Запчасти в городе.");
        run.addBreak();
        run.setText("====================================================================");
        run.addBreak();
        run.setText("|Название_фирмы        |Название_детали         |Количество_деталей       |");
        run.addBreak();
        run.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        run.addBreak();
        for (int q = 0; q < i; q++) {
            for (int w = 0; w < 3; w++) {
                if (matA[q][w] != null) {
                    char arr1[] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
                    matA[q][w] = Fixiks.transliterate(matA[q][w]);
                    char arr2[] = matA[q][w].toCharArray();
                    for (int i = 0; i < arr2.length; i++) {
                        arr1[i] = arr2[i];
                    }
                    for (int i = 0; i < arr1.length; i++) {
                        run.setFontSize(10);
                        run.setFontFamily("Courier New");

                        run.setText(String.valueOf(arr1[i]));
                    }
                } else break;
            }
            run.addBreak();
        }
        run.addBreak();
        run.addBreak();
        run.addBreak();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime());
        run.setText("Время формирование отчёта: " + timeStamp);
        run.addBreak();
        run.addBreak();
        run.addBreak();
        run.setText("" + System.getProperty("user.name") + "   ________________");
        run.addBreak();
        document.write(out);

        //закрыть документ
        out.close();

    }

    private void report_2() throws SQLException, IOException {
        Connection connection = new DBConnection().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String SQL = "SELECT customer.FullName, saleofcomponents.idSaleOfComponents,  saleofcomponents.DateS, (Amount*Price) AS Stet " +
                    "FROM customer, saleofcomponents,accessories " +
                    "WHERE customer.CodeCustomer=saleofcomponents.CodeCustomer " +
                    "AND accessories.AccessoryCode=saleofcomponents.AccessoryCode;";
            ResultSet resultSet = statement.executeQuery(SQL);

            i = 0;
            while (resultSet.next()) {
                j = 0;
                String FullName = resultSet.getString(1);
                matB[i][j] = FullName;
                j++;
                String idSaleOfComponents = resultSet.getString(2);
                matB[i][j] = idSaleOfComponents;
                j++;
                String Stet = resultSet.getString(3);
                matB[i][j] = Stet;
                j++;
                String DateS = resultSet.getString(4);
                matB[i][j] = DateS;
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
        //Пустой документ
        XWPFDocument document = new XWPFDocument();
        //Записать документ в файловую систему
        FileOutputStream out = new FileOutputStream(new File("Отчёт№2.docx"));
        //создаь образец
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setFontSize(10);
        run.setFontFamily("Courier New");
        run.setText("<Итоговоая сумма по одну покупку.");
        run.addBreak();
        run.setText("===========================================================================");
        run.addBreak();
        run.setText("|Фаммилия И.О.    |Номер чека         |Дата продажи       |Cумма за покупку    |");
        run.addBreak();
        run.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        run.addBreak();
        for (int q = 0; q < i; q++) {
            for (int w = 0; w < 4; w++) {
                if (matB[q][w] != null) {
                    char arr1[] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
                    matB[q][w] = Fixiks.transliterate(matB[q][w]);
                    char arr2[] = matB[q][w].toCharArray();
                    for (int i = 0; i < arr2.length; i++) {
                        arr1[i] = arr2[i];
                    }
                    for (int i = 0; i < arr1.length; i++) {
                        run.setFontSize(10);
                        run.setFontFamily("Courier New");

                        run.setText(String.valueOf(arr1[i]));
                    }
                } else break;
            }
            run.addBreak();
        }
        run.addBreak();
        run.addBreak();
        run.addBreak();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime());
        //String username = System.getProperty("user.name");
        run.setText("Время формирование отчёта: " + timeStamp);
        run.addBreak();
        run.addBreak();
        run.addBreak();
        run.setText("" + System.getProperty("user.name") + "   ________________");
        run.addBreak();
        document.write(out);
        //закрыть документ
        out.close();

    }

    public void menyReport() throws IOException, SQLException {
        int in = 1;
        do {
            System.out.println("Выбирите необходимый пункт\n" +
                    " - - - - - - - - - - - - -");
            System.out.println("1: Отчёт по количеству запчстей в выбранном городе.");
            System.out.println("2: Отчёт по повершённым покупким.");
            //System.out.println("3: Сортировать фирмы по числу покупок.");
            //System.out.println("4: Итоговый чек за каждую совершённую покупку.");
            //System.out.println("5: .");
            //System.out.println("6: .");
            System.out.println("9: Назад.");
//          JJAbrams
            int j = JJAbrams();

            switch (j) {
                case 1: {
                    try {
                        report_1();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        report_2();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 9: {
                    in = 2;
                    break;
                }
            }
        } while (in < 2);
    }

    private int JJAbrams() {
        int j;
        do {
            while (!st.hasNextInt()) {
                System.out.println(" - - - - - - - - - - - - - \n" +
                        "| Enter the correct item! |\n" +
                        " - - - - - - - - - - - - -");
                st.next();
            }
            j = st.nextInt();
        } while (j <= 0);
        return j;
    }
}
