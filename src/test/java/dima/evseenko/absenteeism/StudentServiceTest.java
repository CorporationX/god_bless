package dima.evseenko.absenteeism;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentServiceTest {

    @Test
    void addStudent() {
        StudentService studentService = new StudentService();
        studentService.addStudent(new Student("Dima", Faculty.IT, 1));

        assertTrue(studentService.findStudents(Faculty.IT, 1).contains(new Student("Dima", Faculty.IT, 1)));
    }

    @Test
    void addStudents() {
        StudentService studentService = new StudentService();
        studentService.addStudents(getStudents());

        assertTrue(studentService.findStudents(Faculty.IT, 1).contains(new Student("Dima", Faculty.IT, 1)));
        assertTrue(studentService.findStudents(Faculty.IT, 2).contains(new Student("Vasya", Faculty.IT, 2)));
        assertTrue(studentService.findStudents(Faculty.MATH, 1).contains(new Student("Kolya", Faculty.MATH, 1)));
    }

    @Test
    void deleteStudent(){
        StudentService studentService = new StudentService();
        studentService.addStudents(getStudents());

        studentService.deleteStudent(new Student("Dima", Faculty.IT, 1));

        assertFalse(studentService.findStudents(Faculty.IT, 1).contains(new Student("Dima", Faculty.IT, 1)));
    }

    @Test
    void findStudents() {
        StudentService studentService = new StudentService();
        studentService.addStudents(getStudents());

        assertTrue(studentService.findStudents(new FacultyYearKeyPair(Faculty.PHYSICS, 2)).contains(new Student("Sasha", Faculty.PHYSICS, 2)));
    }

    @Test
    void findNullStudentsKeyPair() {
        assertNull(new StudentService().findStudents(null));
    }

    @Test
    void findNullStudentsKeyPairFaculty() {
        assertNull(new StudentService().findStudents(new FacultyYearKeyPair(null, 2)));
    }

    @Test
    void findNullStudentsKeyPairYear() {
        assertNull(new StudentService().findStudents(new FacultyYearKeyPair(Faculty.PHYSICS, 0)));
    }

    @Test
    void findNullStudentsKeyPairFacultyOther() {
        assertNull(new StudentService().findStudents(null, 1));
    }

    @Test
    void findNullStudentsKeyPairYearOther() {
        assertNull(new StudentService().findStudents(Faculty.IT, 0));
    }

    private List<Student> getStudents() {
        return List.of(
                new Student("Dima", Faculty.IT, 1),
                new Student("Vasya", Faculty.IT, 2),
                new Student("Kolya", Faculty.MATH, 1),
                new Student("Sasha", Faculty.PHYSICS, 2),
                new Student("Masha", Faculty.MATH, 1),
                new Student("Polina", Faculty.PHYSICS, 3),
                new Student("Danil", Faculty.IT, 1)
        );
    }
}