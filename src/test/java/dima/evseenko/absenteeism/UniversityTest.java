package dima.evseenko.absenteeism;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniversityTest {

    @Test
    void addStudent() {
        University university = new University();
        university.addStudent(new Student("Dima", Student.Faculty.IT, 1));

        assertTrue(university.findStudents(Student.Faculty.IT, 1).contains(new Student("Dima", Student.Faculty.IT, 1)));
    }

    @Test
    void addNullStudent(){
        assertThrows(IllegalArgumentException.class, () -> new University().addStudent(null));
    }

    @Test
    void addInvalidStudentName(){
        assertThrows(IllegalArgumentException.class, () -> new University().addStudent(new Student(null, Student.Faculty.IT, 1)));
    }

    @Test
    void addInvalidStudentFaculty(){
        assertThrows(IllegalArgumentException.class, () -> new University().addStudent(new Student("Dima", null, 1)));
    }

    @Test
    void addInvalidStudentYear(){
        assertThrows(IllegalArgumentException.class, () -> new University().addStudent(new Student("Dima", Student.Faculty.IT, 0)));
    }

    @Test
    void addStudents() {
        University university = new University();
        university.addStudents(getStudents());

        assertTrue(university.findStudents(Student.Faculty.IT, 1).contains(new Student("Dima", Student.Faculty.IT, 1)));
        assertTrue(university.findStudents(Student.Faculty.IT, 2).contains(new Student("Vasya", Student.Faculty.IT, 2)));
        assertTrue(university.findStudents(Student.Faculty.MATH, 1).contains(new Student("Kolya", Student.Faculty.MATH, 1)));
    }

    @Test
    void addNullStudents() {
        assertThrows(IllegalArgumentException.class, () -> new University().addStudents(null));
    }

    @Test
    void deleteStudent(){
        University university = new University();
        university.addStudents(getStudents());

        university.deleteStudent(new Student("Dima", Student.Faculty.IT, 1));

        assertFalse(university.findStudents(Student.Faculty.IT, 1).contains(new Student("Dima", Student.Faculty.IT, 1)));
    }

    @Test
    void findStudents() {
        University university = new University();
        university.addStudents(getStudents());

        assertTrue(university.findStudents(new Student.KeyPair(Student.Faculty.PHYSICS, 2)).contains(new Student("Sasha", Student.Faculty.PHYSICS, 2)));
    }

    @Test
    void findNullStudentsKeyPair() {
        assertNull(new University().findStudents(null));
    }

    @Test
    void findNullStudentsKeyPairFaculty() {
        assertNull(new University().findStudents(new Student.KeyPair(null, 2)));
    }

    @Test
    void findNullStudentsKeyPairYear() {
        assertNull(new University().findStudents(new Student.KeyPair(Student.Faculty.PHYSICS, 0)));
    }

    @Test
    void findNullStudentsKeyPairFacultyOther() {
        assertNull(new University().findStudents(null, 1));
    }

    @Test
    void findNullStudentsKeyPairYearOther() {
        assertNull(new University().findStudents(Student.Faculty.IT, 0));
    }

    private List<Student> getStudents() {
        return List.of(
                new Student("Dima", Student.Faculty.IT, 1),
                new Student("Vasya", Student.Faculty.IT, 2),
                new Student("Kolya", Student.Faculty.MATH, 1),
                new Student("Sasha", Student.Faculty.PHYSICS, 2),
                new Student("Masha", Student.Faculty.MATH, 1),
                new Student("Polina", Student.Faculty.PHYSICS, 3),
                new Student("Danil", Student.Faculty.IT, 1)
        );
    }
}