package dima.evseenko.doublecache;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        addMarks(university);
        university.printStudentMarks();

        university.deleteSubjectFromMarks(new Student(1L, "Dima"), new Subject(1L, "Math"));
        university.printStudentMarks();

        university.deleteStudentFromMarks(new Student(1L, "Dima"));
        university.printStudentMarks();

        addSubjectStudents(university);
        university.printSubjectStudents();
    }

    private static void addSubjectStudents(University university) {
        university.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Scott"),
                new Student(3L, "Bob"),
                new Student(4L, "Jack")
        ));

        university.addSubjectStudents(new Subject(2L, "Programming"), List.of(
                new Student(2L, "Scott"),
                new Student(4L, "Jack")
        ));

        university.addSubjectStudents(new Subject(2L, "Programming"), List.of(
                new Student(3L, "Bob")
        ));

        university.deleteStudentFromSubject(new Subject(2L, "Programming"), new Student(4L, "Jack"));
    }

    private static void addMarks(University university) {
        Student student = new Student(1L, "Dima");

        university.addStudentMark(student, new Subject(1L, "Math"), 5);
        university.addStudentMark(student, new Subject(2L, "Programming"), 5);
        university.addStudentMarks(student, Map.of(
                        new Subject(3L, "Physics"), 3,
                        new Subject(4L, "Music"), 4
                )
        );
    }
}
