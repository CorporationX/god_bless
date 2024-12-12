package school.faang.task_45249;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private static HashMap<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

    @Getter
    private static HashMap<Subject, List<Student>> subjectStudents = new HashMap<>();

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {

        StudentDatabase studentDatabase = new StudentDatabase();

        Subject math = new Subject(1, "Математика");
        Subject history = new Subject(2, "История");
        Subject science = new Subject(3, "Физика");

        Student alice = new Student(1, "Майк Тайсон");
        Student bob = new Student(2, "Денис");

        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        aliceGrades.put(history, 90);
        studentDatabase.addStudentWithGrades(alice, aliceGrades);

        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(science, 85);
        bobGrades.put(history, 80);
        studentDatabase.addStudentWithGrades(bob, bobGrades);

        System.out.println("--- Все студенты и их оценки ---");
        studentDatabase.printAllStudents();

        System.out.println("\n--- Добавляем новый предмет для Майка ---");
        studentDatabase.addSubjectForStudent(alice, science, 88);
        studentDatabase.printAllStudents();

        System.out.println("\n--- Удаляем Денис из базы данных ---");
        studentDatabase.removeStud(bob, science);
        studentDatabase.printAllStudents();

        System.out.println("--- список всех по предметам ---");
        studentDatabase.printAllSubjects();

    }
}
