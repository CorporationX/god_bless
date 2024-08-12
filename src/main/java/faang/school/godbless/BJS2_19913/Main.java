package faang.school.godbless.BJS2_19913;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AcademicRecordService service  = new AcademicRecordService();

        service.putStudentWithGrades(new Student(10, "Robert"), new HashMap<>(Map.of(
                new Subject(1, "Russian language"), 5,
                new Subject(2, "English language"), 4
        )));
        service.putStudentWithGrades(new Student(20, "Mikhail"), new HashMap<>(Map.of(
                new Subject(1, "Russian language"), 4,
                new Subject(2, "English language"), 5,
                new Subject(3, "Java"), 5
        )));
        service.putStudentWithGrades(new Student(30, "Anna"), new HashMap<>(Map.of(
                new Subject(4, "Math"), 3,
                new Subject(5, "Python"), 5
        )));
        service.putStudentWithGrades(new Student(30, "Anna"), new HashMap<>(Map.of(
                new Subject(3, "Java"), 5
        )));

        service.printStudentGrades();
        service.printStudentsSubjects();
        System.out.println();

        System.out.println(service.putSubjectWithStudentAndGrade(new Subject(3, "Java"), new Student(10, "Vlad"), 4));
        System.out.println(service.putSubjectWithStudentAndGrade(new Subject(3, "Java"), new Student(10, "Robert"), 4));
        service.printStudentGrades();
        service.printStudentsSubjects();
        System.out.println();

        service.removeStudent(new Student(10, "Robert"));
        service.printStudentGrades();
        service.printStudentsSubjects();
        System.out.println();

        service.putSubjectWithStudents(new Subject(6, "Kotlin"),
                List.of(new Student(20, "Mikhail"), new Student(10, "Robert")));
        service.printStudentsSubjects();
        System.out.println();

        System.out.println(service.putStudentWithSubject(new Student(20, "Mikail"), new Subject(5, "Python")));
        System.out.println(service.putStudentWithSubject(new Student(20, "Mikail"), new Subject(999, "C++")));
        service.printStudentsSubjects();
        System.out.println();

        service.removeStudentWithSubject(new Student(20, "Mikhail"), new Subject(5, "Python"));
        service.printStudentsSubjects();
    }
}
