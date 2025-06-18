package school.faang.sprint1_2.bjs2_79667;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Subject> subjects = Map.of(
                "Math", new Subject("Math"),
                "Literature", new Subject("Literature"),
                "Other", new Subject("Other")
        );
        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addStudentToSubject(new Student("student 1"), subjects.get("Math"));
        studentDatabase.addStudentToSubject(new Student("student 2"), subjects.get("Math"));
        studentDatabase.addStudentToSubject(new Student("student 3"), subjects.get("Math"));
        studentDatabase.addStudentWithGrades(new Student("student 1"), Map.of(
                subjects.get("Literature"), 5,
                new Subject("Other"), 3
        ));
        studentDatabase.addStudentToSubject(new Student("student 4"), subjects.get("Math"));
        studentDatabase.addSubjectWithStudents(new Subject("Other"), Set.of(
                new Student("student 5")
        ));

        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudent(new Student("student 5"));
        studentDatabase.removeStudent(new Student("student 123"));
        studentDatabase.removeStudentFromSubject(new Student("student 123"), new Subject("Math"));
        studentDatabase.removeStudentFromSubject(new Student("student 1"), new Subject("Math"));
        studentDatabase.addSubjectForStudent(new Student("student 2"), subjects.get("Literature"), 4);

        studentDatabase.printAllSubjectsWithStudents();
    }
}
