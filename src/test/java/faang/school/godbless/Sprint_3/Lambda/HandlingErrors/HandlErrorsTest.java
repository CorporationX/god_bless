package faang.school.godbless.Sprint_3.Lambda.HandlingErrors;

import faang.school.godbless.Sprint_3.Lambda.HandlingErrors.HandlErrors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlErrorsTest {
    @Test
    public void withErrorHandlingTest() {
        String java = "Java";
        String test = HandlErrors.withErrorHandling(
                () -> "Java",
                (e) -> null);

        assertEquals(test, java);
    }

    @Test
    public void withErrorHandlingTest2() {
        String java = "Java";
        String test = HandlErrors.withErrorHandling(
                () -> {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                (e) -> {
                    System.out.println("returning null");
                    return null;});

        assertEquals(test, null);
    }
}