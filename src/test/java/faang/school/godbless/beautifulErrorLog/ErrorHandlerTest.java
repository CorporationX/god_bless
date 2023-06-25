package faang.school.godbless.beautifulErrorLog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {
    @Test
    void testWithErrorHandling() {
        String msg = "An error occurred: ";
        Supplier<String> action = () -> "Hi!";
        Supplier<String> actionWithErr = () -> {
            String[] testData = {"Hi!", "world", "welcome"};
            return testData[3];
        };
        ExceptionHandler<String> handler = (exception) -> msg + exception.getMessage();
        assertEquals("Hi!", ErrorHandler.withErrorHandling(action, handler));
        assertEquals(msg + "Index 3 out of bounds for length 3",
                ErrorHandler.withErrorHandling(actionWithErr, handler));
    }
}