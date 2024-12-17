package school.faang.sprint_2.task_46310;

import org.junit.jupiter.api.Test;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {

    @Test
    void testWithErrorHandling_SuccessfulExecution() {
        Action<String> action = () -> "Success";

        Function<Exception, String> errorHandler = e -> "Error";

        String result = ErrorHandler.withErrorHandling(action, errorHandler);

        assertEquals("Success", result);
    }

    @Test
    void testWithErrorHandling_ExceptionHandled() {
        Action<String> action = () -> {
            throw new Exception("Test Exception");
        };

        Function<Exception, String> errorHandler = e -> {
            assertEquals("Test Exception", e.getMessage());
            return "Default Value";
        };

        String result = ErrorHandler.withErrorHandling(action, errorHandler);

        assertEquals("Default Value", result);
    }

    @Test
    void testWithErrorHandling_IntegerResult() {
        Action<Integer> action = () -> 42;

        Function<Exception, Integer> errorHandler = e -> 0;

        Integer result = ErrorHandler.withErrorHandling(action, errorHandler);

        assertEquals(42, result);
    }

    @Test
    void testWithErrorHandling_IntegerExceptionHandled() {
        Action<Integer> action = () -> {
            throw new Exception("Division by zero");
        };

        Function<Exception, Integer> errorHandler = e -> {
            assertEquals("Division by zero", e.getMessage());
            return -1;
        };

        Integer result = ErrorHandler.withErrorHandling(action, errorHandler);

        assertEquals(-1, result);
    }
}
