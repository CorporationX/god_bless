package faang.school.godbless.sprint_3.handling_errors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;
    ExceptionHandler<String> handler;

    @BeforeEach
    public void init() {
        main = new Main();
        handler = exception -> {
            exception.printStackTrace();
            return "Bottle of water";
        };
    }

    @Test
    void withErrorHandlingFirstTest() {
        Supplier<String> firstSupplier = () -> main.getOrder(0);

        String expected = "Duck";
        String result = Main.withErrorHandling(firstSupplier, handler);

        assertEquals(expected, result);

    }

    @Test
    void withErrorHandlingSecondTest() {
        Supplier<String> secondSupplier = () -> main.getOrder(7);

        String secondExpected = "Bottle of water";
        String secondResult = Main.withErrorHandling(secondSupplier, handler);

        assertEquals(secondExpected, secondResult);
    }

    @Test
    void withErrorHandlingThrowArrayIndexOutOfBoundsException() {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> main.getOrder(7));
    }
}