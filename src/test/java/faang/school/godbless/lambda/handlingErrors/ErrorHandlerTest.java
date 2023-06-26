package faang.school.godbless.lambda.handlingErrors;

import faang.school.godbless.lambda.handlingErrors.ErrorHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {

    @Test
    public void testFunction() {
        String val = ErrorHandler.withErrorHandling(10, (param) -> String.valueOf(param), (error) -> error.getMessage());
        assertEquals("10", val);
    }

    @Test
    public void testError() {
        int val = ErrorHandler.withErrorHandling("10p", (param) -> Integer.parseInt(param),
                (error) -> 1);
        assertEquals(1, val);
    }
}