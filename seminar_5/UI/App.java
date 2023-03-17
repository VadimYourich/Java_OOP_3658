package seminar_5.UI;

import seminar_5.Infrastucture.CalcComplexNumbers;
import seminar_5.Infrastucture.CalcRationalNumbers;
import seminar_5.MVP.*;
import seminar_5.Logger.MyLogger;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Меню программы
 */

public class App {
    static Scanner in = new Scanner(System.in);
    static MyLogger myLog = new MyLogger(Logger.getLogger(App.class.getName()));

    static View view = new ConsoleView();
    static Presenter presenter;

    public static void start() {
        while (true) {
            System.out.println();
            System.out.println("""
                        ВВЕДИТЕ ЦИФРУ ТРЕБУЕМОЙ ОПЕРАЦИИ ИЗ МЕНЮ:
                        1 => ОПЕРАЦИИ С РАЦИОНАЛЬНЫМИ ЧИСЛАМИ
                        2 => ОПЕРАЦИИ С КОМПЛЕКСНЫМИ ЧИСЛАМИ
                        3 => ПРОСМОТР ФАЙЛА ЛОГИРОВАНИЯ
                        4 => ВЫХОД ИЗ ПРОГРАММЫ
                    """);
            switch (in.nextInt()) {
                case 1 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ОПЕРАЦИИ С РАЦИОНАЛЬНЫМИ ЧИСЛАМИ");
                    presenter = new Presenter<>(new CalcRationalNumbers(), view);
                    presenter.buttonClick();
                }
                case 2 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ОПЕРАЦИИ С КОМПЛЕКСНЫМИ ЧИСЛАМИ");
                    presenter = new Presenter<>(new CalcComplexNumbers(), view);
                    presenter.buttonClick();
                }
                case 3 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ПРОСМОТР ФАЙЛА ЛОГИРОВАНИЯ");
                    view.viewLogger(new File("seminar_5\\FileLog.txt"));
                }
                case 4 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ВЫХОД ИЗ ПРОГРАММЫ");
                    return;
                }
                default -> myLog.log("ВВЕДЕН НЕКОРРЕКТНЫЙ ПУНКТ МЕНЮ. ПОВТОРИТЕ ВВОД...");
            }
        }
    }
}
