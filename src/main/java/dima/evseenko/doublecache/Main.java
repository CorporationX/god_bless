package dima.evseenko.doublecache;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        addMarks(studentService);
        studentService.printStudentMarks();

        studentService.deleteSubjectFromMarks(new Student(1L, "Dima"), new Subject(1L, "Math"));
        studentService.printStudentMarks();

        studentService.deleteStudentFromMarks(new Student(1L, "Dima"));
        studentService.printStudentMarks();

        addSubjectStudents(studentService);
        studentService.printSubjectStudents();
    }

    private static void addSubjectStudents(StudentService studentService) {
        studentService.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Scott"),
                new Student(3L, "Bob"),
                new Student(4L, "Jack")
        ));

        studentService.addSubjectStudents(new Subject(2L, "Programming"), List.of(
                new Student(2L, "Scott"),
                new Student(4L, "Jack")
        ));

        studentService.addSubjectStudents(new Subject(2L, "Programming"), List.of(
                new Student(3L, "Bob")
        ));

        studentService.deleteStudentFromSubject(new Subject(2L, "Programming"), new Student(4L, "Jack"));
    }

    private static void addMarks(StudentService studentService) {
        Student student = new Student(1L, "Dima");

        studentService.addStudentMark(student, new Subject(1L, "Math"), 5);
        studentService.addStudentMark(student, new Subject(2L, "Programming"), 5);
        studentService.addStudentMarks(student, Map.of(
                        new Subject(3L, "Physics"), 3,
                        new Subject(4L, "Music"), 4
                )
        );
    }
}
