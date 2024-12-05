import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_45206.Student;
import school.faang.task_45206.StudentDatabase;
import school.faang.task_45206.Subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {

    private final StudentDatabase studentDatabase = new StudentDatabase();
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    public void setUp() {
        student1 = new Student(1, "John Doe");
        student2 = new Student(2, "Jane Smith");
        subject1 = new Subject(3, "Math");
        subject2 = new Subject(4, "Science");
    }

    @Test
    public void testStudentDatabase_addStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        grades.put(subject2, 85);

        studentDatabase.addStudentWithGrades(student1, grades);

        assertEquals(
                grades,
                studentDatabase
                        .getStudentGrades()
                        .get(student1)
        );
    }

    @Test
    public void testStudentDatabase_addSubjectForStudent() {
        studentDatabase.addStudentWithGrades(student1, new HashMap<>());
        studentDatabase.addSubjectForStudent(student1, subject1, 90);

        assertEquals(
                90,
                studentDatabase
                        .getStudentGrades()
                        .get(student1)
                        .get(subject1)
        );
    }

    @Test
    public void testStudentDatabase_deleteStudent() {
        studentDatabase.addStudentWithGrades(student1, new HashMap<>());
        studentDatabase.deleteStudent(student1);

        assertFalse(
                studentDatabase
                        .getStudentGrades()
                        .containsKey(student1)
        );
    }

    @Test
    public void testStudentDatabase_addSubjectWithStudents() {
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        studentDatabase.addSubjectWithStudents(subject1, students);

        assertEquals(
                students,
                studentDatabase
                        .getSubjectStudents()
                        .get(subject1)
        );
    }

    @Test
    public void testStudentDatabase_addStudentForSubject() {
        studentDatabase.addSubjectWithStudents(subject1, new HashSet<>());
        studentDatabase.addStudentForSubject(subject1, student1);

        assertTrue(
                studentDatabase
                        .getSubjectStudents()
                        .get(subject1)
                        .contains(student1)
        );
    }

    @Test
    public void testStudentDatabase_deleteStudentFromSubject() {
        Set<Student> students = new HashSet<>();
        students.add(student1);
        studentDatabase.addSubjectWithStudents(subject1, students);
        studentDatabase.deleteStudentFromSubject(subject1, student1);

        assertFalse(
                studentDatabase
                        .getSubjectStudents()
                        .get(subject1)
                        .contains(student1)
        );
    }
}