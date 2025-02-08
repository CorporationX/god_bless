package scholl.faang.BJS2_56962;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.BJS2_56962.Student;
import school.faang.BJS2_56962.StudentDatabase;
import school.faang.BJS2_56962.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentDatabaseTest {

    private StudentDatabase database;

    @BeforeEach
    public void setUp() {
        database = new StudentDatabase();
    }

    @Test
    public void testAddStudentSubjectsGrade() {
        database.addNewStudentAndHisSubjectWithGrades("Alice", "Math", 4);

        assertThrows(IllegalArgumentException.class, () ->
                database.addNewStudentAndHisSubjectWithGrades("Alice", "Math", 6));
    }

    @Test
    public void testDeleteStudentSubject() {
        Student student = new Student("Alice");
        Subject subject = new Subject("Math");

        database.addNewStudentAndHisSubjectWithGrades("Alice", "Math", 4);
        database.removeStudentAndHisSubjects(student);

        assertThrows(IllegalArgumentException.class, () ->
                database.validateStudentExists(student));
    }

    @Test
    public void testPrintAllSubjectAndStudent() {
        database.addNewStudentAndHisSubjectWithGrades("Alice", "Math", 4);
        database.addNewStudentAndHisSubjectWithGrades("Bob", "Physics", 3);

        assertDoesNotThrow(database::printAllSubjectAndStudent);
    }

    @Test
    public void testAddSubjectAndListStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));

        database.addNewSubjectAndListStudentsStudyingIt("Math", students);
        assertThrows(IllegalArgumentException.class, () ->
                database.addNewSubjectAndListStudentsStudyingIt("Math", new ArrayList<>()));
    }

    @Test
    public void testAddNewSubjectWithGradeToExistingStudent() {
        Student student = new Student("Alice");
        Subject subject = new Subject("Math");

        int grade = 4;
        database.addNewSubjectWithGradeToExistingStudent(student, subject, grade);

        assertDoesNotThrow(database::printListStudentAndTheirGradesBySubject);
    }

}

