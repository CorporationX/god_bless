package faang.school.godbless.error_handling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorHandlingTest {


    @Test
    public void testWithNoException_ShouldReturnValue() {
        int expectedOutput = 1;
        int actualOutput = ErrorHandling.withErrorHandling(() -> 1, e -> {
            throw new RuntimeException();
        });

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWithException_ShouldThrowException() {
        List<Integer> list = new ArrayList<>();

        assertThrows(NullPointerException.class, () -> ErrorHandling.withErrorHandling
                (() -> list.get(10), e -> {
                    throw new NullPointerException();
                }));
    }
}
