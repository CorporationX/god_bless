package school.faang.university.student.management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentDatabaseTest {
    private StudentDatabase db;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        db = new StudentDatabase();
        student1 = new Student("Иван Иванов");
        student2 = new Student("Василий Пупкин");
        subject1 = new Subject("Физика");
        subject2 = new Subject("Информатика");
    }

    @Test
    void testAddStudentWithSubjects() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject1, 5);
        subjects.put(subject2, 4);

        db.addStudentWithSubjects(student1, subjects);

        assertTrue(db.getStudentSubjects().containsKey(student1));
        assertEquals(2, db.getStudentSubjects().get(student1).size());
    }

    @Test
    void testAddSubjectToStudent() {
        db.addStudentWithSubjects(student1, new HashMap<>());
        db.addSubjectToStudent(student1, subject1, 5);

        assertEquals(1, db.getStudentSubjects().get(student1).size());
        assertTrue(db.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testRemoveStudent() {
        db.addStudentWithSubjects(student1, new HashMap<>());
        db.removeStudent(student1);

        assertFalse(db.getStudentSubjects().containsKey(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        db.addSubjectWithStudents(subject1, students);

        assertTrue(db.getSubjectStudents().containsKey(subject1));
        assertEquals(2, db.getSubjectStudents().get(subject1).size());
    }

    @Test
    void testAddStudentToSubject() {
        db.addSubjectWithStudents(subject1, new ArrayList<>());
        db.addSubjectWithStudents(subject2, new ArrayList<>());

        db.addStudentToSubject(student1, subject1);

        assertEquals(1, db.getSubjectStudents().get(subject1).size());
        assertTrue(db.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testRemoveStudentFromSubject() {
        db.addSubjectWithStudents(subject1, Arrays.asList(student1, student2));
        db.removeStudentFromSubject(student1, subject1);

        assertEquals(1, db.getSubjectStudents().get(subject1).size());
        assertFalse(db.getSubjectStudents().get(subject1).contains(student1));
    }

}