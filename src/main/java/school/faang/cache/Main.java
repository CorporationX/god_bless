package school.faang.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем новый экземпляр базы данных студентов
        StudentDatabase db = new StudentDatabase();

        // Создаем HashMap для хранения предметов и оценок
        // Map.of() создает неизменяемую карту с одним элементом (предмет "Algoritms" с оценкой 5)
        // Оборачиваем в новый HashMap, чтобы сделать карту изменяемой
        HashMap<Subject, Integer> subjects = new HashMap<>(Map.of(new Subject("Algoritms"), 5));

        // Добавляем студента "Sergey" с его предметами в базу данных
        db.addStudent("Sergey", subjects);

        // Выводим пустую строку в консоль
        System.out.println();
    }
}
