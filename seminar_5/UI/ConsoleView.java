package seminar_5.UI;

import seminar_5.Logger.MyLogger;

import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.File;
import java.io.BufferedReader;

/**
 * Класс описывает общение с пользователем
 */

public class ConsoleView implements View {
    static MyLogger myLog = new MyLogger(Logger.getLogger(ConsoleView.class.getName()));
    Scanner scanner;
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Double getValue(String title) {
        System.out.println(title);
        Double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
            myLog.log(String.format("%s => %s", title, num));
        } else {
            System.out.println("ДОПУЩЕНА ОШИБКА ПРИ ВВОДЕ ЧИСЛА! ПОПРОБУЙТЕ СНОВА.");
            myLog.log(String.format("%s => ОШИБКА ВВОДА", title));
            scanner.next();
            num = getValue(title);
        }
        return num;
    }

    @Override
    public char getOperation(String title) {
        System.out.println(title);
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
            myLog.log(String.format("%s => \"%s\"", title, operation));
        } else {
            System.out.println("ДОПУЩЕНА ОШИБКА ПРИ ВВОДЕ ЧИСЛА! ПОПРОБУЙТЕ СНОВА.");
            myLog.log(String.format("%s => ОШИБКА ВВОДА", title));
            scanner.next();
            operation = getOperation(title);
        }
        return operation;    
    }

    @Override
    public void viewResult(String result, String title) {
        myLog.log(String.format("ВЫДАН РЕЗУЛЬТАТ %s %s", title, result));
        System.out.printf("%s %s\n", title, result);
    }

    @Override
    public void viewLogger(File file) {
        myLog.log(String.format("%s - ВЫДАНО СОДЕРЖИМОЕ ЖУРНАЛА ЛОГГИРОВАНИЯ ПО ЗАПРОСУ ", file));
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            myLog.log(String.format("%s - ОШИБКА ЧТЕНИЯ ФАЙЛА ЖУРНАЛА ЛОГГИРОВАНИЯ ", file));
            e.printStackTrace();
        }
    }
}
