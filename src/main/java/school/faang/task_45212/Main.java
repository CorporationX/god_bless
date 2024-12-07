package school.faang.task_45212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            StudentDatabase studentDatabase = new StudentDatabase();
            Student alexey = new Student(1, "Алексей");
            Student sergey = new Student(2, "Сергей");
            Subject math = new Subject(1, "Математика");
            Subject physics = new Subject(2, "Физика");

            // Добавление студентов и их оценок
            Map<Subject, Integer> alexeyGrades = new HashMap<>();
            alexeyGrades.put(math, 5);
            alexeyGrades.put(physics, 4);
            studentDatabase.addStudent(alexey, alexeyGrades);

            Map<Subject, Integer> sergeyGrades = new HashMap<>();
            sergeyGrades.put(math, 3);
            sergeyGrades.put(physics, 5);
            studentDatabase.addStudent(sergey, sergeyGrades);

            // Вывод всех студентов и их оценок
            System.out.println("Список студентов и их оценок:");
            studentDatabase.printAllStudents();

            // Добавление нового предмета для студента
            Subject chemistry = new Subject(3, "Химия");
            studentDatabase.addSubjectForStudent(alexey, chemistry, 4);

            // Удаление студента
            studentDatabase.removeStudent(sergey);

            // Вывод всех студентов и их оценок
            System.out.println("\nСписок студентов и их оценок после изменений:");
            studentDatabase.printAllStudents();

            // Добавление нового предмета
            List<Student> studentsForSubject = new ArrayList<>();
            studentsForSubject.add(alexey);
            studentsForSubject.add(sergey);
            studentDatabase.addSubject(chemistry, studentsForSubject);

            // Вывод всех предметов и студентов
            System.out.println("\nСписок предметов и студентов:");
            studentDatabase.printAllSubjects();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
