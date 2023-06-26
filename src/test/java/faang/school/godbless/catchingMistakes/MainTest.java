package faang.school.godbless.catchingMistakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Supplier<String> supplier;
    ExceptionHandler<String> handler;

    @Test
    void testWithoutErrorHandling() {
        supplier = ()-> {
            return "String";
        };
        handler = (e)-> {
            return e.getMessage();
        };
        Assertions.assertEquals("String",Main.withErrorHandling(supplier,handler));
    }

    @Test
    void testWithErrorHandling() {
        supplier = ()-> {
            throw new NullPointerException("String is empty");
        };
        handler = (e)-> {
            return e.getMessage();
        };
        Assertions.assertEquals("String is empty",Main.withErrorHandling(supplier,handler));
    }
}