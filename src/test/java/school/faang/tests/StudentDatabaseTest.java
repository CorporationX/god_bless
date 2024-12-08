package school.faang.tests;

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
        studentsDatabase.addStudentsWithGrades("Egor", gradesPerSubjects);
        studentsDatabase.addStudentsWithGrades("Maria", gradesPerSubjects);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addStudentsWithGrades("", gradesPerSubjects));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addStudentsWithGrades("Norik", new HashMap<>(Map.of())));

        studentsDatabase.addStudentsWithGrades("Gosha", gradesPerSubjects);
    }

    @Test
    void addNewSubjectToStudent() {
        studentsDatabase.addStudentsWithGrades("Egor", gradesPerSubjects);
        studentsDatabase.addNewSubjectToStudent("Russian", 4, "Egor");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addNewSubjectToStudent("Russian", 4, ""));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addNewSubjectToStudent("Russian", -1000, "Egor"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addNewSubjectToStudent("", 4, "Egor"));
    }


    @Test
    void deleteStudentsWithSubjects() {
        studentsDatabase.addStudentsWithGrades("Love", gradesPerSubjects);
        studentsDatabase.deleteStudentsWithSubjects("Love");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.deleteStudentsWithSubjects("Unknown"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.deleteStudentsWithSubjects(""));
    }

    @Test
    void addSubjectWithListOfStudent() {
        studentsDatabase.addSubjectWithListOfStudent("PE",
                new ArrayList<>(List.of(new Student(5, "Gosha"), new Student(6, "Maria"))));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addSubjectWithListOfStudent("PE", new ArrayList<>(List.of())));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addSubjectWithListOfStudent("", new ArrayList<>(
                        List.of(new Student(5, "Gosha"), new Student(6, "Maria")))));
    }

    @Test
    void addStudentToExistingSubject() {
        studentsDatabase.addStudentsWithGrades("Egor", gradesPerSubjects);
        studentsDatabase.addStudentToExistingSubject("Egor", "English", 4);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addStudentToExistingSubject("EgorWho?", "Math", 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addStudentToExistingSubject("Egor", "", 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addStudentToExistingSubject("", "Math", 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.addStudentToExistingSubject("EgorWho?", "Math", -100));
    }

    @Test
    void deleteStudentFromSubject() {
        studentsDatabase.addStudentsWithGrades("Maria", gradesPerSubjects);
        studentsDatabase.addStudentToExistingSubject("Maria", "Math", 5);
        studentsDatabase.deleteStudentFromSubject("Maria", "Math");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.deleteStudentFromSubject("", "Math"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.deleteStudentFromSubject("Maria", ""));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.deleteStudentFromSubject("MariaWho?", "Math"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentsDatabase.deleteStudentFromSubject("Maria", "MathWhat?"));
    }
}
