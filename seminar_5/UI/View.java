package seminar_5.UI;

import java.io.File;

/**
 * Интерфейс взаимодействия с пользователем
 */

public interface View {
    
    Double getValue(String title);

    int getVariant(String title);

    void viewData(String data, String title);

    void viewLog(File file);
}

