package faang.school.godbless.error_prettifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrettyErrorTest {
    @Test
    void testWithErrorHandlingSuccess() {
        // Assert
        assertEquals("Success", PrettyError.withErrorHandling(() -> "Success", (e) -> System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение" + e.toString())));
    }

    @Test
    void testWithErrorHandlingException() {
        assertThrows(RuntimeException.class, () -> PrettyError.withErrorHandling(() -> { throw new RuntimeException("Custom Error"); }, (e) -> System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение: " + e.toString())));
    }
}