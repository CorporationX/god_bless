package faang.school.godbless.countAbsencesTest;

import faang.school.godbless.countAbsences.Faculty;
import faang.school.godbless.countAbsences.PairFacultyYearKey;
import faang.school.godbless.countAbsences.Student;
import static org.junit.jupiter.api.Assertions.*;

import faang.school.godbless.countAbsences.StudentManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CountAbsencesTest {
    private StudentManager studentManager;
    private Faculty faculty1;
    private Faculty faculty2;
    private Faculty faculty3;
    private Student std1;
    private Student std2;
    private Student std3;
    private Student std4;
    private Student std5;

    @BeforeEach
    public void setUp() {
        studentManager = new StudentManager();
        faculty1 = new Faculty("MachineLearning");
        faculty2 = new Faculty("IT");
        faculty3 = new Faculty("BT");

        std1 = new Student("Yen", faculty1, 1);
        std2 = new Student("Den", faculty1, 1);
        std3 = new Student("Ben", faculty2, 1);
        std4 = new Student("Ren", faculty2, 2);
        std5 = new Student("Ten", faculty3, 3);

        studentManager.addStudent(std1);
        studentManager.addStudent(std2);
        studentManager.addStudent(std3);
        studentManager.addStudent(std4);
        studentManager.addStudent(std5);
    }

    @DisplayName("Test adding and grouping students by faculty and year")
    @Test
    public void testGroupStudentsByFacultyAndYear() {
        Map<PairFacultyYearKey, List<Student>> groupedStudents = studentManager.getStudentsGroupedByFacultiesAndYears();

        assertEquals(2, groupedStudents.get(new PairFacultyYearKey(faculty1.getName(), 1)).size());
        assertEquals(1, groupedStudents.get(new PairFacultyYearKey(faculty2.getName(), 1)).size());
        assertEquals(1, groupedStudents.get(new PairFacultyYearKey(faculty2.getName(), 2)).size());
        assertEquals(1, groupedStudents.get(new PairFacultyYearKey(faculty3.getName(), 3)).size());

        assertTrue(groupedStudents.get(new PairFacultyYearKey(faculty1.getName(), 1)).contains(std1));
        assertTrue(groupedStudents.get(new PairFacultyYearKey(faculty2.getName(), 1)).contains(std3));
    }

    @DisplayName("Test removing a student by name, faculty, and year")
    @Test
    public void testRemoveStudent() {
        studentManager.removeStudent("Yen", "MachineLearning", 1);
        List<Student> allStudents = studentManager.getAllStudents();
        assertEquals(4, allStudents.size());

        Map<PairFacultyYearKey, List<Student>> groupedStudents = studentManager.getStudentsGroupedByFacultiesAndYears();
        assertEquals(1, groupedStudents.get(new PairFacultyYearKey(faculty1.getName(), 1)).size());
        assertFalse(groupedStudents.get(new PairFacultyYearKey(faculty1.getName(), 1)).contains(std1));
    }

    @DisplayName("Test finding students by faculty and year")
    @Test
    public void testFindStudentsByFacultyAndYear() {
        List<Student> foundStudents = studentManager.findStudentsByFacultyAndYear("MachineLearning", 1);
        assertEquals(2, foundStudents.size());
        assertTrue(foundStudents.contains(std1));
        assertTrue(foundStudents.contains(std2));
    }

    @DisplayName("Test adding a student")
    @Test
    public void testAddStudent() {
        Student newStudent = new Student("Zen", faculty3, 3);
        studentManager.addStudent(newStudent);

        List<Student> allStudents = studentManager.getAllStudents();
        assertEquals(6, allStudents.size());
        assertTrue(allStudents.contains(newStudent));

        Map<PairFacultyYearKey, List<Student>> groupedStudents = studentManager.getStudentsGroupedByFacultiesAndYears();
        assertEquals(2, groupedStudents.get(new PairFacultyYearKey(faculty3.getName(), 3)).size());
        assertTrue(groupedStudents.get(new PairFacultyYearKey(faculty3.getName(), 3)).contains(newStudent));
    }

    @DisplayName("Test getting all students")
    @Test
    public void testGetAllStudents() {
        List<Student> allStudents = studentManager.getAllStudents();
        assertEquals(5, allStudents.size());
        assertTrue(allStudents.contains(std1));
        assertTrue(allStudents.contains(std2));
        assertTrue(allStudents.contains(std3));
        assertTrue(allStudents.contains(std4));
        assertTrue(allStudents.contains(std5));
    }


}
