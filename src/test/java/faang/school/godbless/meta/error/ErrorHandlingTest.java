package faang.school.godbless.meta.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ErrorHandlingTest {

    private static final String SUCCESS = "Success";
    private static final String FAIL = "Failed";
    private static final String VALID_PARAM = "VALID";
    private static final String INVALID_PARAM = "INVALID";

    @Test
    void whenWithErrorHandlingHasValidParamsThenSuccessful() {
        String result = ErrorHandling.withErrorHandling(
            () -> RemoteService.call(VALID_PARAM), e -> {
                fail();
                return null;
            }
        );

        assertEquals(SUCCESS, result);
    }

    @Test
    void whenWithErrorHandlingHasInvalidParamsThenFailed() {
        String result = ErrorHandling.withErrorHandling(
            () -> RemoteService.call(INVALID_PARAM), e -> {
                assertEquals(FAIL, e.getMessage());
                return "SMTH";
            }
        );

        assertEquals("SMTH", result);
    }

    private static class RemoteService {
        static String call(String param) {
            if (param.equals(VALID_PARAM)) {
                return SUCCESS;
            } else {
                throw new RuntimeException(FAIL);
            }
        }
    }
}