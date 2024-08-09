package faang.school.godbless.BJS2_19328;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void init() {
        main = new Main();

        main.getStudents().add(new Student("Ivan", "Math", 1));
        main.getStudents().add(new Student("Stepan", "Rus", 1));
        main.getStudents().add(new Student("Nikolay", "Math", 2));
        main.getStudents().add(new Student("Irina", "Biology", 3));
        main.getStudents().add(new Student("Olga", "Chemistry", 2));
        main.getStudents().add(new Student("Aleksandr", "Rus", 1));
        main.getStudents().add(new Student("Igor", "Chemistry", 3));
    }

    @Test
    void addStudentTest() {
        Student student = new Student("Mark", "Math", 3);
        main.addStudent(student);
        assertTrue(main.getStudents().contains(student));
    }

    @Test
    void deleteStudentTest() {
        int size = main.getStudents().size();
        main.deleteStudent("Nikolay", "Math", 2);
        assertEquals(size - 1, main.getStudents().size());
    }

    @Test
    void findStudentsByFacultyAndYearTest() {
        List<Student> students = main.findStudentsByFacultyAndYear("Rus", 1);
        assertEquals(2, students.size());
    }

    @Test
    void getStudentsGroupingByFacultyAndYear() {
        Map<Group, List<Student>> result = main.getStudentsGroupedByFacultyAndYear(main.getStudents());
        assertEquals(2, result.get(new Group("Rus", 1)).size());
    }
}