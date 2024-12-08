import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs245254.model.Student;
import school.faang.bjs245254.model.Subject;
import school.faang.bjs245254.repository.StudentDatabase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDataBaseTest {

    private final StudentDatabase studentDatabase = new StudentDatabase();
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    public void setUp() {
        studentDatabase.clearAll();
        student1 = new Student(1, "John Doe");
        student2 = new Student(2, "Jane Smith");
        subject1 = new Subject(3, "Math");
        subject2 = new Subject(4, "Science");
    }

    @Test
    public void test_addStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        grades.put(subject2, 85);

        studentDatabase.addStudentWithGrades(student1, grades);

        assertEquals(
                grades,
                studentDatabase.getStudentsGrades().get(student1)
        );
    }

    @Test
    public void test_addSubjectForStudent() {
        studentDatabase.addSubjectForStudent(student2, subject2, 5);
        assertTrue(studentDatabase.getStudentsGrades().get(student2).containsKey(subject2));
    }

    @Test
    public void test_deleteStudent() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        grades.put(subject2, 85);

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        studentDatabase.addStudentWithGrades(student1, grades);
        studentDatabase.addStudentWithGrades(student2, grades);
        studentDatabase.addSubjectWithStudents(subject1, students);
        studentDatabase.addSubjectWithStudents(subject2, students);

        studentDatabase.deleteStudent(student2);

        assertFalse(studentDatabase.getStudentsGrades().containsKey(student2));
        assertFalse(studentDatabase.getSubjectsStudent().get(subject1).contains(student2));
        assertFalse(studentDatabase.getSubjectsStudent().get(subject2).contains(student2));
    }

    @Test
    public void test_addSubjectWithStudents() {
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        studentDatabase.addSubjectWithStudents(subject1, students);

        assertTrue(studentDatabase.getSubjectsStudent().get(subject1).containsAll(students));
    }

    @Test
    public void test_addStudentForSubject() {
        studentDatabase.addStudentForSubject(subject1, student2);
        assertTrue(studentDatabase.getSubjectsStudent().get(subject1).contains(student2));
    }

    @Test
    public void test_deleteStudentFromSubject() {
        studentDatabase.addStudentForSubject(subject1, student2);
        studentDatabase.deleteStudentFromSubject(subject1, student2);
        assertFalse(studentDatabase.getSubjectsStudent().get(subject1).contains(student2));
    }

}
