package seminar_5.Presenter;

import java.util.logging.Logger;

import seminar_5.Infrastucture.Model;
import seminar_5.Logger.MyLoggerNew;
import seminar_5.UI.View;

/**
 * Абстрактный класс описывает компоненту связи Model и View между собой
 */

public abstract class PresenterCalc implements I_Presenter {
    static protected MyLoggerNew myLog;
    protected View view;
    protected Model model;

    static {
        myLog = new MyLoggerNew(Logger.getLogger(PresenterCalc.class.getName()));
    }
}