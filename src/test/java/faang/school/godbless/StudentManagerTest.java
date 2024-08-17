package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import faang.school.godbless.dolbahlop.*;
public class StudentManagerTest {
    private StudentManager studentManager;

    @BeforeEach
    void setUp() {
        studentManager = new StudentManager();
        studentManager.addStudent(new Student("Alice", "Engineering", 1));
        studentManager.addStudent(new Student("Bob", "Engineering", 2));
        studentManager.addStudent(new Student("Charlie", "Science", 1));
        studentManager.addStudent(new Student("David", "Science", 2));
        studentManager.addStudent(new Student("Eve", "Engineering", 1));
    }

    @Test
    void testAddStudent() {
        // Arrange
        Student newStudent = new Student("Frank", "Science", 3);

        // Act
        studentManager.addStudent(newStudent);

        // Assert
        List<Student> result = studentManager.findStudentsByFacultyAndYear("Science", 3);
        assertEquals(1, result.size());
        assertEquals("Frank", result.get(0).getName());
    }

    @Test
    void testRemoveStudent() {
        // Act
        boolean removed = studentManager.removeStudent("Alice", "Engineering", 1);

        // Assert
        assertTrue(removed);
        List<Student> result = studentManager.findStudentsByFacultyAndYear("Engineering", 1);
        assertEquals(1, result.size()); // только Eve должна остаться
    }

    @Test
    void testFindStudentsByFacultyAndYear() {
        // Act
        List<Student> result = studentManager.findStudentsByFacultyAndYear("Science", 1);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Charlie", result.get(0).getName());
    }

    @Test
    void testGroupStudentsByFacultyAndYear() {
        // Act
        Map<String, List<Student>> groupedStudents = studentManager.groupStudentsByFacultyAndYear();

        // Assert
        assertEquals(4, groupedStudents.size());
        assertEquals(2, groupedStudents.get("Engineering 1").size());
        assertEquals(1, groupedStudents.get("Science 1").size());
    }
}
