import org.example.model.Group;
import org.example.model.Student;
import org.example.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {
    int currentSizeOfStudentList = StudentService.students.size();
    List<Student> students = StudentService.students;

    @Test
    @DisplayName("test to grouping students by faculty and year")
    void testToGroupingStudentsByFacultyANdYear() {
        Map<Group, List<Student>> groupedStudents = StudentService.groupingStudentsToGroup(students);

        assertEquals(7, groupedStudents.size());
    }

    @Test
    @DisplayName("test to add student to list")
    void testToAddStudentToListOfStudents() {
        StudentService.addStudent("Baurzhan", "IT", 4);

        assertEquals(currentSizeOfStudentList + 1, StudentService.students.size());
    }

    @Test
    @DisplayName("test to remove student from List")
    void testToRemoveStudentFromStudentList() {
        StudentService.removeStudent("Zhubanysh", "IT", 3);

        assertEquals(currentSizeOfStudentList - 1, StudentService.students.size());
    }

    @Test
    @DisplayName("test to find one group students")
    void testToFindingSameGroupStudents() {
        StudentService.groupingStudentsToGroup(StudentService.students);
        List<Student> foundStudentsList = StudentService.findStudentsByFacultyAndYear("Design", 2);

        assertEquals(2, foundStudentsList.size());
    }
}
