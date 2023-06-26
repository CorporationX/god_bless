import faang.school.godbless.handleErrors.HandleErrors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleErrorsTest {
    @Test
    public void handleErrorsSuccessfulWithActivityTest() {
        String expected = "successful";
        String test = HandleErrors.withErrorHandling(
                () -> "successful",
                e -> null
        );
        assertEquals(expected, test);
    }
    @Test
    public void handleErrorsFailWithActivityTest() {
        String expected = "the first action is not completed";
        String test = HandleErrors.withErrorHandling(
                () -> {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> "the first action is not completed"
        );
        assertEquals(expected, test);
    }
}
