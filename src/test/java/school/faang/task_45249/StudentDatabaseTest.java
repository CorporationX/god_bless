package school.faang.task_45249;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class StudentDatabaseTest {

    private StudentDatabase studentDatabase;
    private Student alice;
    private Student bob;
    private Subject math;
    private Subject history;
    private Subject science;

    @BeforeEach
    public void setUp() {
        // Создаем базу данных студентов
        studentDatabase = new StudentDatabase();

        // Создаем предметы
        math = new Subject(1, "Математика");
        history = new Subject(2, "История");
        science = new Subject(3, "Физика");

        // Создаем студентов
        alice = new Student(1, "Майк Тайсон");
        bob = new Student(2, "Денис");
    }

    @Test
    public void testAddStudentWithGrades() {
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        aliceGrades.put(history, 90);

        // Добавляем студента с оценками
        studentDatabase.addStudentWithGrades(alice, aliceGrades);

        assertTrue(Main.getStudentGrades().containsKey(alice));
        assertEquals(2, Main.getStudentGrades().get(alice).size());
    }

    @Test
    public void testAddSubjectForStudent() {
        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(science, 85);

        studentDatabase.addStudentWithGrades(bob, bobGrades);

        // новый предмет для студентика
        studentDatabase.addSubjectForStudent(bob, math, 92);

        assertTrue(Main.getStudentGrades().get(bob).containsKey(math));
        assertEquals(92, Main.getStudentGrades().get(bob).get(math));
    }

    @Test
    public void testRemoveStudent() {
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        aliceGrades.put(history, 90);
        studentDatabase.addStudentWithGrades(alice, aliceGrades);

        // Удаляем студентика
        studentDatabase.removeStud(alice, history);
        assertFalse(Main.getStudentGrades().containsKey(alice));
    }


    @Test
    public void testAddSubjectWithStudents() {
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        studentDatabase.addStudentWithGrades(alice, aliceGrades);

        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(science, 85);
        studentDatabase.addStudentWithGrades(bob, bobGrades);

        studentDatabase.addSubjectWithStudents(history, List.of(alice, bob));

        assertTrue(Main.getSubjectStudents().get(history).contains(alice));
        assertTrue(Main.getSubjectStudents().get(history).contains(bob));
    }

    @Test
    public void testRemoveStudentFromSubject() {
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        studentDatabase.addStudentWithGrades(alice, aliceGrades);
        studentDatabase.addSubjectForStudent(alice, history, 90);
        studentDatabase.removeStudFromSub(alice, history);
        assertFalse(Main.getSubjectStudents().get(history).contains(alice));
    }
}
