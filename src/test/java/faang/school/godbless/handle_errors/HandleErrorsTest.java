package faang.school.godbless.handle_errors;

import faang.school.godbless.sprint2.Handle_errors.HandleErrors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleErrorsTest {
    @Test
    public void tesWithErrorHandling_SuccessfulAction() {
        String expected = "Test";
        String result = HandleErrors.withErrorHandling(
                () -> "Test",
                e -> null
        );

        assertEquals(expected, result);
    }

    @Test
    public void testWithErrorHandling_ExceptionInAction() {
        String expected2 = "Test";
        String result = HandleErrors.withErrorHandling(
                () -> {
                    throw new IllegalArgumentException();
                },
                e -> "Test"
        );

        assertEquals(expected2, result);
    }
}
