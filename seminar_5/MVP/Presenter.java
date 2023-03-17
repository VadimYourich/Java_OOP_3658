package seminar_5.MVP;

import seminar_5.Infrastucture.*;
import seminar_5.Infrastucture.CalcModel;
import seminar_5.Logger.MyLogger;
import seminar_5.UI.View;

import java.util.logging.Logger;

/**
 * Класс управления связью между Model и View
 */
public class Presenter <T extends CalcModel> {
    static MyLogger myLog = new MyLogger(Logger.getLogger(Presenter.class.getName()));

    View view;
    Model model;

    public Presenter(T m, View v) {
        model = m;
        view = v;
    }

    public void buttonClick(){
        if (this.model instanceof CalcRationalNumbers) this.buttonClickRational();
        else if (this.model instanceof CalcComplexNumbers) buttonClickComplex();
    }
    public void buttonClickRational() {
        Double res = null;
        Double first = view.getValue("ВВЕДИТЕ ЧИСЛО: ");
        char operation = view.getOperation("ВВЕДИТЕ ОПЕРАЦИЮ (+,-,*,/): ");
        Double second = view.getValue("ВВЕДИТЕ ЧИСЛО: ");
        model.setX(first);
        model.setY(second);
        try {
            res = (Double) model.result(operation);}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        view.viewResult(String.format("%s", res), String.format("%s %s %s = ", first, operation, second));

    }
    public void buttonClickComplex(){
        ComplexNumber res = null;
        ComplexNumber firstNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ДЕЙСТВИТЕЛЬНУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА: "),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА: "));
        char operation = view.getOperation("ВВЕДИТЕ ОПЕРАЦИЮ (+,-,*,/): ");
        ComplexNumber secondNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ДЕЙСТВИТЕЛЬНУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА: "),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА: "));
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (ComplexNumber) model.result(operation);}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        view.viewResult(String.format("%s", res), String.format("%s %s %s = ", firstNum, operation, secondNum));
    }
}