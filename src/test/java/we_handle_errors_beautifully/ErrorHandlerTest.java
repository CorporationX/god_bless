package we_handle_errors_beautifully;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorHandlerTest {
    @Test
    void withErrorHandling() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return Main.RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        assertEquals(
                "Ошибка при вызове сервиса, возвращаем дефолтное значение\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        assertEquals("DEFAULT", result);
    }
}