package seminar_5.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.*;

/**
 * Логгирование
 */

public class MyLogger {
    Logger logger;

    public MyLogger(Logger logger) {
        this.logger = logger;
    }

    public void log(String info) {
        try {
            FileHandler fh = new FileHandler("seminar_5\\FileLog.txt", true);
            logger.addHandler(fh);
            Formatter Format = new SimpleFormatter();
            fh.setFormatter(Format);
            logger.info(info);
            fh.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
