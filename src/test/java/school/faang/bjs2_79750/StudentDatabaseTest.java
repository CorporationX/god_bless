package school.faang.bjs2_79750;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class StudentDatabaseTest {
    StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeEach
    void setUp() {
        Map<Subject, Integer> subjectsWithGrades = new HashMap<>();
        subjectsWithGrades.put(new Subject("Math"), 5);
        subjectsWithGrades.put(new Subject("English"), 4);
        subjectsWithGrades.put(new Subject("History"), 3);

        Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
        Student student = new Student("John");
        studentSubjects.put(student, subjectsWithGrades);

        Map<Subject, List<Student>> subjectStudents = new HashMap<>();
        subjectStudents.put(new Subject("Math"), new ArrayList<>(List.of(student)));
        subjectStudents.put(new Subject("English"), new ArrayList<>(List.of(student)));
        subjectStudents.put(new Subject("History"), new ArrayList<>(List.of(student)));

        studentDatabase.setStudentSubjects(studentSubjects);
        studentDatabase.setSubjectStudents(subjectStudents);

    }

    @Test
    void testAddStudentAndSubjectsWithGrades() {
        //precondition
        Student student = new Student("Mercy");
        Map<Subject, Integer> subjectsWithGrades = new HashMap<>(Map.of(
                new Subject("Math"), 3,
                new Subject("English"), 5,
                new Subject("History"), 4,
                new Subject("Science"), 5));

        //action
        studentDatabase.addStudentAndSubjectsWithGrades(student, subjectsWithGrades);

        //assertions
        assertEquals(2, studentDatabase.getStudentSubjects().size());
        assertTrue(studentDatabase.getStudentSubjects().containsKey(student));
        assertEquals(subjectsWithGrades, studentDatabase.getStudentSubjects().get(student));

    }

    @Test
    void testAddSubjectWithGrade() {
        //precondition
        Student student = new Student("Harry");
        Subject subject = new Subject("History");
        Integer grade = 5;

        //action
        studentDatabase.addSubjectWithGrade(student, subject, grade);

        //assertions
        assertEquals(grade, studentDatabase.getStudentSubjects().get(student).get(subject));
        assertEquals(student, studentDatabase.getSubjectStudents().get(subject).get(1));

    }

    @Test
    void testRemoveStudent() {
        //precondition
        Student student = new Student("John");
        Subject subject = new Subject("History");

        //action
        studentDatabase.removeStudent(student);

        //assertions
        assertFalse(studentDatabase.getStudentSubjects().containsKey(student));
        assertFalse(studentDatabase.getSubjectStudents().get(subject).contains(student));
    }

    @Test
    void testAddSubjectWithStudents() {
        //precondition
        Student student1 = new Student("Kevin");
        Student student2 = new Student("James");
        List<Student> students = new ArrayList<>(List.of(student1, student2));
        Subject subject = new Subject("Science");

        //action
        studentDatabase.addSubjectWithStudents(subject, students);

        //assertions
        assertNull(studentDatabase.getStudentSubjects().get(student1).get(subject));
        assertEquals(2, studentDatabase.getSubjectStudents().get(subject).size());
        assertEquals(student1, studentDatabase.getSubjectStudents().get(subject).get(0));
        assertEquals(student2, studentDatabase.getSubjectStudents().get(subject).get(1));

    }

    @Test
    void testAddStudentToSubject() {
        //precondition
        Student student = new Student("James");
        Subject subject = new Subject("Science");

        //action
        studentDatabase.addStudentToSubject(student, subject);

        //assertions
        assertNull(studentDatabase.getStudentSubjects().get(student).get(subject));
        assertEquals(1, studentDatabase.getSubjectStudents().get(subject).size());
        assertEquals(student, studentDatabase.getSubjectStudents().get(subject).get(0));
    }

    @Test
    void testRemoveStudentFromSubject() {
        //precondition
        Student student = new Student("John");
        Subject subject = new Subject("English");

        //action
        studentDatabase.removeStudentFromSubject(student, subject);

        //assertions
        assertNull(studentDatabase.getStudentSubjects().get(student).get(subject));
        assertEquals(0, studentDatabase.getSubjectStudents().get(subject).size());

    }
}
