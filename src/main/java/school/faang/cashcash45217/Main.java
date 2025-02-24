package school.faang.cashcash45217;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        final Student alice = new Student(1, "Alice");
        final Student ilya = new Student(2, "Ilya");
        final Subject math = new Subject(1, "Mathematic");
        final Subject fis = new Subject(2, "Physics");

        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 5);
        aliceGrades.put(fis, 4);
        database.addStudent(alice, aliceGrades);

        Map<Subject, Integer> ilyaGrades = new HashMap<>();
        ilyaGrades.put(math, 4);
        database.addStudent(ilya, ilyaGrades);

        System.out.println("Students and their grades:");
        database.printAllSubjects();

        System.out.println("Subjects and their students:");
        database.printAllStudents();

        Subject history = new Subject(3, "History");
        database.addSubject(history);
        database.addSubjectForStudent(alice, history, 4);

        System.out.println("Update students and their grades");
        database.printAllStudents();

        database.removeStudent(ilya);
        System.out.println("After remove Ilya:");
        database.printAllStudents();

        System.out.println("Subjects and their students, after remove Ilya:");
        database.printAllSubjects();
    }
}
