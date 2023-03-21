package seminar_5.Presenter;

import seminar_5.Infrastucture.ComplexNumber;
import seminar_5.Infrastucture.CalcComplexNumbers.ComplexAdditionModel;
import seminar_5.Infrastucture.CalcComplexNumbers.ComplexDivisionModel;
import seminar_5.Infrastucture.CalcComplexNumbers.ComplexMultiplicationModel;
import seminar_5.Infrastucture.CalcComplexNumbers.ComplexSubtractionModel;
import seminar_5.Infrastucture.OperationAll.OperationStorageComplex;
import seminar_5.Infrastucture.OperationAll.OperationType;
import seminar_5.UI.View;

/**
 * Класс управления связью между Model и View для работы с комплексными числами
 */
public class PresenterCalcComplexNumbers extends PresenterCalc {

    public PresenterCalcComplexNumbers(View v) {
        view = v;
    }

    @Override
    public void setModel(int number) {
        switch (number) {
            case 1 -> this.model = new ComplexAdditionModel();
            case 2 -> this.model = new ComplexSubtractionModel();
            case 3 -> this.model = new ComplexMultiplicationModel();
            case 4 -> this.model = new ComplexDivisionModel();
        }
    }

    @Override
    public void buttonClick() {
        OperationStorageComplex operations = new OperationStorageComplex();
        operations.addOperation(1, OperationType.ADDITION.getTranslation());
        operations.addOperation(2, OperationType.SUBTRACTION.getTranslation());
        operations.addOperation(3, OperationType.MULTIPLICATION.getTranslation());
        operations.addOperation(4, OperationType.DIVISION.getTranslation());
        ComplexNumber res = null;
        int operation;
        ComplexNumber firstNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ВЕЩЕСТВЕННУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА:"),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА: "));
        do {
            operation = view.getVariant(operations.operationMenu());
        } while (operation < 1 || operation > 4);
        ComplexNumber secondNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ВЕЩЕСТВЕННУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА:"),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА: "));
        this.setModel(operation);
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (ComplexNumber) model.result();
        } catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        if (res != null)
            view.viewData(String.format("%s", res), String.format("РЕЗУЛЬТАТ ОПЕРАЦИИ \"%s ЧИСЕЛ %s И %s\" =>",
                    operations.getOperationMap().get(operation), firstNum, secondNum));
    }
}