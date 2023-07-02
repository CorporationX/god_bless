package faang.school.godbless.exception_handle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionHandlerTest {
    @Test
    public void testExceptionHandlerPositive() {
        String result = ExceptionHandlerService.withErrorHandling(() -> "Successful result", e -> {
            return null;
        });
        assertEquals("Successful result", result);
    }

    @Test
    public void testExceptionHandlerNegative() {
        String result = ExceptionHandlerService.withErrorHandling(() -> {
            throw new IllegalArgumentException();
        }, e -> {
            return "Exception!";
        });

        assertEquals("Exception!", result);
    }
}
