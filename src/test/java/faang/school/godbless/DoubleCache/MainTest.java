package faang.school.godbless.DoubleCache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    public void setUp() {
        main = new Main();
        main.studentsGrades = new HashMap<>();
        main.studentsBySubject = new HashMap<>();

        student1 = new Student(1, "Alice");
        student2 = new Student(2, "Bob");

        subject1 = new Subject(101, "Math");
        subject2 = new Subject(102, "History");
    }

    @Test
    public void testAddStudent() {
        HashMap<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject1, 85);
        subjects.put(subject2, 90);

        main.addStudent(student1, subjects);

        assertTrue(main.studentsGrades.containsKey(student1));
        assertTrue(main.studentsBySubject.get(subject1).contains(student1));
        assertTrue(main.studentsBySubject.get(subject2).contains(student1));
    }

    @Test
    public void testAddSubject() {
        HashMap<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject1, 85);
        main.addStudent(student1, subjects);

        main.addSubject(student1, subject2, 90);

        assertEquals(90, main.studentsGrades.get(student1).get(subject2).intValue());
        assertTrue(main.studentsBySubject.get(subject2).contains(student1));
    }

    @Test
    public void testRemoveStudent() {
        HashMap<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject1, 85);
        subjects.put(subject2, 90);
        main.addStudent(student1, subjects);

        main.removeStudent(student1);

        assertFalse(main.studentsGrades.containsKey(student1));
        assertFalse(main.studentsBySubject.get(subject1).contains(student1));
        assertFalse(main.studentsBySubject.get(subject2).contains(student1));
    }

    @Test
    public void testPrintAllStats() {
        HashMap<Subject, Integer> subjects1 = new HashMap<>();
        subjects1.put(subject1, 85);
        subjects1.put(subject2, 90);

        HashMap<Subject, Integer> subjects2 = new HashMap<>();
        subjects2.put(subject1, 75);
        subjects2.put(subject2, 80);

        main.addStudent(student1, subjects1);
        main.addStudent(student2, subjects2);

        main.printAllStats();
    }
}