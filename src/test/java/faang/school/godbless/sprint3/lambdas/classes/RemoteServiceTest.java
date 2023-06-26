package faang.school.godbless.sprint3.lambdas.classes;

import faang.school.godbless.sprint3.errorHandler.classes.RemoteService;
import faang.school.godbless.sprint3.errorHandler.interfaces.ExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class RemoteServiceTest {
    private static final String DONE_MESSAGE = "done";
    private static final String DEFAULT_VALUE = "default";
    private final static Supplier<String> supplierWithoutException = () -> DONE_MESSAGE;
    private final static Supplier<String> supplierWithException = RemoteServiceTest::getException;
    private final static ExceptionHandler<String> handler = (exception) -> DEFAULT_VALUE;

    @Test
    @DisplayName("withErrorHandling test positive")
    void withErrorHandling_positiveTest() {
        Assertions.assertEquals(DONE_MESSAGE, RemoteService.withErrorHandling(supplierWithoutException, handler));
    }

    @Test
    @DisplayName("withErrorHandling test negative")
    void withErrorHandling_negativeTest() {
        Assertions.assertEquals(DEFAULT_VALUE, RemoteService.withErrorHandling(supplierWithException, handler));
    }

    public static String getException() {
        throw new IllegalArgumentException("Error");
    }
}