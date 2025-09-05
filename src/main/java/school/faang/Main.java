package school.faang;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        Student s1 = new Student("Аня");
        Student s2 = new Student("Игорь");
        Student s3 = new Student("Катя");

        Subject math = new Subject("Математика");
        Subject physics = new Subject("Физика");
        Subject history = new Subject("История");

        Map<Subject, Integer> subjects1 = new HashMap<>();
        subjects1.put(math, 5);
        subjects1.put(physics, 4);
        db.addStudent(s1, subjects1);

        Map<Subject, Integer> subjects2 = new HashMap<>();
        subjects2.put(math, 3);
        subjects2.put(history, 5);
        db.addStudent(s2, subjects2);

        db.addSubjectToStudent(history, s1);

        db.addSubject(physics, Arrays.asList(s3));

        System.out.println("=== Студенты и их предметы ===");
        db.printDatabase();

        System.out.println("\n=== Предметы и студенты ===");
        db.printSubjectStudents();

        db.deleteStudent(s2);

        System.out.println("\n=== После удаления студента Игоря ===");
        db.printDatabase();
        db.printSubjectStudents();
    }
}
