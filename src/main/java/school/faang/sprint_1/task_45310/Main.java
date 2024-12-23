package school.faang.sprint_1.task_45310;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final StudentDatabase studentDatabase = new StudentDatabase();

        final Student student1 = new Student(1, "Erik");
        final Student student2 = new Student(2, "Meri");

        final Subject math = new Subject(1, "Math");
        final Subject english = new Subject(2, "English");

        final Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 30);
        grades1.put(english, 100);

        final Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(math, 100);
        grades2.put(english, 30);

        studentDatabase.addStudent(student1, grades1);
        studentDatabase.addStudent(student2, grades2);

        System.out.println("All Students:");
        studentDatabase.printAllStudents();

        studentDatabase.addSubjectForStudent(student1, new Subject(3, "Geometry"), 100);

        System.out.println("\nAll Students after adding geometries:");
        studentDatabase.printAllStudents();

        studentDatabase.removeStudent(student2);

        System.out.println("\nAll Students after removing Meri:");
        studentDatabase.printAllStudents();

        System.out.println("\nAll Subjects and their Students:");
        studentDatabase.printAllSubjects();
    }
}
