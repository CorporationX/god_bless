package bjs256991test;

import bjs256991.Student;
import bjs256991.StudentDatabase;
import bjs256991.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Map<Student, Map<Subject, Integer>> actualStudentSubjects;
    private Map<Subject, List<Student>> actualSubjectStudents;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        actualStudentSubjects = studentDatabase.getStudentSubjects();
        actualSubjectStudents = studentDatabase.getSubjectStudents();
    }

    @AfterEach
    void tearDown() {
        studentDatabase = null;
        actualStudentSubjects.clear();
        actualSubjectStudents.clear();
    }

    @Test
    void addStudentSubjectsEstimates() {
        fillStudentsSubjectsEstimates();
        Map<Subject, Integer> subjectsToEstimates = new HashMap<>();
        subjectsToEstimates.put(new Subject("Mathematics"), 4);
        Assertions.assertEquals(subjectsToEstimates, actualStudentSubjects.get(new Student("Dmitry")));
        Assertions.assertTrue(actualStudentSubjects.containsKey(new Student("Alexey")));
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dmitry"));
        students.add(new Student("Alexey"));
        Assertions.assertEquals(students, actualSubjectStudents.get(new Subject("Mathematics")));
    }

    @Test
    void addSubjectForStudentWithEstimate() {
        fillStudentsSubjectsEstimates();
        Assertions.assertTrue(actualStudentSubjects.containsKey(new Student("Dmitry")));
        Assertions.assertFalse(actualSubjectStudents.containsKey(new Subject("Physics")));
        studentDatabase.addSubjectForStudentWithEstimate(new Subject("Physics"), new Student("Dmitry"), 5);
        Assertions.assertTrue(actualStudentSubjects.get(new Student("Dmitry")).containsKey(new Subject("Physics")));
        Assertions.assertTrue(actualSubjectStudents.containsKey(new Subject("Physics")));
    }

    @Test
    void removeStudentSubjects() {
        fillStudentsSubjectsEstimates();
        studentDatabase.removeStudentSubjects(new Student("Dmitry"));
        Assertions.assertNull(actualStudentSubjects.get(new Student("Dmitry")));
    }

    @Test
    void addSubjectStudents() {
        fillStudentsSubjectsEstimates();
        studentDatabase.addSubjectStudents(new Subject("Biology"),
                actualSubjectStudents.get(new Subject("Mathematics")));
        Assertions.assertTrue(actualStudentSubjects.get(new Student("Dmitry"))
                .containsKey(new Subject("Biology")));
        Assertions.assertTrue(actualStudentSubjects.get(new Student("Alexey"))
                .containsKey(new Subject("Biology")));
        Assertions.assertTrue(actualSubjectStudents.containsKey(new Subject("Biology")));
        Assertions.assertTrue(actualSubjectStudents.get(new Subject("Biology"))
                .contains(new Student("Dmitry")));
        Assertions.assertTrue(actualSubjectStudents.get(new Subject("Biology"))
                .contains(new Student("Alexey")));
    }

    @Test
    void addStudentSubject() {
        fillStudentsSubjectsEstimates();
        studentDatabase.addStudentSubject(new Student("Michail"), new Subject("Mathematics"));
        Assertions.assertTrue(actualStudentSubjects.containsKey(new Student("Michail")));
        Assertions.assertTrue(actualSubjectStudents.get(new Subject("Mathematics"))
                .contains(new Student("Michail")));
    }

    @Test
    void removeStudentFromSubject() {
        fillStudentsSubjectsEstimates();
        studentDatabase.removeStudentFromSubject(new Student("Dmitry"), new Subject("Mathematics"));
        Assertions.assertTrue(actualStudentSubjects.containsKey(new Student("Dmitry")));
        Assertions.assertTrue(actualSubjectStudents.containsKey(new Subject("Mathematics")));
        Assertions.assertFalse(actualStudentSubjects.get(new Student("Dmitry"))
                .containsKey(new Subject("Mathematics")));
    }

    private void fillStudentsSubjectsEstimates() {
        studentDatabase.addStudentSubjectsEstimates(new Student("Dmitry"),
                new Subject("Mathematics"), 4);
        studentDatabase.addStudentSubjectsEstimates(new Student("Alexey"),
                new Subject("Mathematics"), 5);
        Assertions.assertEquals(2, actualStudentSubjects.size());
        Assertions.assertEquals(1, actualSubjectStudents.size());
    }
}
