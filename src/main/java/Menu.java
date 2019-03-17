import Accounts.Authorization;
import Accounts.Registration;
import AdditionalRequests.QueryMenu;
import MenuFunctions.AddElements;
import MenuFunctions.DelateElements;
import MenuFunctions.PrintTables;
import MenuFunctions.UpdateElements;
import Report.Report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner st = new Scanner(System.in);

    private void job() throws SQLException, FileNotFoundException {
        int in = 1;
        do {
             System.out.println("1: Добавить элемент в таблицу.");
            System.out.println("2: Изменить данные в таблице.");
            System.out.println("3: Дополнительные запросы.");
            System.out.println("4: Вывести таблицу.");
            System.out.println("5: Формирование отчёта.");
            System.out.println("6: Удалить элемент.");
            //System.out.println("7: ФФ.");
            //System.out.println("8: ФФ.");
            System.out.println("9: Выход.");
//          JJAbrams
            int j = JJAbrams();

            switch (j) {
                case 1: {
                    AddElements addElements = new AddElements();
                    addElements.TableSelection();
                    break;
                }
                case 2: {
                    UpdateElements updateElements = new UpdateElements();
                    updateElements.TableSelection();
                    break;
                }
                case 3: {
                    QueryMenu queryMenu = new QueryMenu();
                    queryMenu.QueryMenuRin();
                    break;
                }
                case 4: {
                    PrintTables printTables = new PrintTables();
                    printTables.TableSelection();
                    break;
                }
                case 5: {
                    Report report = new Report();
                    try {
                        report.menyReport();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    DelateElements dalateElements = new DelateElements();
                    dalateElements.TableSelection();
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
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

    public void Auch() throws SQLException, FileNotFoundException {
        int aut = 1;
        do {
            System.out.println("1: Войти.");
            System.out.println("2: Зарегестрироваться.");
            System.out.println("3: Выйти.");
            int jj = JJAbrams();
            switch (jj) {
                case 1: {
                    Authorization authorization = new Authorization();
                    if (authorization.Check()) {
                        System.out.println("Авторизация прошла успешо!");
                        job();
                        aut = 2;
                    } else {
                        System.out.println("Неверный логин или пароль.");
                    }
                    break;
                }
                case 2: {
                    Registration registration = new Registration();
                    registration.AddUsers();
                    System.out.println("Выбирете первый пункт и войдите в систему под именем и пароллем который вы создали.");
                    break;
                }
                case 3: {
                    aut = 2;
                    break;
                }
            }
        } while (aut < 2);
    }
}
