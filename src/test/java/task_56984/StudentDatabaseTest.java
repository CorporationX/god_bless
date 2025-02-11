package task_56984;

import school.faang.sprint1.task_56984.Student;
import school.faang.sprint1.task_56984.Subject;
import school.faang.sprint1.task_56984.StudentDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        student1 = new Student("Alice");
        student2 = new Student("Bob");
        subject1 = new Subject("Math");
        subject2 = new Subject("Science");
    }

    @Test
    void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        grades.put(subject2, 85);

        studentDatabase.addStudentWithGrades(student1, grades);

        // Проверяем, что студент добавлен с правильными оценками
        assertEquals(90, studentDatabase.getGradeForStudentInSubject(student1, subject1));
        assertEquals(85, studentDatabase.getGradeForStudentInSubject(student1, subject2));
    }

    @Test
    void testAddSubjectForStudent() {
        studentDatabase.addSubjectForStudent(student1, subject1, 95);

        // Проверяем, что предмет добавлен с правильной оценкой
        assertEquals(95, studentDatabase.getGradeForStudentInSubject(student1, subject1));
    }

    @Test
    void testRemoveStudent() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        studentDatabase.addStudentWithGrades(student1, grades);

        studentDatabase.removeStudent(student1);

        // Проверяем, что студент удален
        assertNull(studentDatabase.getGradeForStudentInSubject(student1, subject1));
        assertFalse(studentDatabase.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testPrintAllStudentsWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        studentDatabase.addStudentWithGrades(student1, grades);
        studentDatabase.addStudentWithGrades(student2, Map.of(subject2, 80));

        // Проверяем, что оба студента добавлены
        assertTrue(studentDatabase.getStudentSubjects().containsKey(student1));
        assertTrue(studentDatabase.getStudentSubjects().containsKey(student2));
    }

    @Test
    void testAddSubjectWithStudents() {
        studentDatabase.addSubjectWithStudents(subject1, List.of(student1, student2));

        // Проверяем, что оба студента добавлены к предмету
        assertTrue(studentDatabase.getSubjectStudents().get(subject1).contains(student1));
        assertTrue(studentDatabase.getSubjectStudents().get(subject1).contains(student2));
    }

    @Test
    void testRemoveStudentFromSubject() {
        studentDatabase.addSubjectForStudent(student1, subject1, 90);
        studentDatabase.addSubjectForStudent(student2, subject1, 85);

        studentDatabase.removeStudentFromSubject(student1, subject1);

        // Проверяем, что студент удален из предмета
        assertFalse(studentDatabase.getSubjectStudents().get(subject1).contains(student1));
        assertEquals(85, studentDatabase.getGradeForStudentInSubject(student2, subject1));
    }
}