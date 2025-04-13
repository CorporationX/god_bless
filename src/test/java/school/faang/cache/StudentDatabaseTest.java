package school.faang.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {
    private StudentDatabase database;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    public void setUp() {
        database = new StudentDatabase();
        student1 = new Student("Alex");
        student2 = new Student("Oleg");
        subject1 = new Subject("Физика");
        subject2 = new Subject("Математика");
    }

    @Test
    void testAddNewStudentAndSubjectAWithBall() {
        Map<Subject, Ball> subjects = new HashMap<>();
        subjects.put(subject1, Ball.FOUR);
        subjects.put(subject2, Ball.FIVE);

        database.addNewStudentAndSubjectAWithBall(student1, subjects);

        assertTrue(database.getStudentSubjects().containsKey(student1));
        assertEquals(2, database.getStudentSubjects().get(student1).size());
        assertEquals(student1, database.getSubjectStudents().get(subject1).get(0));
        assertEquals(student1, database.getSubjectStudents().get(subject2).get(0));
    }

    @Test
    void testAddSubjectWithBallForOldStudent() {

        database.addNewStudentAndSubjectAWithBall(student1, new HashMap<>());

        database.addSubjectWithBallForOldStudent(student1, subject1, Ball.FOUR);

        assertEquals(1, database.getStudentSubjects().get(student1).size());
        assertTrue(database.getSubjectStudents().get(subject1).contains(student1));

    }

    @Test
    void removeStudentAndYouSubject() {
        Map<Subject, Ball> subjects = new HashMap<>();
        subjects.put(subject1, Ball.FOUR);
        subjects.put(subject2, Ball.FIVE);
        database.addNewStudentAndSubjectAWithBall(student1,subjects);
        database.addNewStudentAndSubjectAWithBall(student2,subjects);

        database.removeStudentAndYouSubject(student1);

        assertEquals(1, database.getStudentSubjects().size());
        assertEquals(student2, database.getSubjectStudents().get(subject1).get(0));
    }

    @Test
    void addNewSubjectAndStudent() {
        database.addNewStudentAndSubjectAWithBall(student1,Map.of(subject1, Ball.FOUR));

        database.addNewSubjectAndStudent(subject2,new ArrayList<>(List.of(student1,student2)));

        assertTrue(database.getStudentSubjects().get(student1).containsKey(subject2));
        assertTrue(database.getStudentSubjects().get(student2).containsKey(subject2));
        assertTrue(database.getSubjectStudents().containsKey(subject2));
        assertEquals(2, database.getSubjectStudents().size());
    }

    @Test
    void addStudentOfOldSubject() {
    }

    @Test
    void removeStudentFromSubject() {
    }

    @Test
    void printAllSubjectWithStudent() {
    }
}
