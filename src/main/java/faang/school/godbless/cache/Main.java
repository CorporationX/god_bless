package faang.school.godbless.cache;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var service = new StudentRecordService();
        service.printStudentGrades();

        service.addSubjectsForStudent(new Student(1L, "Ivan"), Map.of(
                        new Subject(1L, "Math"), 4,
                        new Subject(2L, "Phys"), 3
                )
        );
        service.printStudentGrades();

        service.addSubjectForStudent(new Student(1L, "Ivan"), new Subject(2L, "Phys"), 4);
        service.printStudentGrades();

        service.addSubjectForStudent(new Student(2L, "Victor"), new Subject(2L, "Phys"), 3);
        service.printStudentGrades();

        service.removeStudentGrades(new Student(1L, "Ivan"));
        service.printStudentGrades();

        service.removeStudentGrades(new Student(2L, "Victor2"));
        service.printStudentGrades();


        service.addStudentsForSubject(new Subject(3L, "Bio"), List.of(
                        new Student(3L, "Ben"),
                        new Student(4L, "Alex"),
                        new Student(5L, "Bob")
                )
        );
        service.printSubjects();

        service.addStudentForSubject(new Subject(3L, "Bio"), new Student(1L, "Ivan"));
        service.printSubjects();

        service.addStudentForSubject(new Subject(1L, "Math"), new Student(1L, "Ivan"));
        service.printSubjects();

        service.removeStudentFromSubject(new Subject(3L, "Bio"), new Student(3L, "Ben"));
        service.printSubjects();

        service.removeStudentFromSubject(new Subject(3L, "Bio"), new Student(5L, "Bob2"));
        service.printSubjects();
    }
}
