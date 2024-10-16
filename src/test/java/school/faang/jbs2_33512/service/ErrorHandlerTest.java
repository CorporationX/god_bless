package school.faang.jbs2_33512.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {

    @Test
    void withErrorHandling() {
        String resultIfException = ErrorHandler.withErrorHandling(
                () -> {
                    throw new Exception();
                },
                e -> "TEST If Exception"
        );
        String correctResultIfException = "TEST If Exception";
        assertEquals(correctResultIfException, resultIfException);

        String resultIfNotException = ErrorHandler.withErrorHandling(
                () -> "Test if not Exception",
                e -> "TEST If Exception"
        );
        String correctResultIfNotException = "Test if not Exception";
        assertEquals(correctResultIfNotException,resultIfNotException);
    }
}