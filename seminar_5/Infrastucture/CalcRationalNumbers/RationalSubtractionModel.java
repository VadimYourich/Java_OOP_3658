package seminar_5.Infrastucture.CalcRationalNumbers;

import seminar_5.Infrastucture.CalcModel;

/**
 * Класс описывает модель разности рациональных чисел
 */

public class RationalSubtractionModel extends CalcModel<Double> {

    @Override
    public Double result() {
        return x - y;
    }
}
