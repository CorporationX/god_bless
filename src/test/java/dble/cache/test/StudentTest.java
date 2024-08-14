package dble.cache.test;

import dble.cache.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {
    @Test
    @DisplayName("Testing crete Student with null arguments")
    void studentTest_createStudentWithNullArguments() {
        assertThrows(NoSuchElementException.class, () -> new Student(null));
    }
}
