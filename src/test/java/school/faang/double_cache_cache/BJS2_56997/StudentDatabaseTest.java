package school.faang.double_cache_cache.BJS2_56997;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StudentDatabaseTest {

    private StudentDatabase studentDatabase;
    private Student andrei;
    private Student bob;
    Map<Subject, Integer> subjects;
    Subject math;
    Subject defence;


    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        andrei = new Student("Andrei");
        bob = new Student("Bob");
        subjects = new HashMap<>();
        math = new Subject("Math");
        defence = new Subject("Defence against the dark arts");
    }

    @Test
    void addStudentWithSubjectsTest() {
        subjects.put(math, 4);
        subjects.put(defence, 3);

        assertThat(studentDatabase.getStudentSubjects()).isNotNull();

        studentDatabase.addStudentWithSubjects(andrei, subjects);

        Map<Subject, Integer> andreiSubjects = studentDatabase.getStudentSubjects().get(andrei);
        assertThat(andreiSubjects).isNotNull();
        assertThat(andreiSubjects).isEqualTo(subjects);


        Map<Subject, List<Student>> subjectStudent = studentDatabase.getSubjectStudents();
        assertThat(subjectStudent).isNotNull();
        assertThat(subjectStudent.get(defence)).contains(andrei);
        assertThat(subjectStudent.get(math)).contains(andrei);
    }

    @Test
    void addSubjectAndGradeTest() {
        Map<Subject, Integer> initialSubjects = new HashMap<>();
        initialSubjects.put(math, 4);
        studentDatabase.addStudentWithSubjects(andrei, initialSubjects);

        Map<Subject, Integer> newSubjects = new HashMap<>();
        newSubjects.put(defence, 3);

        studentDatabase.addSubjectAndGrade(andrei, newSubjects);

        assertThat(studentDatabase.getStudentSubjects().get(andrei)).containsAllEntriesOf(newSubjects);
        assertThat(studentDatabase.getSubjectStudents().get(defence)).contains(andrei);
    }

    @Test
    void removeStudentAndItemsTest() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 4);
        subjects.put(defence, 3);
        studentDatabase.addStudentWithSubjects(andrei, subjects);

        studentDatabase.removeStudentAndItems(andrei);

        assertThat(studentDatabase.getStudentSubjects()).doesNotContainKey(andrei);
        assertThat(studentDatabase.getSubjectStudents().get(math)).doesNotContain(andrei);
        assertThat(studentDatabase.getSubjectStudents().get(defence)).doesNotContain(andrei);
    }

    @Test
    void printAllStudentsTest() {
        subjects.put(math, 4);
        subjects.put(defence, 3);
        studentDatabase.addStudentWithSubjects(andrei, subjects);
        studentDatabase.addStudentWithSubjects(bob, subjects);

        studentDatabase.printAllStudents();
    }

    @Test
    void printAllSubjectsWithStudentTest() {
        subjects.put(math, 4);
        subjects.put(defence, 3);
        studentDatabase.addStudentWithSubjects(andrei, subjects);
        studentDatabase.addStudentWithSubjects(bob, subjects);

        studentDatabase.printAllSubjectsWithStudent();
    }

    @Test
    void addSubjectWithStudentTest() {
        List<Student> students = List.of(andrei, bob);

        studentDatabase.addSubjectWithStudent(math, students);

        assertThat(studentDatabase.getSubjectStudents().get(math)).containsAll(students);
        for (Student student : students) {
            assertThat(studentDatabase.getStudentSubjects().get(student)).containsKey(math);
        }
    }

    @Test
    void addStudentToSubjectTest() {
        studentDatabase.addStudentToSubject(andrei, math);

        assertThat(studentDatabase.getSubjectStudents().get(math)).contains(andrei);
        assertThat(studentDatabase.getStudentSubjects().get(andrei)).containsKey(math);
    }

    @Test
    void removeStudentFromSubjectTest() {
        studentDatabase.addStudentToSubject(andrei, math);

        studentDatabase.removeStudentFromSubject(andrei, math);

        assertThat(studentDatabase.getSubjectStudents().get(math)).doesNotContain(andrei);
        assertThat(studentDatabase.getStudentSubjects().get(andrei)).doesNotContainKey(math);
    }
}