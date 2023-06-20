package faang.school.godbless.handle_errors;

import faang.school.godbless.sprint2.Handle_errors.HandleErrors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleErrorsTest {
    String expected = "Test1";
    String expected2 = "Test2";
    @Test
    public void tesWithErrorHandling_SuccessfulAction() {
        String result = HandleErrors.withErrorHandling(
                () -> "Test1",
                e -> null
        );

        assertEquals(expected, result);
    }

    @Test
    public void testWithErrorHandling_ExceptionInAction() {
        String result = HandleErrors.withErrorHandling(
                () -> {
                    throw new IllegalArgumentException();
                },
                e -> "Test2"
        );

        assertEquals(expected2, result);
    }
}
