package scholl.faang.BJS2_56962;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.BJS2_56962.Student;
import school.faang.BJS2_56962.StudentDatabase;
import school.faang.BJS2_56962.Subject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentDatabaseTest {

    private StudentDatabase database;

    @BeforeEach
    public void setUp() {
        database = new StudentDatabase();
    }

    @Test
    public void testAddStudent() {
        Student student = database.addStudent("Alice");
        assertNotNull(student);
        assertEquals("Alice", student.getName());
    }

    @Test
    public void testAddSubject() {
        Subject subject = database.addSubject("Math");
        assertNotNull(subject);
        assertEquals("Math", subject.getName());
    }

    @Test
    public void testAddStudentSubjectsGrade() {
        database.addStudentSubjectsGrade("Alice", "Math", 4);

        assertThrows(IllegalArgumentException.class, () ->
                database.addStudentSubjectsGrade("Alice", "Math", 6));
    }

    @Test
    public void testDeleteStudentSubject() {
        Student student = database.addStudent("Alice");
        Subject subject = database.addSubject("Math");

        database.addStudentSubjectsGrade("Alice", "Math", 4);
        database.deleteStudentSubject(student);

        assertThrows(IllegalArgumentException.class, () ->
                database.validateStudentExists(student));
    }

    @Test
    public void testPrintAllSubjectAndStudent() {
        database.addStudentSubjectsGrade("Alice", "Math", 4);
        database.addStudentSubjectsGrade("Bob", "Physics", 3);

        assertDoesNotThrow(database::printAllSubjectAndStudent);
    }

    @Test
    public void testAddSubjectAndListStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));

        database.addSubjectAndListStudents("Math", students);
        assertThrows(IllegalArgumentException.class, () ->
                database.addSubjectAndListStudents("Math", new ArrayList<>()));
    }
}

