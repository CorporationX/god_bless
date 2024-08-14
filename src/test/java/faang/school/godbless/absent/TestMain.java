package faang.school.godbless.absent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    Main students;

    @BeforeEach
    void init() {
        students = new Main();
    }

    @Test
    @DisplayName("Main initialization")
    public void testInit() {
        Assertions.assertEquals(9, students.studentsQuantity());
    }

    @Test
    @DisplayName("Add student")
    public void testAddStudent() {
        students.addStudent(new Student("name0", "faculty3", "2003"));

        Assertions.assertTrue(students.checkStudentExist("name0", "faculty3", "2003"));
        Assertions.assertEquals(10, students.studentsQuantity());
    }

    @Test
    @DisplayName("Delete student")
    public void testDelStudent() {
        students.delStudent("name0", "faculty3", "2003");

        Assertions.assertFalse(students.checkStudentExist("name0", "faculty3", "2003"));
        Assertions.assertEquals(9, students.studentsQuantity());
    }

    @Test
    @DisplayName("Search students with same faculty and year")
    void testSearchStudent() {
        assertEquals(2, students.searchStudents("faculty1", "2001").size());
    }

    @Test
    @DisplayName("Grouping students by faculty and year")
    void testGroupStudents() {
        Map<String, List<Student>> studentsMap = students.groupStudents();

        assertEquals(3, studentsMap.size());
        assertTrue(studentsMap.containsKey("faculty1@2001"));
        assertTrue(studentsMap.containsKey("faculty2@2002"));
        assertTrue(studentsMap.containsKey("faculty3@2003"));
    }
}