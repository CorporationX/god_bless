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
        Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
        Map<Subject, List<Student>> subjectMap = new HashMap<>();
        StudentDatabase database = new StudentDatabase(studentMap, subjectMap);

        Subject subject1 = new Subject(1, "Potions");
        Subject subject2 = new Subject(2, "Defense Against the Dark Arts");

        Map<Subject, Integer> gradesForHarry = new HashMap<>();
        gradesForHarry.put(subject1, 85);
        gradesForHarry.put(subject2, 90);
        Student student1 = new Student(1, "Harry Potter");
        database.addStudentWithSubjects(student1, gradesForHarry);

        System.out.println("=== После добавления Harry ===");
        database.printAllStudentsWithSubjectsAndScores();

        // Тест 2: Добавление предмета к существующему студенту
        Subject subject3 = new Subject(3, "Herbology");
        database.addSubjectWithStudent(student1, subject3, 88);

        System.out.println("\n=== После добавления Herbology для Harry ===");
        database.printAllStudentsWithSubjectsAndScores();

        // Тест 3: Добавление предмета с несколькими студентами
        Student student2 = new Student(2, "Hermione Granger");
        Student student3 = new Student(3, "Ron Weasley");
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