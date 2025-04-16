package school.faang.bjs2_69888;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StudentDatabaseTest {
    private static final StudentDatabase STUDENTS_DATABASE = new StudentDatabase();
    private static Student studentNewton = new Student("Newton");
    private static Student studentDarvin = new Student("Darvin");
    private static Student studentSemikhatov = new Student("Semikhatov");
    private static Subject subjectPhisics = new Subject("Phisics");
    private static Subject subjectMath = new Subject("Math");
    private static Subject subjectGeography = new Subject("Geography");


    @BeforeEach
    void setUp() {
        STUDENTS_DATABASE.addStudent(studentNewton, new HashMap<>() { {
                put(subjectPhisics, 5);
                put(subjectMath, 3);
            }
        });
        STUDENTS_DATABASE.addStudent(studentDarvin, new HashMap<>() { {
                put(subjectPhisics, 2);
            }
        });
    }

    @Test
    public void testAddStudent() {
        // arrange
        int expectedNumberOfSubjects = 3;
        int expectedNumberOfStudents = 3;

        // act
        STUDENTS_DATABASE.addStudent(studentSemikhatov, new HashMap<>() { {
                put(subjectGeography, 3);
            }
        });

        // assert
        Assertions.assertEquals(expectedNumberOfSubjects, STUDENTS_DATABASE.getSubjectStudents().size());
        Assertions.assertEquals(expectedNumberOfStudents, STUDENTS_DATABASE.getStudentSubjects().size());
    }

    @Test
    public void testAddSubjectForStudent() {
        // arrange
        int expectedNumberOfSubjects = 3;
        int expectedNumberOfStudents = 2;
        // act
        STUDENTS_DATABASE.addSubjectForStudent(studentDarvin, subjectGeography, 3);
        // assert
        Assertions.assertEquals(expectedNumberOfSubjects, STUDENTS_DATABASE.getSubjectStudents().size());
        Assertions.assertEquals(expectedNumberOfStudents, STUDENTS_DATABASE.getStudentSubjects().size());
    }

    @Test
    public void testRemoveStudent() {
        // arrange
        int expectedNumberOfSubjects = 3;
        int expectedNumberOfStudents = 2;
        // act
        STUDENTS_DATABASE.removeStudent(studentNewton);
        // assert
        Assertions.assertEquals(expectedNumberOfSubjects, STUDENTS_DATABASE.getSubjectStudents().size());
        Assertions.assertEquals(expectedNumberOfStudents, STUDENTS_DATABASE.getStudentSubjects().size());
    }

    @Test
    public void testAddSubjectWithStudents() {
        // arrange
        int expectedNumberOfSubjects = 3;
        int expectedNumberOfStudents = 3;
        // act
        STUDENTS_DATABASE.addSubjectWithStudents(subjectPhisics, List.of(studentSemikhatov, studentNewton));
        // assert
        Assertions.assertEquals(expectedNumberOfSubjects, STUDENTS_DATABASE.getSubjectStudents().size());
        Assertions.assertEquals(expectedNumberOfStudents, STUDENTS_DATABASE.getStudentSubjects().size());
    }

    @Test
    public void testAddStudentToSubject() {
        // arrange
        int expectedNumberOfSubjects = 3;
        int expectedNumberOfStudents = 3;
        // act
        STUDENTS_DATABASE.addStudentToSubject(studentNewton, subjectMath);
        // assert
        Assertions.assertEquals(expectedNumberOfSubjects, STUDENTS_DATABASE.getSubjectStudents().size());
        Assertions.assertEquals(expectedNumberOfStudents, STUDENTS_DATABASE.getStudentSubjects().size());
    }

    @Test
    public void testRemoveStudentFromSubject() {
        // arrange
        int expectedNumberOfSubjects = 3;
        int expectedNumberOfStudents = 1;
        // act
        STUDENTS_DATABASE.removeStudentFromSubject(studentDarvin, subjectPhisics);
        // assert
        Assertions.assertEquals(expectedNumberOfSubjects, STUDENTS_DATABASE.getSubjectStudents().size());
        Assertions.assertEquals(expectedNumberOfStudents, STUDENTS_DATABASE.getStudentSubjects().size());
    }
}
