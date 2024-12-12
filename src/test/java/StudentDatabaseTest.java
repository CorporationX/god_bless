import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import school.faang.bjs45286.Student;
import school.faang.bjs45286.StudentDatabase;
import school.faang.bjs45286.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentDatabaseTest {
    StudentDatabase database;
    Student student;
    Subject math;

    @BeforeEach
    void setUp() {
        database = new StudentDatabase();
        student = new Student(1, "Petya");
        math = new Subject(1, "Math");
        Map<Subject, Integer> marks = new HashMap<>();
        marks.put(math, 2);
        database.addStudent(student, marks);
    }

    @Test
    void shouldContainStudentAfterAdding() {
        Student student2 = new Student(2, "Masha");
        Subject physics = new Subject(2, "Physics");

        database.addStudent(student2, Map.of(physics, 3));

        Assertions.assertTrue(database.getStudentMarks().containsKey(student2));
        Assertions.assertTrue(database.getStudentsSubjects().get(physics).contains(student2));
    }

    @Test
    void shouldThrowWithNotExistingStudent() {
        Student student = Mockito.mock(Student.class);
        Subject subject = Mockito.mock(Subject.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> database.addStudentsSubject(student, subject, 1));
    }

    @Test
    void shouldNotContainStudentAfterRemoving() {
        database.deleteUser(student);

        Assertions.assertFalse(database.getStudentMarks().containsKey(student));
        Assertions.assertFalse(database.getStudentsSubjects().get(math).contains(student));
    }

    @Test
    void shouldAddSubjectToExistingStudent() {
        Subject physics = new Subject(2, "Physics");

        database.addStudentsSubject(student, physics, 1);

        Assertions.assertTrue(database.getStudentMarks().get(student).containsKey(physics));
        Assertions.assertTrue(database.getStudentsSubjects().get(physics).contains(student));
    }

    @Test
    void shouldThrowWhenLinkingToNonExistingSubject() {
        Student student = Mockito.mock(Student.class);
        Subject subject = Mockito.mock(Subject.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> database.linkStudentToSubject(subject, student));
    }

    @Test
    void shouldRemoveStudentFromSubject() {
        database.removeStudentFromSubject(math, student);

        Assertions.assertFalse(database.getStudentMarks().get(student).containsKey(math));
        Assertions.assertFalse(database.getStudentsSubjects().get(math).contains(student));
    }

    @Test
    void shouldAddNewSubjectWithStudents() {
        Subject subject = Mockito.mock(Subject.class);
        Student studentMock = Mockito.mock(Student.class);
        database.addNewSubject(subject, List.of(student, studentMock));

        Assertions.assertTrue(database.getStudentsSubjects().get(subject).contains(studentMock));
    }

    @Test
    void shouldLinkStudentToExistingSubject() {
        Student studentMock = Mockito.mock(Student.class);
        database.linkStudentToSubject(math, studentMock);

        Assertions.assertTrue(database.getStudentsSubjects().get(math).contains(studentMock));
    }
}