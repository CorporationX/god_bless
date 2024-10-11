package school.faang.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    private University university;

    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    public void setUp() {
        student1 = new Student("Student Name 1", "Faculty 1", 2021);
        student2 = new Student("Student Name 2", "Faculty 2", 2022);
        student3 = new Student("Student Name 3", "Faculty 3", 2023);

        university = new University();

        university.add(student1);
        university.add(student2);
        university.add(student3);
    }

    @Test
    public void addStudentTest() {
        university.add(new Student("Student Name 4", "Faculty 3", 2023));
        List<Student> students = university.findAllByFacultyAndYear("Faculty 3", 2023);
        assertEquals(2, students.size());
    }

    @Test
    public void findStudentsByFacultyAndYearTest() {
        List<Student> students = university.findAllByFacultyAndYear("Faculty 3", 2023);
        assertEquals(1, students.size());
    }

    @Test
    public void deleteStudentTest() {
        university.delete("Student Name 2", "Faculty 2", 2022);
        List<Student> students = university.findAllByFacultyAndYear("Faculty 2", 2022);
        assertNull(students);
    }

    @Test
    public void printAllStudentsTest() {
        university.printAllStudents();
    }
}
