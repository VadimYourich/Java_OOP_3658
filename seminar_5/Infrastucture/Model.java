package seminar_5.Infrastucture;

/**
 * Интерфейс описывает стандартное поведение основной логики проекта
 */

public interface Model <T> {

    T result();

    void setX(T value);

    void setY(T value);
}

