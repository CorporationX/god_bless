package faang.school.godbless;

import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorHandlerTest {
    @Test
    void testWithoutErrorHandling() {
        Supplier<Integer> action = () -> 5;
        ExceptionHandler<Integer> exceptionHandler = e -> 0;

        var result = ErrorHandler.withErrorHandling(action, exceptionHandler);
        assertEquals(result, 5);
    }

    @Test
    void testWithErrorHandling() {
        Supplier<Integer> action = () -> {
            throw new RuntimeException();
        };
        ExceptionHandler<Integer> exceptionHandler = e -> -1;

        var result = ErrorHandler.withErrorHandling(action, exceptionHandler);
        assertEquals(result, -1);
    }
}