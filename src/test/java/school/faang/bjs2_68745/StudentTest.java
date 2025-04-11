package school.faang.bjs2_68745;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Test create Student with empty name")
    public void createStudentWithEmptyNameTest() {
        assertThrows(NoSuchElementException.class, () -> new Student(""));
    }

    @Test
    @DisplayName("Test create Student with NULL name")
    public void createStudentWithNullNameTest() {
        assertThrows(NoSuchElementException.class, () -> new Student(null));
    }

    @Test
    @DisplayName("Test create Student")
    public void createStudentNameTest() {
        Student student = new Student("Student name");
        assertEquals("Student name", student.name());
    }

}