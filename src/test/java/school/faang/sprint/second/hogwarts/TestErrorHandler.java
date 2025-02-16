package school.faang.sprint.second.hogwarts;

import org.junit.Assert;
import org.junit.Test;
import school.faang.sprint.second.exception.ErrorHandler;

public class TestErrorHandler {
    @Test
    public void testWithErrorHandling() {
        String result = ErrorHandler.withErrorHandling(() -> "Test", e -> "Error: " + e.getMessage());
        Assert.assertEquals("Test", result);
    }

    @Test
    public void testWithErrorHandlingWithDefaultResponse() {
        String result = ErrorHandler.withErrorHandling(() -> {
            throw new RuntimeException("Something wrong");
        }, e -> "Error: " + e.getMessage());
        Assert.assertEquals("Error: Something wrong", result);
    }


}
