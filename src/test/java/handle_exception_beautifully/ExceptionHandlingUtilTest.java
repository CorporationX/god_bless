package handle_exception_beautifully;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingUtilTest {

    @Test
    public void tesWithErrorHandling_SuccessfulAction() {
        String result = ExceptionHandlingUtil.withErrorHandling(
                () -> "Successful result",
                e -> {
                    Assertions.fail("onError should not be called");
                    return null; // unreachable code
                }
        );

        Assertions.assertEquals("Successful result", result);
    }

    @Test
    public void testWithErrorHandling_ExceptionInAction() {
        String result = ExceptionHandlingUtil.withErrorHandling(
                () -> {
                    throw new IllegalArgumentException("Exception in action");
                },
                e -> {
                    Assertions.assertEquals("Exception in action", e.getMessage());
                    return "Default value";
                }
        );

        Assertions.assertEquals("Default value", result);
    }
}