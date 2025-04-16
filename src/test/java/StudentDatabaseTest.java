import doublecache.Student;
import doublecache.StudentDatabase;
import doublecache.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {
    private StudentDatabase db;
    private Student alice;
    private Student bob;
    private Subject math;
    private Subject physics;

    @BeforeEach
    void setUp() {
        db = new StudentDatabase();
        db.studentSubjects = new HashMap<>();
        db.subjectStudents = new HashMap<>();

        alice = new Student("Alice");
        bob = new Student("Bob");

        math = new Subject("Math");
        physics = new Subject("Physics");
    }

    @Test
    void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(math, 90);
        grades.put(physics, 85);

        db.addStudentWithGrades(alice, grades);

        assertEquals(2, db.studentSubjects.get(alice).size());
        assertTrue(db.subjectStudents.get(math).contains(alice));
        assertTrue(db.subjectStudents.get(physics).contains(alice));
    }

    @Test
    void testAddSubjectForStudent() {
        db.addSubjectForStudent(bob, math, 78);
        assertEquals(78, db.studentSubjects.get(bob).get(math));
        assertTrue(db.subjectStudents.get(math).contains(bob));
    }

    @Test
    void testRemoveStudent() {
        db.addSubjectForStudent(bob, math, 70);
        db.addSubjectForStudent(bob, physics, 60);

        db.removeStudent(bob);

        List<Student> mathStudents = db.subjectStudents.get(math);
        if (mathStudents != null) {
            assertFalse(mathStudents.contains(bob));
        }

        List<Student> physicsStudents = db.subjectStudents.get(physics);
        if (physicsStudents != null) {
            assertFalse(physicsStudents.contains(bob));
        }
    }

    @Test
    void testAddSubjectWithStudents() {
        List<Student> students = Arrays.asList(alice, bob);
        db.addSubjectWithStudents(physics, students);

        assertTrue(db.subjectStudents.get(physics).contains(alice));
        assertTrue(db.subjectStudents.get(physics).contains(bob));
        assertTrue(db.studentSubjects.get(alice).containsKey(physics));
        assertTrue(db.studentSubjects.get(bob).containsKey(physics));
    }

    @Test
    void testRemoveStudentFromSubject() {
        db.addSubjectForStudent(alice, math, 95);
        db.removeStudentFromSubject(alice, math);

        assertTrue(db.subjectStudents.get(math) == null || !db.subjectStudents.get(math).contains(alice));
        assertTrue(db.studentSubjects.get(alice) == null || !db.studentSubjects.get(alice).containsKey(math));
    }
}

