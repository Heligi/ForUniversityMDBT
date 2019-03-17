package MenuFunctions;


import Accessories.Accessories;
import City.City;
import Customer.Customer;
import Manufacturer.Manufacturer;
import SaleOfComponents.SaleOfComponents;
import Stock.Stock;

import java.sql.SQLException;
import java.util.Scanner;

public class AddElements {
    Scanner st = new Scanner(System.in);

    public void AddElements(){}

    public void TableSelection() throws SQLException {
        int in = 1;
        do {
            System.out.println("Выбирите необходимую таблицу\n" +
                    " - - - - - - - - - - - - -");
            System.out.println("1: Производитель.");
            System.out.println("2: Продажа комплектующих.");
            System.out.println("3: Покупатели.");
            System.out.println("4: Комплектующие .");
            System.out.println("5: Склад.");
            System.out.println("6: Города.");
            System.out.println("7: Назад.");
//          JJAbrams
            int j = JJAbrams();

            switch (j) {
                case 1: {
                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.AddManufacturer();
                    break;
                }
                case 2: {
                    SaleOfComponents saleOfComponents = new SaleOfComponents();
                    saleOfComponents.AddSaleOfComponents();
                    break;
                }
                case 3: {
                    Customer customer = new Customer();
                    customer.AddCustomer();
                    break;
                }
                case 4: {
                    Accessories accessories = new Accessories();
                    accessories.AddAccessories();
                    break;
                }
                case 5: {
                    Stock stock = new Stock();
                    stock.AddStock();
                    break;
                }
                case 6: {
                    City city = new City();
                    city.AddCity();
                    break;
                }
                case 7: {
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
