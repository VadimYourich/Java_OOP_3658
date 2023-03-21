package seminar_5.Infrastucture.CalcComplexNumbers;

import seminar_5.Infrastucture.CalcModel;
import seminar_5.Infrastucture.ComplexNumber;

/**
 * Класс описывает модель умножения комплексных чисел
 */

public class ComplexMultiplicationModel extends CalcModel<ComplexNumber> {

    @Override
    public ComplexNumber result()  {
        return this.x.multiplication(this.y);
    }
}