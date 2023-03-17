package seminar_5.Infrastucture;

/**
 * Интерфейс Модели
 */
public interface Model <T> {
    T result(char operation) throws Exception;


    void setX(T value);

    void setY(T value);
}

