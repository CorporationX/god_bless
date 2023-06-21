package faang.school.godbless.secondSprint.ErrorProcessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {
    @Test
    public void testWithErrorHandlingReturnCorrectValue() {
        String result = ErrorHandler.withErrorHandling(
                () -> "correct message",
                (exc) -> {
                    exc.printStackTrace();
                    return "find exception";
                });
        String expected = "correct message";

        assertEquals(expected, result);
    }

    @Test
    public void testWithErrorHandlingReturnExc() {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    throw new IllegalArgumentException("I'm exception");
                },
                (exc) -> {
                    assertEquals("I'm exception", exc.getMessage());
                    return "find exception";
                }
        );
        String expected = "find exception";

        assertEquals(expected, result);
    }
}