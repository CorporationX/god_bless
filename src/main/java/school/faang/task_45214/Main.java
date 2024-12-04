package school.faang.task_45214;

import school.faang.task_45214.model.Student;
import school.faang.task_45214.model.Subject;
import school.faang.task_45214.util.StudentDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем студентов
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Harry Potter");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Hermione Granger");

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("Ron Weasley");

        // Создаем предметы
        Subject subject1 = new Subject();
        subject1.setId(1);
        subject1.setName("Potions");

        Subject subject2 = new Subject();
        subject2.setId(2);
        subject2.setName("Defense Against the Dark Arts");

        Subject subject3 = new Subject();
        subject3.setId(3);
        subject3.setName("Herbology");

        // Создаем базу данных студентов
        Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
        Map<Subject, List<Student>> subjectMap = new HashMap<>();
        StudentDatabase database = new StudentDatabase(studentMap, subjectMap);

        // Тест 1: Добавление студента с предметами
        Map<Subject, Integer> gradesForHarry = new HashMap<>();
        gradesForHarry.put(subject1, 85);
        gradesForHarry.put(subject2, 90);
        database.addStudentWithSubjects(student1, gradesForHarry);

        System.out.println("=== После добавления Harry ===");
        database.printAllStudentsWithSubjectsAndScores();

        // Тест 2: Добавление предмета к существующему студенту
        database.addSubjectWithStudent(student1, subject3, 88);

        System.out.println("\n=== После добавления Herbology для Harry ===");
        database.printAllStudentsWithSubjectsAndScores();

        // Тест 3: Добавление предмета с несколькими студентами
        database.addSubjectWithStudents(subject3, Arrays.asList(student2, student3));

        System.out.println("\n=== После добавления Herbology для Hermione и Ron ===");
        database.printAllSubjectsWithStudents();

        // Тест 4: Удаление студента вместе с его предметами
        database.deleteStudentWithSubjects(student1);

        System.out.println("\n=== После удаления Harry ===");
        database.printAllStudentsWithSubjectsAndScores();

        // Тест 5: Удаление студента из конкретного предмета
        database.deleteStudentFromSubjects(subject3, student2);

        System.out.println("\n=== После удаления Hermione из Herbology ===");
        database.printAllSubjectsWithStudents();
    }
}
