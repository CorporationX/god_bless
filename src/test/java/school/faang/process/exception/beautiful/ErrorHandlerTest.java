package school.faang.process.exception.beautiful;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorHandlerTest {
    private Supplier<String> action;
    private Supplier<String> actionWithError;
    private ExceptionHandler<String> handler;

    @BeforeEach
    public void setUp() {
        action = () -> RemoteService.call("someParam");
        actionWithError = () -> RemoteService.callWithErrors("someParam");
        handler = exception -> {
            System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        };
    }

    @Test
    void callServiceTest() {
        String expected = "someParam";
        String actual = ErrorHandler.withErrorHandling(action, handler);
        assertEquals(expected, actual);
    }

    @Test
    void callServiceWithErrorTest() {
        String expected = "DEFAULT";
        String actual = ErrorHandler.withErrorHandling(actionWithError, handler);
        assertEquals(expected, actual);
    }
}
