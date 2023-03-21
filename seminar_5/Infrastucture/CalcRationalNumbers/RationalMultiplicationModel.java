package seminar_5.Infrastucture.CalcRationalNumbers;

import seminar_5.Infrastucture.CalcModel;

/**
 * Класс описывает модель умножения рациональных чисел
 */

public class RationalMultiplicationModel extends CalcModel<Double> {

    @Override
    public Double result()  {
        return x * y;
    }
}
