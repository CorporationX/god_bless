package faang.school.godbless.errors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class ErrorsTest {
    public Errors errors;

    @BeforeEach
    void setUp() {
        errors = new Errors();
    }

    @Test
    public void withErrorHandling_CorrectAnswer() {
        String result = errors.withErrorHandling(() -> "Correct Answer", (e -> ("incorrect answer")));
        assertEquals("Correct Answer", result);
    }
}