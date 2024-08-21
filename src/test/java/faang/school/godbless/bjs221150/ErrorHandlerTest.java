package faang.school.godbless.bjs221150;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorHandlerTest {

    @Test
    public void testErrorHandlerSuccess() {
        Supplier<String> action = () -> "success";
        ExceptionHandler<String> onError = (e) -> "DEFAULT";

        String result = ErrorHandlerUtils.withErrorHandling(action, onError);
        assertEquals("success", result);
    }

    @Test
    public void testErrorHandlerFail() {
        Supplier<String> action = () -> {
            throw new RuntimeException("e");
        };
        ExceptionHandler<String> onError = (e) -> "DEFAULT";

        String result = ErrorHandlerUtils.withErrorHandling(action, onError);
        assertEquals("DEFAULT", result);
    }
}