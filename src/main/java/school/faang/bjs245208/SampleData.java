package school.faang.bjs245208;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleData {

    public static void addStudents(StudentDatabase db) {
        new Subject("");

        Map<Subject, Integer> subjectsAndMarks1 = new HashMap<>();
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
    }

    public static void addSubjects(StudentDatabase db) {
        new Student("");

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
    }

    public static void addSubjectToStudent(StudentDatabase db) {
        Student student = db.findStudentByName("Student1");
        Map.Entry<Subject, Integer> subjectAndMark = java.util.Map.entry(new Subject("Physics"), 95);
        db.addStudentSubject(student.getId(), subjectAndMark);
    }

    public static void removeStudent(StudentDatabase db) {
        Student student = db.findStudentByName("Student3");
        if (student == null) {
            System.err.println("Student does not exist!");
            return;
        }
        db.removeStudent(student.getId());
    }

    public static void addStudent(StudentDatabase db) {
        Map<Subject, Integer> subjectsAndMarks15 = new HashMap<>();
        subjectsAndMarks15.put(new Subject("Programming"), 75);
        subjectsAndMarks15.put(new Subject("Theology"), 95);
        db.addStudent("Student15", subjectsAndMarks15);
    }
}