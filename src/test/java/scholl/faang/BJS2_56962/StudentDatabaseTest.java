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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentDatabaseTest {

    private StudentDatabase database;

    @BeforeEach
    public void setUp() {
        database = new StudentDatabase();
    }

    @Test
    public void testAddStudentSubjectsGrade() {
        Student student = new Student("Alice");
        Subject subject = new Subject("Math");
        assertDoesNotThrow(() -> database.addNewStudentAndHisSubjectWithGrades(student, Map.of(subject, 4)));
    }

    @Test
    public void testAddStudentSubjectsGrade_InvalidGrade() {
        Student student = new Student("Alice");
        Subject subject = new Subject("Math");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                database.addNewStudentAndHisSubjectWithGrades(student, Map.of(subject, 6)));

        assertEquals("Оценка 6 некорректна, она должна быть в диапазоне от 1 до 5", exception.getMessage());
    }

    @Test
    public void testDeleteStudentSubject() {
        Student student = new Student("Alice");
        Subject subject = new Subject("Math");

        database.addNewStudentAndHisSubjectWithGrades(student, Map.of(subject, 4));
        database.removeStudentAndHisSubjects(student);

        assertThrows(IllegalArgumentException.class, () ->
                database.validateStudentExists(student));
    }

    @Test
    public void testPrintAllSubjectAndStudent() {
        Student student = new Student("Alice");
        Student student1 = new Student("Bob");
        Subject subject = new Subject("Math");
        Subject subject1 = new Subject("Physics");
        database.addNewStudentAndHisSubjectWithGrades(student, Map.of(subject, 4));
        database.addNewStudentAndHisSubjectWithGrades(student1, Map.of(subject1, 3));

        assertDoesNotThrow(database::printAllSubjectAndStudent);
    }

    @Test
    public void testAddSubjectAndListStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));
        Subject subject = new Subject("Math");

        database.addNewSubjectAndListStudentsStudyingIt(subject, students);
        assertThrows(IllegalArgumentException.class, () ->
                database.addNewSubjectAndListStudentsStudyingIt(subject, new ArrayList<>()));
    }

    @Test
    public void testAddNewSubjectWithGradeToExistingStudent() {
        Student student = new Student("Alice");
        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");

        Map<Subject, Integer> initialSubjects = Map.of(math, 5);
        database.addNewStudentAndHisSubjectWithGrades(student, initialSubjects);

        int grade = 4;
        database.addNewSubjectWithGradeToExistingStudent(student, physics, grade);

        assertDoesNotThrow(database::printListStudentAndTheirGradesBySubject);
    }
}
