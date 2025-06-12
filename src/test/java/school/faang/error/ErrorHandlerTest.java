package school.faang.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorHandlerTest {
    @Test
    public void testWithErrorHandling() {
        Caller<String> caller = () -> {
            throw new RuntimeException("suction");
        };

        Recover<String> recover = e -> {
            System.out.println("system operation has been recovered");
            return "RECOVERED";
        };

        assertEquals("RECOVERED", ErrorHandler.withErrorHandling(caller, recover));
    }
}
