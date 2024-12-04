package sprint1.bjs45228;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_45228.Student;
import school.faang.task_45228.StudentsDatabase;
import school.faang.task_45228.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabaseTest {
    private StudentsDatabase studentsDatabase;
    private static Map<Subject, Integer> gradesPerSubjects;

    @BeforeEach
    void createInstance() {
        studentsDatabase = new StudentsDatabase();
    }

    @BeforeAll
    static void fillMap() {
        Subject math = new Subject(1, "Math");
        Subject english = new Subject(2, "English");
        Subject history = new Subject(3, "History");

        gradesPerSubjects = new HashMap<>(
                Map.of(
                        math, 5,
                        english, 4,
                        history, 5
                )
        );
    }

    @Test
    void addStudentsWithGrades() {
        StudentsDatabase.addStudentsWithGrades("Egor", gradesPerSubjects);
        StudentsDatabase.addStudentsWithGrades("Maria", gradesPerSubjects);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addStudentsWithGrades("", gradesPerSubjects));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addStudentsWithGrades("Norik", new HashMap<>(Map.of())));
    }

    @Test
    void addNewSubjectToStudent() {
        StudentsDatabase.addNewSubjectToStudent(4, "Russian", 3, "Egor");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addNewSubjectToStudent(4, "Russian", 3, ""));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addNewSubjectToStudent(4, "", 3, "Egor"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addNewSubjectToStudent(4, "Russian", -100, "Egor"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addNewSubjectToStudent(-100, "Russian", -100, "Egor"));
    }

    @Test
    void deleteStudentsWithSubjects() {
        StudentsDatabase.deleteStudentsWithSubjects("Love");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.deleteStudentsWithSubjects(""));
    }

    @Test
    void addSubjectWithListOfStudent() {
        StudentsDatabase.addSubjectWithListOfStudent(5, "PE",
                new ArrayList<>(List.of(new Student(5, "Gosha"), new Student(6, "Maria"))));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addSubjectWithListOfStudent(-1000, "PE", new ArrayList<>(
                        List.of(new Student(5, "Gosha"), new Student(6, "Maria")))));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addSubjectWithListOfStudent(5, "PE", new
                        ArrayList<>(List.of())));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addSubjectWithListOfStudent(-1000, "", new ArrayList<>(
                        List.of(new Student(5, "Gosha"), new Student(6, "Maria")))));
    }

    @Test
    void addStudentToExistingSubject() {
        StudentsDatabase.addStudentToExistingSubject("Egor", "Math", 5);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addStudentToExistingSubject("EgorWho?", "Math", 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addStudentToExistingSubject("Egor", "", 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addStudentToExistingSubject("", "Math", 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.addStudentToExistingSubject("EgorWho?", "Math", -100));
    }

    @Test
    void deleteStudentFromSubject() {
        StudentsDatabase.deleteStudentFromSubject("Maria", "Math");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.deleteStudentFromSubject("", "Math"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.deleteStudentFromSubject("Maria", ""));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.deleteStudentFromSubject("MariaWho?", "Math"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StudentsDatabase.deleteStudentFromSubject("Maria", "MathWhat?"));

    }
}
