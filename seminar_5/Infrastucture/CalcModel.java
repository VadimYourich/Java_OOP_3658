package seminar_5.Infrastucture;

/**
 * Интерфейс модели калькулятора
 */

public abstract class CalcModel <T> implements Model<T> {
    protected T x, y;
}