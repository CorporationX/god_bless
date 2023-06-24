package Sprint_3_Test11;


import Sprint_3_Task11.ExceptionHandler;
import Sprint_3_Task11.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class MainTest {
    @Test
    void testWithErrorHandling() {
        Supplier<String> stringSupplier = () -> "Hello";
        ExceptionHandler<String> exceptionHandler = (exception) -> exception.getMessage() + "Nikita";
        Assertions.assertEquals("Hello", Main.withErrorHandling(stringSupplier,exceptionHandler));
    }
    @Test
    void testWithErrorHandlingException(){
        Supplier<String> stringSupplier = () -> {
            String[] stringsArray = {"", "Nikita", "Hello"};
            return stringsArray[3];
        };
        ExceptionHandler<String> exceptionHandler = (exception) -> exception.getMessage() + " Nikita";
        Assertions.assertEquals("Index 3 out of bounds for length 3 Nikita", Main.withErrorHandling(stringSupplier,exceptionHandler));
    }
}
