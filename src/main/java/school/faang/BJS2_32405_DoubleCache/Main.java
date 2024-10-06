package school.faang.BJS2_32405_DoubleCache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        Student John = new Student(1, "John");
        Student Alice = new Student(2, "Alice");
        Student Bob = new Student(3, "Bob");
        Student Eva = new Student(4, "Eva");
        Student Mike = new Student(5, "Mike");

        Subject math = new Subject(1,"Math");
        Subject physics = new Subject(2, "Physics");
        Subject chemistry = new Subject(3, "Chemistry");
        Subject literature = new Subject(4, "Literature");
        Subject history = new Subject(5, "History");

        Map<Subject, Integer> johnScores = new HashMap<>();
        johnScores.put(math, 90);
        johnScores.put(physics, 85);
        service.addStudentSubjectsScores(John, johnScores);

        Map<Subject, Integer> AliceScores = new HashMap<>();
        AliceScores.put(literature, 95);
        AliceScores.put(history, 88);
        service.addStudentSubjectsScores(Alice, AliceScores);

        service.addStudentSubjectScore(Bob, math, 78);
        service.addStudentSubjectScore(Bob, literature, 81);

        service.addStudentSubjectScore(Eva, chemistry, 92);
        service.addStudentSubjectScore(Eva, physics, 89);

        service.addStudentSubjectScore(Mike, history, 85);
        service.addStudentSubjectScore(Mike, math, 80);

        service.printAllStudentsScores();

        System.out.println();
        service.removeStudent(Alice);
        service.printAllStudentsScores();

        System.out.println();
        service.removeStudent(new Student(6, "NoName"));

        System.out.println();
        service.addStudentSubjectScore(Mike, math, 60);
        service.printAllStudentsScores();

        System.out.println("\nStudents by subjects:");
        service.printAllSubjectsAndStudents();
    }
}
