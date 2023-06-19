package faang.school.godbless.error_exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlingTest {

    @Test
    public void testWithNoException() {
        int result = ErrorHandling.withErrorHandling(() -> 42, ex -> {
            throw new RuntimeException();
        });
        assertEquals(42, result);
    }

    @Test
    public void testWithException() {
        assertThrows(RuntimeException.class, () -> ErrorHandling.withErrorHandling
                (() -> Integer.parseInt("123abc"), ex -> {
                    throw new NumberFormatException();
                }));


    }
}