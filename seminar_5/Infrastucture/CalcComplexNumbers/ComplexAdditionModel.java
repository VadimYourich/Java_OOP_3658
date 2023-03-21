package seminar_5.Infrastucture.CalcComplexNumbers;

import seminar_5.Infrastucture.CalcModel;
import seminar_5.Infrastucture.ComplexNumber;

/**
 * Класс описывает модель сложения комплексных чисел
 */
public class ComplexAdditionModel extends CalcModel<ComplexNumber> {

    @Override
    public ComplexNumber result()  {
        return this.x.addition(this.y);
    }


}