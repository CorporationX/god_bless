package school.faang.sprint_1.task_45232;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static school.faang.sprint_1.task_45232.Main.studentGrades;
import static school.faang.sprint_1.task_45232.Main.subjectStudents;

public class TestStudentDatabase {
    StudentDatabase studentDatabase = new StudentDatabase();

    Student alex = new Student(1, "Alex");
    Student bob = new Student(2, "Bob");
    Student sam = new Student(3, "Sam");

    Subject math = new Subject(1, "Math");
    Subject history = new Subject(2, "History");
    Subject art = new Subject(3, "Art");

    Map<Subject, Integer> grades = new HashMap<>();

    @BeforeEach
    public void beforeEach() {
        studentGrades.clear();
        subjectStudents.clear();
        grades.clear();
    }

    @Test
    public void addStudentWithGradesTest() {
        grades.put(math, 5);
        grades.put(history, 4);

        studentDatabase.addStudentWithGrades(alex, grades);

        assertTrue(studentGrades.containsKey(alex));
        assertEquals(grades, studentGrades.get(alex));

        assertTrue(subjectStudents.containsKey(math));
        assertTrue(subjectStudents.get(math).contains(alex));
        assertTrue(subjectStudents.containsKey(history));
        assertTrue(subjectStudents.get(history).contains(alex));
    }

    @Test
    public void addSubjectForStudentTest() {
        studentGrades.put(bob, grades);

        studentDatabase.addSubjectForStudent(bob, art, 5);

        assertEquals(new HashMap<>(Map.of(art, 5)), studentGrades.get(bob));
        assertTrue(subjectStudents.containsKey(art));
        assertTrue(subjectStudents.get(art).contains(bob));
    }

    @Test
    public void removeStudentTest() {
        grades.put(math, 5);
        studentGrades.put(sam, grades);

        List<Student> students = new ArrayList<>();
        students.add(sam);
        subjectStudents.put(math, students);

        studentDatabase.removeStudent(sam);

        assertTrue(subjectStudents.get(math).isEmpty());
        assertTrue(studentGrades.isEmpty());
    }

    @Test
    public void addSubjectWithStudentsTest() {
        List<Student> students = new ArrayList<>();
        students.add(sam);
        subjectStudents.put(art, students);

        grades.put(art, null);
        studentGrades.put(sam, grades);

        studentDatabase.addSubjectWithStudents(art, students);

        assertTrue(subjectStudents.containsKey(art));
        assertTrue(subjectStudents.get(art).contains(sam));
        assertTrue(studentGrades.containsKey(sam));
        assertEquals(grades, studentGrades.get(sam));
    }

    @Test
    public void addStudentToSubjectTest() {
        List<Student> students = new ArrayList<>();
        students.add(sam);
        subjectStudents.put(art, students);

        grades.put(art, null);
        studentGrades.put(sam, grades);

        studentDatabase.addStudentToSubject(sam, art);

        assertTrue(subjectStudents.containsKey(art));
        assertTrue(subjectStudents.get(art).contains(sam));
        assertTrue(studentGrades.containsKey(sam));
        assertEquals(grades, studentGrades.get(sam));
    }

    @Test
    public void removeStudentFromSubjectTest() {
        List<Student> students = new ArrayList<>();
        students.add(alex);
        subjectStudents.put(history, students);

        grades.put(history, 5);
        studentGrades.put(alex, grades);

        studentDatabase.removeStudentFromSubject(alex, history);

        assertTrue(subjectStudents.get(history).isEmpty());
        assertTrue(studentGrades.get(alex).isEmpty());
    }


}
