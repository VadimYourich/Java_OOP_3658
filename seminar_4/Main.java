package seminar_4;

/**
 * С учетом информации полученной ранее знакомимся с параметрическим полиморфизмом 
 * и продолжаем погружаться в ООП.
 * Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.
 * Например:
 * определить уровень приоритетов: низкий, средний, немедленное выполнение
 * выделить компоненту для хранения данных
 * выделить компоненту для организации импорта/экспорта данных
 * Файл должен содержать следующие данные: id, дату добавления записи, время добавления 
 * записи, дедлай задачи, ФИО автора
 * данные хранятся в файле csv/jsom/xml
 * другие компоненты
 */

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        TaskRepository<String> tr = new TaskRepository<>();
        tr.add(tr.createElement(0)
               .setBody("Task1")
               .setAddedTime(LocalDateTime.of(2023, 3, 11, 12, 0))
               .setDeadline(LocalDateTime.of(2023, 3, 15, 13, 0))
               .setAuthorName("Viktor"));
        tr.add(tr.createElement(1)
               .setBody("Task2")
               .setAddedTime(LocalDateTime.of(2023, 3, 14, 11, 0))
               .setDeadline(LocalDateTime.of(2023, 3, 25, 14, 0))
               .setAuthorName("Ivan"));
        tr.add(tr.createElement(2)
               .setBody("Task3")
               .setAddedTime(LocalDateTime.of(2023, 2, 2, 11, 0))
               .setDeadline(LocalDateTime.of(2023, 3, 21, 12, 0))
               .setAuthorName("Iliya"));
        tr.add(tr.createElement(3)
               .setBody("Task4")
               .setAddedTime(LocalDateTime.of(2023, 4, 4, 19, 0))
               .setDeadline(LocalDateTime.of(2023, 4, 24, 11, 0))
               .setAuthorName("Boris"));

        PriorityChecker checker = PriorityChecker.create()
                .appendProperty(Priority.LOW, 30)
                .appendProperty(Priority.MEDIUM, 14)
                .appendProperty(Priority.HIGH, 7)
                .appendProperty(Priority.IMMEDIATE, 1);

        TaskPlanner<String> tp = new TaskPlanner<>(tr, checker);

        tr.saveToJson("tasks.json");

        tr.loadFromJson("tasks.json");

        System.out.println(tp.getTasksByPriority(Priority.LOW));
        System.out.println(tp.getTasksByPriority(Priority.MEDIUM));
        System.out.println(tp.getTasksByPriority(Priority.HIGH));
        System.out.println(tp.getTasksByPriority(Priority.IMMEDIATE));
        System.out.println();
        System.out.println(tp.getPlane());
    }
}