package school.faang.bjs2_68745;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    private StudentDatabase database;

    @BeforeEach
    void initTestCase() {
        database = new StudentDatabase();
    }

    private Student addOneStudentWithTwoSubjects() {
        Student student1 = new Student("name1");
        Map<Subject, Integer> subjects = new HashMap<>(Map.of(
            new Subject("subj1"), 1,
            new Subject("sub2"), 1
        ));
        database.addStudentWithSubjects(student1, subjects);
        return student1;
    }

    @Test
    @DisplayName("remove one Student")
    void removeStudentTest() {
        Student student = addOneStudentWithTwoSubjects();
        database.removeStudent(student);
        assertEquals(0, database.getStudentSubjects().size());
    }

    @Test
    @DisplayName("test add student with two subjects")
    void addStudentWithSubjectsTest() {
        addOneStudentWithTwoSubjects();
        assertEquals(1, database.getStudentSubjects().size());
        assertEquals(2, database.getSubjectStudents().size());
    }

    @Test
    @DisplayName("test add subject to student")
    void addSubjectToStudentTest() {
        //public void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        database.addSubjectToStudent(new Student("st1"), new Subject("subj1"), 1);
        assertEquals(1, database.getStudentSubjects().size());
    }

    @Test
    @DisplayName("add one subject with two student")
    void addSubjectWithStudentListTest() {
        //public void addSubjectWithStudentList(Subject subject, List<Student> students) {
        database.addSubjectWithStudentList(
            new Subject("sbj1"),
            new ArrayList<>(List.of(new Student("st1"), new Student("st2")))
        );
        assertEquals(1, database.getSubjectStudents().size());
    }

    @Test
    @DisplayName("remove student from subject")
    void removeStudentFromSubjectTest() {
        Student student1 = new Student("st1");
        Subject subject = new Subject("sbj1");
        database.addSubjectWithStudentList(
            subject,
            new ArrayList<>(List.of(student1, new Student("st2")))
        );
        database.removeStudentFromSubject(student1, subject);
        assertEquals(1, database.getSubjectStudents().get(subject).size());
    }
}