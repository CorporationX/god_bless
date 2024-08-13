package faang.school.godbless.BJS2_21107;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlerServiceTest {

    @Test
    public void testWithErrorHandling_Success() {
        String result = ExceptionHandlerService.withErrorHandling(() -> "Hello", e -> {
            throw new IllegalArgumentException("Should not reach here");
        });
        assertEquals("Hello", result);
    }

    @Test
    public void testWithErrorHandling_Error() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ExceptionHandlerService.withErrorHandling(() -> {
            throw new RuntimeException("Test");
        }, e -> {
            throw new IllegalArgumentException("Error to get item");
        }));

        assertEquals("Error to get item", exception.getMessage());
    }
}
