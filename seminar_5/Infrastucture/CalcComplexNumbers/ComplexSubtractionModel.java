package seminar_5.Infrastucture.CalcComplexNumbers;

import seminar_5.Infrastucture.CalcModel;
import seminar_5.Infrastucture.ComplexNumber;

/**
 * Класс описывает модель разности комплексных чисел
 */

public class ComplexSubtractionModel extends CalcModel<ComplexNumber> {

    @Override
    public ComplexNumber result()  {
        return this.x.subtraction(this.y);
    }
}