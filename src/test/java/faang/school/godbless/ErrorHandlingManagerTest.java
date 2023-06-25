package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlingManagerTest {

    @Test
    public void testWithErrorHandling_SuccessfulAction() {
        String result = ErrorHandlingManager.withErrorHandling(() -> "Success", e -> "Exception occurred");

        assertEquals("Success", result);
    }
    @Test
    public void testWithErrorHandling_ExceptionOccurred() {
        Supplier<String> action = () -> {
            throw new RuntimeException("Some exception");
        };

        String result = ErrorHandlingManager.withErrorHandling(action, e -> "Exception occurred");

        assertEquals("Exception occurred", result);
    }

}