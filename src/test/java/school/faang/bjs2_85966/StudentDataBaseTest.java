package school.faang.bjs2_85966;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentDataBaseTest {
    private StudentDatabase db;
    private Student ivan;
    private Student petr;
    private Subject math;
    private Subject physics;

    @BeforeEach
    void setup() {
        db = new StudentDatabase();
        ivan = new Student("Иван");
        petr = new Student("Пётр");
        math = new Subject("Математика");
        physics = new Subject("Физика");
    }

    private String captureStdOut(Runnable action) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return out.toString();
    }

    @Test
    void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(math, 5);
        db.addStudentWithGrades(ivan, grades);
        String out = captureStdOut(() -> db.printAllStudents());
        assertTrue(out.contains("Иван"));
        assertTrue(out.contains("Математика"));
        assertTrue(out.contains("5"));
    }

    @Test
    void testAddSubjectForStudent() {
        db.addSubjectForStudent(ivan, physics, 4);
        String out = captureStdOut(() -> db.printAllStudents());
        assertTrue(out.contains("Иван"));
        assertTrue(out.contains("Физика"));
        assertTrue(out.contains("4"));
    }

    @Test
    void testRemoveStudent() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(math, 5);
        db.addStudentWithGrades(ivan, grades);
        db.removeStudent(ivan);
        String out = captureStdOut(() -> db.printAllStudents());
        assertFalse(out.contains("Иван"), "После удаления имя студента не должно печататься");
    }

    @Test
    void testAddSubjectWithStudents() {
        List<Student> list = Arrays.asList(ivan, petr);
        db.addSubjectWithStudents(math, list);
        String out = captureStdOut(() -> db.printAllSubject());
        assertTrue(out.contains("Математика"));
        assertTrue(out.contains("Иван"));
        assertTrue(out.contains("Пётр"));
    }

    @Test
    void testAddStudentToSubject() {
        db.addStudentToSubject(ivan, math);
        String out = captureStdOut(() -> db.printAllSubject());
        assertTrue(out.contains("Математика"));
        assertTrue(out.contains("Иван"));
    }

    @Test
    void testRemoveStudentFromSubject() {
        db.addStudentToSubject(ivan, math);
        db.removeStudentFromSubject(ivan, math);
        String out = captureStdOut(() -> db.printAllSubject());
        assertFalse(out.contains("Иван"), "Студента не должно быть после removeStudentFromSubject");
    }

    @Test
    void testPrintAllSubject() {
        db.addStudentToSubject(ivan, math);
        db.addStudentToSubject(petr, physics);
        String out = captureStdOut(() -> db.printAllSubject());
        assertTrue(out.contains("Математика"));
        assertTrue(out.contains("Физика"));
        assertTrue(out.contains("Иван"));
        assertTrue(out.contains("Пётр"));
    }
}
