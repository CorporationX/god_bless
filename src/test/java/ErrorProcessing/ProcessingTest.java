package ErrorProcessing;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static faang.school.godbless.ErrorProcessing.ExceptionUtil.withErrorHandling;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessingTest {
    @Test
    void processingTest() {
        Supplier<String> stringSupplier = () -> "Hello".concat(" World!");

        String exceptionHandlerTest = withErrorHandling(() -> {
            throw new IllegalArgumentException("Hello");
        }, Throwable::getMessage);
        String supplierTest = withErrorHandling(stringSupplier, Throwable::getMessage);

        assertEquals("Hello", exceptionHandlerTest);
        assertEquals("Hello World!", supplierTest);
    }
}
