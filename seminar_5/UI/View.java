package seminar_5.UI;

import java.io.File;

public interface View {
    Double getValue(String title);

    char getOperation(String title);

    void viewResult(String result, String title);

    void viewLogger(File file);
}

