package seminar_5.Infrastucture.CalcRationalNumbers;

import seminar_5.Infrastucture.CalcModel;

/**
 * Класс описывает модель сложения рациональных чисел
 */

public class RationalAdditionModel extends CalcModel<Double> {

    @Override
    public Double result()  {
        return x + y;
    }
}