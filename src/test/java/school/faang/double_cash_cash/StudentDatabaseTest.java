package school.faang.double_cash_cash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDatabaseTest {
    private StudentDatabase db;

    @BeforeEach
    public void setUp() {
        db = new StudentDatabase();
        Student student = new Student("Harry");
        Subject subject = new Subject("Art");
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject, 100);
        db.addStudentWithSubjects(student, subjects);
    }

    @Test
    public void testAddStudentWithSubject() {
        Student student = new Student("Alice");
        Subject math = new Subject("Math");

        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 95);

        db.addStudentWithSubjects(student, subjects);

        assertEquals("Alice", db.getSubjectStudents().get(math).get(0).getName());
        assertEquals(95, db.getStudentSubjects().get(student).get(math));
        db.printAllStudents();
    }

    @Test
    public void testAddSubjectForStudent() {
        Student student = new Student("Harry");
        Subject alchemy = new Subject("Alchemy");

        db.addSubjectForStudent(student, alchemy, 98);

        assertEquals("Harry", db.getSubjectStudents().get(alchemy).get(0).getName());
        assertEquals(98, db.getStudentSubjects().get(student).get(alchemy));
        db.printAllStudents();
    }
}
