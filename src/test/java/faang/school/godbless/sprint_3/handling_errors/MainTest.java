package faang.school.godbless.sprint_3.handling_errors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;
    Supplier<String> firstSupplier;
    Supplier<String> secondSupplier;
    ExceptionHandler<String> handler;

    @BeforeEach
    public void init() {
        main = new Main();
        firstSupplier = () -> main.getOrder(0);
        secondSupplier = () -> main.getOrder(7);
        handler = exception -> {
            exception.printStackTrace();
            return "Bottle of water";
        };
    }

    @Test
    public void withErrorHandlingTest() {
        String firstExpected = "Duck";
        String secondExpected = "Bottle of water";

        String firstResult = Main.withErrorHandling(firstSupplier, handler);
        String secondResult = Main.withErrorHandling(secondSupplier, handler);

        assertEquals(firstExpected, firstResult);
        assertEquals(secondExpected, secondResult);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> main.getOrder(7));
    }
}