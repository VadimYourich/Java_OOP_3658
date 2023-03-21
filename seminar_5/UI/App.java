package seminar_5.UI;

import seminar_5.Presenter.I_Presenter;
import seminar_5.Presenter.PresenterCalcComplexNumbers;
import seminar_5.Presenter.PresenterCalcRationalNumbers;

import java.io.File;

/**
 * Меню приложения
 */

public class App {
    private final View view;
    private I_Presenter presenter;

    public App(View view) {
        this.view = view;
    }

    void setPresenter(int num) {
        if (num == 1) presenter = new PresenterCalcRationalNumbers(view);
        else if (num == 2) {
            presenter = new PresenterCalcComplexNumbers(view);
        }
    }

    public void start() {
        while (true) {
            int menu = view.getVariant("""
                    
                        ВВЕДИТЕ ЧИСЛО, СОГЛАСНО ПУНКТУ МЕНЮ:
                        1 => ОПЕРАЦИИ С РАЦИОНАЛЬНЫМИ ЧИСЛАМИ
                        2 => ОПЕРАЦИИ С КОМПЛЕКСНЫМИ ЧИСЛАМИ
                        3 => ПРОСМОТР ФАЙЛА ЛОГИРОВАНИЯ
                        4 => ВЫХОД ИЗ ПРОГРАММЫ""");
            switch (menu) {
                case 1, 2:
                    this.setPresenter(menu); 
                    presenter.buttonClick();
                    break;
                case 3:
                    view.viewLog(new File("seminar_5\\CalculatorLog.txt"));
                    break;
                case 4:
                    return;
                default:
                    view.viewData( "ВВЕДЕН НЕКОРРЕКТНЫЙ ПУНКТ МЕНЮ."," ПОВТОРИТЕ ВВОД.");
                    break;
            }
        }
    }
}