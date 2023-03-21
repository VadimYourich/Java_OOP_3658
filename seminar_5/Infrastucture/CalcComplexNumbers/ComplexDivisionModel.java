package seminar_5.Infrastucture.CalcComplexNumbers;

import seminar_5.Infrastucture.CalcModel;
import seminar_5.Infrastucture.ComplexNumber;

/**
 * Класс описывает модель деления комплексных чисел
 */

public class ComplexDivisionModel extends CalcModel<ComplexNumber> {

    @Override
    public ComplexNumber result() {
        if (this.y.getReal() == 0 && this.y.getImaginary() == 0) {
            return null;
        } else return this.x.division(this.y);
    }
}
