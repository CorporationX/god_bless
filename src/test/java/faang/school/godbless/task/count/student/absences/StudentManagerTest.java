package faang.school.godbless.task.count.student.absences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentManagerTest {
    Student student1 = new Student("Alice", "Engineering", 1);
    Student student2 = new Student("Bob", "Engineering", 1);
    Student student3 = new Student("Charlie", "Engineering", 1);
    Student student4 = new Student("David", "Mathematics", 2);
    Student student5 = new Student("Eve", "Mathematics", 2);
    Student student6 = new Student("Frank", "Mathematics", 2);
    Student student7 = new Student("Grace", "Physics", 3);
    Student student8 = new Student("Heidi", "Physics", 3);
    Student student9 = new Student("Ivan", "Physics", 3);
    Student student10 = new Student("Judy", "Engineering", 1);
    Student student11 = new Student("Mallory", "Mathematics", 2);

    Student student = new Student("Test", "Test faculty", 12);

    StudentManager studentManager;
    List<Student> studentsList;
    Map<FacultyYear, List<Student>> expectedMap;
    Map<FacultyYear, List<Student>> actualMap;

    @BeforeEach
    void setUp() {
        studentManager = new StudentManager(new HashMap<>(), new ArrayList<>(), new HashMap<>());
        studentsList = new ArrayList<>(List.of(
                student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10, student11
        ));
        expectedMap = new HashMap<>(Map.of(
                new FacultyYear("Engineering", 1), List.of(student1, student2, student3, student10),
                new FacultyYear("Mathematics", 2), List.of(student4, student5, student6, student11),
                new FacultyYear("Physics", 3), List.of(student7, student8, student9)
        ));
        studentManager.addNewStudent(student1);
        studentManager.addNewStudent(student2);
        studentManager.addNewStudent(student3);
        studentManager.addNewStudent(student4);
        studentManager.addNewStudent(student5);
        studentManager.addNewStudent(student6);
        studentManager.addNewStudent(student7);
        studentManager.addNewStudent(student8);
        studentManager.addNewStudent(student9);
        studentManager.addNewStudent(student10);
        studentManager.addNewStudent(student11);
    }

    @Test
    void testAddNewStudentAndFindStudent() {
        studentManager.addNewStudent(student);
        assertEquals(student, studentManager.findStudent(student));
    }

    @Test
    void testAddNewStudentNullValue() {
        Student stdNull = null;
        assertThrows(NoSuchElementException.class, () -> studentManager.addNewStudent(stdNull));
    }

    @Test
    void testDeleteStudent() {
        studentManager.addNewStudent(student);
        studentManager.deleteStudent(student);
        assertNull(studentManager.findStudent(student));
    }

    @Test
    void testDeleteStudentNullValue() {
        studentManager.deleteStudent(null);
    }

    @Test
    void testFindAllStudentByFacultyAndYear() {
        List<Student> expectedList = new ArrayList<>(List.of(
                student4, student5, student6, student11
        ));
        List<Student> actualList = studentManager.findAllStudentByFacultyAndYear("Mathematics", 2);
        assertEquals(expectedList, actualList);
    }

    @Test
    void testFindAllSortedStudentMap() {
        actualMap = studentManager.findAllSortedStudentMap();
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void testSortStudentByFacultyAndYear() {
        actualMap = studentManager.sortStudentByFacultyAndYear(studentsList);
        assertEquals(expectedMap, actualMap);
    }
}
