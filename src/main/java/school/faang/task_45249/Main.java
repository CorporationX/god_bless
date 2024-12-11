package school.faang.task_45249;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    //    хранит список предметов и оценок каждого студента
    @Getter
    public static HashMap<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

    //    хранит список студентов изучающих предмет
    @Getter
    public static HashMap<Subject, List<Student>> subjectStudents = new HashMap<>();

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        // Создаем базу данных студентов
        StudentDatabase studentDatabase = new StudentDatabase();

        // Создаем предметы
        Subject math = new Subject(1, "Математика");
        Subject history = new Subject(2, "История");
        Subject science = new Subject(3, "Физика");

        // Создаем студентов
        Student alice = new Student(1, "Майк Тайсон");
        Student bob = new Student(2, "Денис");

        // Добавляем студентов с оценками
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        aliceGrades.put(history, 90);
        studentDatabase.addStudentWithGrades(alice, aliceGrades);

        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(science, 85);
        bobGrades.put(history, 80);
        studentDatabase.addStudentWithGrades(bob, bobGrades);

        // Выводим всех студентов и их оценки
        System.out.println("--- Все студенты и их оценки ---");
        studentDatabase.printAll();

        // Добавляем новый предмет для существующего студента
        System.out.println("\n--- Добавляем новый предмет для Майка ---");
        studentDatabase.addSubjectForStudent(alice, science, 88);
        studentDatabase.printAll();

        // Удаляем студента
        System.out.println("\n--- Удаляем Денис из базы данных ---");
        studentDatabase.removeStud(bob, science);
        studentDatabase.printAll();
    }
}
