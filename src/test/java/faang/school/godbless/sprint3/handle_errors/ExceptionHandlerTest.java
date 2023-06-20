package faang.school.godbless.sprint3.handle_errors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlerTest {

    @Test
    void withErrorHandling_shouldPrintAndReturnExceptionMessage() {
        String expected = "DEFAULT";
        assertEquals(
                expected,
                ExceptionHandler.withErrorHandling(
                        () -> {
                            throw new RuntimeException("DEFAULT");
                        },
                        (e) -> {
                            System.out.println(e.getMessage());
                            return e.getMessage();
                        })
                );
    }

    @Test
    void withErrorHandling_shouldReturnExpectedObject() {
        String expected = "Some object";
        assertEquals(
                expected,
                ExceptionHandler.withErrorHandling(
                        () -> "Some object",
                        (e) -> {
                            System.out.println(e.getMessage());
                            return e;
                        })
        );
    }
}