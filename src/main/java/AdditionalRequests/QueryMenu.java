package AdditionalRequests;

import Accessories.Accessories;
import City.City;
import Customer.Customer;
import Manufacturer.Manufacturer;
import SaleOfComponents.SaleOfComponents;
import Stock.Stock;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class QueryMenu {

    private Scanner st = new Scanner(System.in);
    AdditionalRequests additionalRequests = new AdditionalRequests();

    public QueryMenu() throws FileNotFoundException {}

    public void QueryMenuRin() throws SQLException, FileNotFoundException {
        int in = 1;
        do {
            System.out.println("Выбирите необходимый пункт\n" +
                    " - - - - - - - - - - - - -");
            System.out.println("1: Просмотреть склад в выбранном городе.");
            System.out.println("2: Общее количество покупок по фамилиям.");
            System.out.println("3: Сортировать фирмы по числу покупок.");
            System.out.println("4: Итоговый чек за каждую совершённую покупку.");
            System.out.println("9: Назад.");
//          JJAbrams
            int j = JJAbrams();

            switch (j) {
                case 1: {
                    additionalRequests.AdditionalRequests_1();
                    break;
                }
                case 2: {
                    additionalRequests.AdditionalRequests_2();
                    break;
                }
                case 3: {
                    additionalRequests.AdditionalRequests_3();
                    break;
                }
                case 4: {
                    additionalRequests.AdditionalRequests_4();
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
