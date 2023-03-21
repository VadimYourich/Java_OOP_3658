package seminar_5.Infrastucture.CalcRationalNumbers;

import seminar_5.Infrastucture.CalcModel;

/**
 * Класс описывает модель деления рациональных чисел
 */

public class RationalDivisionModel extends CalcModel<Double> {

    @Override
    public Double result()  {
        if (y != 0) return x / y;
        return null;
    }
}