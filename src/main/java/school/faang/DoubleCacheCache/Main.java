package school.faang.DoubleCacheCache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Student student1 = new Student("Bob");
        final Student student2 = new Student("Alice");
        final Student student3 = new Student("Eva");

        final Subject math = new Subject("Math");
        final Subject history = new Subject("History");
        final Subject english = new Subject("English");

        final StudentDatabase database = new StudentDatabase();

        Map<Subject, Integer> student1Subjects = new HashMap<>();
        student1Subjects.put(math, 4);
        student1Subjects.put(history, 5);
        student1Subjects.put(english, 3);
        database.addStudent(student1, student1Subjects);

        Map<Subject, Integer> student2Subjects = new HashMap<>();
        student2Subjects.put(math, 5);
        student2Subjects.put(history, 3);
        student2Subjects.put(english, 4);
        database.addStudent(student2, student2Subjects);

        Map<Subject, Integer> student3Subjects = new HashMap<>();
        student3Subjects.put(math, 3);
        student3Subjects.put(history, 2);
        student3Subjects.put(english, 5);
        database.addStudent(student3, student3Subjects);

        database.printAllStudentWithGrades();

        final Student student4 = new Student("David");
        Map<Subject, Integer> student4Subjects = new HashMap<>();
        student4Subjects.put(math, 2);
        student4Subjects.put(english, 3);
        database.addStudent(student4, student4Subjects);

        final Student student5 = new Student("Charlie");
        Map<Subject, Integer> student5Subjects = new HashMap<>();
        student5Subjects.put(history, 2);
        database.addStudent(student5, student5Subjects);

        database.addStudentToSubject(student4, history);
        database.addStudentToSubject(student5, math);

        database.printAllSubjectsWithStudents();
    }
}

