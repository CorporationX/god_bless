package hashmap.group.test;

import hashmap.group.Student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {
    @Test
    @DisplayName("Test create student with null arguments")
    void studentTest_createWithNullArguments() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> new Student(null, "test", 1)),
                () -> assertThrows(NullPointerException.class, () -> new Student("test", null, 1))
        );
    }
}
