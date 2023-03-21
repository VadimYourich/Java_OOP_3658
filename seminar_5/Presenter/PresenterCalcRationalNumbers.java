package seminar_5.Presenter;

import seminar_5.Infrastucture.CalcRationalNumbers.RationalAdditionModel;
import seminar_5.Infrastucture.CalcRationalNumbers.RationalDivisionModel;
import seminar_5.Infrastucture.CalcRationalNumbers.RationalMultiplicationModel;
import seminar_5.Infrastucture.CalcRationalNumbers.RationalSubtractionModel;
import seminar_5.Infrastucture.OperationAll.OperationStorageRational;
import seminar_5.Infrastucture.OperationAll.OperationType;
import seminar_5.UI.View;

/**
 * Класс управления связью между Model и View для работы с рациональными числами
 */

public class PresenterCalcRationalNumbers extends PresenterCalc {

    public PresenterCalcRationalNumbers(View v) {
        view = v;
    }

    @Override
    public void setModel(int number) {
        switch (number) {
            case 1 -> this.model = new RationalAdditionModel();
            case 2 -> this.model = new RationalSubtractionModel();
            case 3 -> this.model = new RationalMultiplicationModel();
            case 4 -> this.model = new RationalDivisionModel();
            default -> {
            }
        }
    }

    @Override
    public void buttonClick() {
        OperationStorageRational operations = new OperationStorageRational();
        operations.addOperation(1, OperationType.ADDITION.getTranslation());
        operations.addOperation(2, OperationType.SUBTRACTION.getTranslation());
        operations.addOperation(3, OperationType.MULTIPLICATION.getTranslation());
        operations.addOperation(4, OperationType.DIVISION.getTranslation());
        Double res = null;
        int operation;
        Double firstNum = view.getValue("ВВЕДИТЕ 1 ЧИСЛО: ");
        do {
            operation = view.getVariant(operations.operationMenu()); 
        } while (operation < 1 || operation > 4);                    
        Double secondNum = view.getValue("ВВЕДИТЕ 2 ЧИСЛО: "); 
        setModel(operation);
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (Double) model.result();}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        if (res != null)
            view.viewData(String.format("%s", res), String.format("РЕЗУЛЬТАТ ОПЕРАЦИИ \"%s ЧИСЕЛ %s И %s\" =>",
                    operations.getOperationMap().get(operation), firstNum, secondNum));
        else
            view.viewData(String.format("%s", res), String.format("Некорректное выражение операции %s чисел %s и %s =>",
                    operations.getOperationMap().get(operation), firstNum, secondNum));
    }
}