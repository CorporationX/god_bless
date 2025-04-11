package school.faang.bjs2_68745;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    @Test
    @DisplayName("Test create Subject with empty name")
    public void CreateSubjectWithEmptyNameTest() {
        assertThrows(NoSuchElementException.class, () -> new Subject(""));
    }

    @Test
    @DisplayName("Test create Subject with NULL name")
    public void CreateSubjectWithNullNameTest() {
        assertThrows(NoSuchElementException.class, () -> new Subject(null));
    }

    @Test
    @DisplayName("Test create Subject with NULL name")
    public void CreateSubjectNameTest() {
        Subject subject = new Subject("Subjects name");
        assertTrue("Subjects name".equals(subject.name()));
    }
}