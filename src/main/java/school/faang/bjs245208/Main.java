package school.faang.bjs245208;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();
        Map<Subject, Integer> subjectsAndMarks1 = new HashMap<>();

        //Students
        subjectsAndMarks1.put(new Subject("Math"), 85);
        subjectsAndMarks1.put(new Subject("Science"), 90);
        db.addStudent("Student1", subjectsAndMarks1);

        Map<Subject, Integer> subjectsAndMarks2 = new HashMap<>();
        subjectsAndMarks2.put(new Subject("History"), 75);
        subjectsAndMarks2.put(new Subject("Geography"), 80);
        db.addStudent("Student2", subjectsAndMarks2);

        Map<Subject, Integer> subjectsAndMarks3 = new HashMap<>();
        subjectsAndMarks3.put(new Subject("English"), 75);
        subjectsAndMarks3.put(new Subject("Art"), 95);
        db.addStudent("Student3", subjectsAndMarks3);
        //Students

        db.printAllStudentsWithScores();
        System.out.println();

        //Subjects
        List<Student> studentsOnMath = List.of(
                new Student("Student1"),
                new Student("Student2")
        );
        db.addSubject("Math", studentsOnMath);

        List<Student> studentsOnScience = List.of(
                new Student("Student1"),
                new Student("Student3")
        );
        db.addSubject("Science", studentsOnScience);

        List<Student> studentsOnHistory = List.of(
                new Student("Student2")
        );
        db.addSubject("History", studentsOnHistory);

        List<Student> studentsOnGeography = List.of(
                new Student("Student2")
        );
        db.addSubject("Geography", studentsOnGeography);

        List<Student> studentsOnEnglish = List.of(
                new Student("Student3")
        );
        db.addSubject("English", studentsOnEnglish);

        List<Student> studentsOnArt = List.of(
                new Student("Student3")
        );
        db.addSubject("Art", studentsOnArt);
        //Subjects

        db.printAllSubjectsWithStudents();
        System.out.println();

        Map.Entry<Subject, Integer> subjectAndMark = Map.entry(new Subject("Physics"), 95);
        db.addStudentSubject("Student1", null, subjectAndMark);

        db.removeStudent("Student3", null);

        db.printAllStudentsWithScores();
        System.out.println();

    }
}
