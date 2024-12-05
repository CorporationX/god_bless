package school.faang.sprint_1.task_45230;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {

    private StudentDatabase studentDatabase;

    private Student student1;
    private Student student2;
    private Subject subjectMath;
    private Subject subjectEnglish;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();

        student1 = new Student(1, "Alice");
        student2 = new Student(2, "Bob");

        subjectMath = new Subject(1, "Math");
        subjectEnglish = new Subject(2, "English");
    }

    @Test
    void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subjectMath, 90);
        grades.put(subjectEnglish, 85);

        studentDatabase.addStudentWithGrades(student1, grades);

        assertEquals(grades, studentDatabase.getStudentsGrades().get(student1));
        assertTrue(studentDatabase.getStudentsLearningSubjects().get(subjectMath).contains(student1));
        assertTrue(studentDatabase.getStudentsLearningSubjects().get(subjectEnglish).contains(student1));
    }

    @Test
    void testAddSubjectForStudent() {
        studentDatabase.addStudentWithGrades(student1, new HashMap<>());

        studentDatabase.addSubjectForStudent(student1, subjectMath, 95);

        assertEquals(95, studentDatabase.getStudentsGrades().get(student1).get(subjectMath));
        assertTrue(studentDatabase.getStudentsLearningSubjects().get(subjectMath).contains(student1));
    }

    @Test
    void testRemoveStudents() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subjectMath, 90);
        grades.put(subjectEnglish, 85);

        studentDatabase.addStudentWithGrades(student1, grades);
        studentDatabase.addStudentWithGrades(student2, grades);

        studentDatabase.removeStudent(student1);

        assertFalse(studentDatabase.getStudentsGrades().containsKey(student1));
        assertFalse(studentDatabase.getStudentsLearningSubjects().get(subjectMath).contains(student1));
        assertFalse(studentDatabase.getStudentsLearningSubjects().get(subjectEnglish).contains(student1));
    }

    @Test
    void testRemoveStudentWithLastStudent() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subjectMath, 90);
        grades.put(subjectEnglish, 85);

        studentDatabase.addStudentWithGrades(student1, grades);

        studentDatabase.removeStudent(student1);

        assertFalse(studentDatabase.getStudentsGrades().containsKey(student1));
        assertFalse(studentDatabase.getStudentsLearningSubjects().containsKey(subjectMath));
        assertFalse(studentDatabase.getStudentsLearningSubjects().containsKey(subjectEnglish));
    }

    @Test
    void testAddSubjectAndStudentsLearningIt() {
        Map<Student, Integer> studentsGrades = new HashMap<>();
        var student1Grade = 90;
        var student2Grade = 85;
        studentsGrades.put(student1, student1Grade);
        studentsGrades.put(student2, student2Grade);

        studentDatabase.addSubjectAndStudentsLearningIt(subjectEnglish, studentsGrades);

        assertEquals(student1Grade, studentDatabase.getStudentsGrades().get(student1).get(subjectEnglish));
        assertEquals(student2Grade, studentDatabase.getStudentsGrades().get(student2).get(subjectEnglish));
        assertTrue(studentDatabase.getStudentsLearningSubjects().get(subjectEnglish).contains(student1));
        assertTrue(studentDatabase.getStudentsLearningSubjects().get(subjectEnglish).contains(student2));
    }

    @Test
    void testAddStudentForSubject() {
        Map<Subject, Integer> student1Grades = new HashMap<>();
        student1Grades.put(subjectMath, 90);
        Map<Subject, Integer> student2Grades = new HashMap<>();
        student2Grades.put(subjectMath, 85);
        studentDatabase.addStudentWithGrades(student1, student1Grades);

        studentDatabase.addStudentForSubject(student2, subjectMath, 85);

        assertEquals(student2Grades, studentDatabase.getStudentsGrades().get(student2));
        assertTrue(studentDatabase.getStudentsLearningSubjects().get(subjectMath).contains(student2));
    }

    @Test
    void testAddStudentForSubjectWithNonExistSubject() {
        assertThrows(
                NoSuchElementException.class,
                () -> studentDatabase.addStudentForSubject(student2, subjectMath, 85)
        );
    }

    @Test
    void testRemoveStudentsFromSubject() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subjectMath, 90);

        studentDatabase.addStudentWithGrades(student1, grades);
        studentDatabase.addStudentWithGrades(student2, grades);

        studentDatabase.removeStudentFromSubject(student1, subjectMath);

        assertFalse(studentDatabase.getStudentsGrades().get(student1).containsKey(subjectMath));
        assertFalse(studentDatabase.getStudentsLearningSubjects().get(subjectMath).contains(student1));
    }

    @Test
    void testRemoveStudentsFromSubjectIfStudentGratesNonExist() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subjectMath, 90);

        studentDatabase.addStudentWithGrades(student2, grades);

        assertThrows(
                NoSuchElementException.class,
                () -> studentDatabase.removeStudentFromSubject(student1, subjectMath)
        );
    }
}
