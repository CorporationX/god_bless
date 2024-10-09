package dima.evseenko.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorHandlerTest {

    @Test
    void withErrorHandlingSuccess() {
        String result = ErrorHandler.withErrorHandling(() -> RemoteService.call("test"),
                (e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                })
        );

        assertEquals("calling test successful", result);
    }

    @Test
    void withErrorHandlingError() {
        String result = ErrorHandler.withErrorHandling(() -> RemoteService.call("error"),
                (e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                })
        );

        assertEquals("DEFAULT", result);
    }
}