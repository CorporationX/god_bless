package school.faang.bjs2_80101;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.function.Function;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ErrorHandlerTest {
    private static final int DEFAULT_VALUE = -1;

    @Test
    void shouldHandleException() {
        Supplier<Integer> mainAction = () -> 5 / 0;
        Function<Exception, Integer> errorHandler = exception -> {
            log.info("Ошибка при выполнении действия: {}", exception.getMessage());
            return DEFAULT_VALUE;
        };

        int actual = ErrorHandler.withErrorHandling(mainAction, errorHandler);

        assertEquals(DEFAULT_VALUE, actual);
    }
}