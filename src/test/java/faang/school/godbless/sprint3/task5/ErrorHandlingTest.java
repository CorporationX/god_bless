package faang.school.godbless.sprint3.task5;

import faang.school.godbless.sprint3.lambda.task5.ErrorHandling;
import faang.school.godbless.sprint3.lambda.task5.RemoteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlingTest {

    @Test
    void testWithErrorHandlingNegative() {
        ErrorHandling<Boolean> errorHandling = new ErrorHandling<>();

        boolean actual = errorHandling.withErrorHandling(
                () -> RemoteService.call(4),
                e -> {
                    System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                    return false;
                });

        assertFalse(actual);
    }

    @Test
    void testWithErrorHandlingPositive() {
        ErrorHandling<Boolean> errorHandling = new ErrorHandling<>();

        boolean actual = errorHandling.withErrorHandling(
                () -> RemoteService.call(1),
                e -> {
                    System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                    return false;
                });

        assertTrue(actual);
    }
}