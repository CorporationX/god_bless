package dble.cache.test;

import dble.cache.Subject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubjectTest {
    @Test
    @DisplayName("Testing create Subject with null arguments")
    void subjectTest_createSubjectWithNullArguments() {
        assertThrows(NoSuchElementException.class, () -> new Subject(null));
    }
}
