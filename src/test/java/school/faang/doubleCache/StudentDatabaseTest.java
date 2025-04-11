package school.faang.doubleCache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.doubleCache.model.Student;
import school.faang.doubleCache.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    public void setup() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    void shouldCorrectlyAddStudent() {
        Student vlad = new Student("Vladislav");
        Map<Subject, Integer> studentSubjects = new HashMap<>();
        Subject physics = new Subject("Physics");
        Subject math = new Subject("Math");
        studentSubjects.put(math, 5);
        studentSubjects.put(physics, 3);

        studentDatabase.addStudent(vlad, studentSubjects);

        assertTrue(studentDatabase.getStudentSubjects().containsKey(vlad));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(physics));
    }

    @Test
    void shouldCorrectlyAdSubjectForExistingStudent() {
        Student vlad = new Student("Vladislav");
        Subject math = new Subject("Math");
        Map<Subject, Integer> studentSubjects = new HashMap<>();
        studentDatabase.addStudent(vlad, studentSubjects);

        studentDatabase.addSubjectForExistingStudent(math, null, vlad);

        assertTrue(studentDatabase.getStudentSubjects().get(vlad).containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
    }

    @Test
    void shouldDeleteStudent() {
        Student vlad = new Student("Vladislav");
        Map<Subject, Integer> studentSubjects = new HashMap<>();
        studentDatabase.addStudent(vlad, studentSubjects);

        studentDatabase.deleteStudent(vlad);

        assertTrue(!studentDatabase.getStudentSubjects().containsKey(vlad));
    }

    @Test
    void shouldGetStudentMarks() {
        Student vlad = new Student("Vladislav");
        Map<Subject, Integer> studentSubjects = new HashMap<>();
        Subject physics = new Subject("Physics");
        Subject math = new Subject("Math");
        studentSubjects.put(math, 5);
        studentSubjects.put(physics, 3);
        studentDatabase.addStudent(vlad, studentSubjects);

        String information = studentDatabase.getStudentMarks();

        assertEquals("{Student(name=Vladislav)={Subject(name=Math)=5, Subject(name=Physics)=3}}", information);
    }

    @Test
    void shouldAddSubject() {
        Student vlad = new Student("Vladislav");
        List<Student> students = List.of(vlad);
        Subject math = new Subject("Math");
        studentDatabase.addStudent(vlad, new HashMap<>());

        studentDatabase.addSubject(math, students);

        assertTrue(studentDatabase.getStudentSubjects().containsKey(vlad));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getStudentSubjects().get(vlad).containsKey(math));
    }

    @Test
    void shouldAddStudentToExistingSubject() {
        Student vlad = new Student("Vladislav");
        Subject math = new Subject("Math");
        studentDatabase.addSubject(math, new ArrayList<>());
        studentDatabase.addStudent(vlad, new HashMap<>());

        studentDatabase.addStudentToExistingSubject(vlad, math, null);

        assertTrue(studentDatabase.getStudentSubjects().get(vlad).containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(vlad));
    }

    @Test
    void shouldDeleteStudentFromSubject() {
        Student vlad = new Student("Vladislav");
        Subject math = new Subject("Math");
        studentDatabase.addSubject(math, new ArrayList<>());
        studentDatabase.addStudent(vlad, new HashMap<>());
        studentDatabase.addStudentToExistingSubject(vlad, math, null);

        studentDatabase.deleteStudentFromSubject(vlad, math);

        assertFalse(studentDatabase.getStudentSubjects().get(vlad).containsKey(math));
        assertFalse(studentDatabase.getSubjectStudents().get(math).contains(vlad));
    }

    @Test
    void shouldGetSubjectsStudents() {
        Student vlad = new Student("Vladislav");
        Map<Subject, Integer> studentSubjects = new HashMap<>();
        Subject physics = new Subject("Physics");
        Subject math = new Subject("Math");
        studentSubjects.put(math, 5);
        studentSubjects.put(physics, 3);
        studentDatabase.addStudent(vlad, studentSubjects);

        String subjectStudents = studentDatabase.getSubjectsForStudents();

        assertEquals("{Subject(name=Math)=[Student(name=Vladislav)], Subject(name=Physics)=[Student(name=Vladislav)]}",
                subjectStudents);
    }
}