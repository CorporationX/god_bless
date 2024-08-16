package faang.school.godbless.BJS2_21107;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionHandlerServiceTest {

    @Test
    public void testWithErrorHandling_Success() {
        String result = ExceptionHandlerService.withErrorHandling(() -> "Hello", e -> {
            throw new IllegalArgumentException("Should not reach here");
        });
        assertEquals("Hello", result);
    }

    @Test
    public void testWithErrorHandling_Error() {
        String exceptionMessage = ExceptionHandlerService.withErrorHandling(() -> {
            throw new RuntimeException("Test");
        }, e -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        });

        assertEquals("DEFAULT", exceptionMessage);
    }
}
