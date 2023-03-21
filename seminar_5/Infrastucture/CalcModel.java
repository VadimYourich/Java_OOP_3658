package seminar_5.Infrastucture;

/**
 * Модель расчета
 */

public abstract class CalcModel <T> implements Model<T> {
    protected T x, y;

    @Override
    public void setX(T value) {
        this.x = value;
    }

    @Override
    public void setY(T value) {
        this.y = value;
    }
}