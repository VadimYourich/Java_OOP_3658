package seminar_5.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Класс описывает функционал логирования в проекте
 */
public class MyLoggerNew {
    Logger logger;

    public MyLoggerNew(Logger logger) {
        this.logger = logger;
    }

    public void log(String info) {
        try {
            FileHandler fh = new FileHandler("seminar_5\\CalculatorLog.txt", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.info(info);
            fh.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
