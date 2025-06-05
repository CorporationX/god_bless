package school.faang.bjs2_79699;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentDatabase {

    private StudentDatabase db;
    private Student student;
    private Subject math;
    private Subject history;

    @BeforeEach
    void setup() {
        db = new StudentDatabase();
        student = new Student("John");
        math = new Subject("Math");
        history = new Subject("History");
    }

    @Test
    void testAddStudentWithSubjects() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(math, 5);
        grades.put(history, 4);

        db.addStudentWithSubjects(student, grades);

        assertTrue(db.studentSubjects.containsKey(student));
        assertEquals(2, db.studentSubjects.get(student).size());
        assertTrue(db.subjectStudents.containsKey(math));
        assertTrue(db.subjectStudents.get(math).contains(student));
    }

    @Test
    void testAddSubjectForStudent() {
        db.addStudentWithSubjects(student, Map.of(math, 5));
        db.addSubjectForStudent(student, history, 3);

        assertTrue(db.studentSubjects.get(student).containsKey(history));
        assertEquals(3, db.studentSubjects.get(student).get(history));
        assertTrue(db.subjectStudents.get(history).contains(student));
    }

    @Test
    void testRemoveStudent() {
        db.addStudentWithSubjects(student, Map.of(math, 5, history, 4));
        db.removeStudent(student);

        assertFalse(db.studentSubjects.containsKey(student));
        assertFalse(db.subjectStudents.getOrDefault(math, List.of()).contains(student));
        assertFalse(db.subjectStudents.getOrDefault(history, List.of()).contains(student));
    }

    @Test
    void testAddSubjectWithStudents() {
        db.addStudentWithSubjects(student, Map.of(math, 5));
        List<Student> students = new ArrayList<>();
        students.add(student);

        db.addSubjectWithStudents(history, students);

        assertTrue(db.subjectStudents.containsKey(history));
        assertTrue(db.subjectStudents.get(history).contains(student));
        assertTrue(db.studentSubjects.get(student).containsKey(history));
    }

    @Test
    void testAddStudentToSubject() {
        db.addStudentWithSubjects(student, Map.of(math, 5));
        db.addStudentToSubject(history, student);

        assertTrue(db.subjectStudents.get(history).contains(student));
        assertTrue(db.studentSubjects.get(student).containsKey(history));
    }

    @Test
    void testRemoveStudentFromSubject() {
        db.addStudentWithSubjects(student, Map.of(math, 5, history, 4));
        db.removeStudentFromSubject(math, student);

        assertFalse(db.studentSubjects.getOrDefault(student, Collections.emptyMap()).containsKey(math));
        assertFalse(db.subjectStudents.getOrDefault(math, Collections.emptyList()).contains(student));
    }

    @Test
    void testPrintAllStudentsAndGrades_NoCrash() {
        db.printAllStudentsAndGrades();
    }

    @Test
    void testPrintAllSubjectsAndStudents_NoCrash() {
        db.printAllSubjectsAndStudents();
    }
}
