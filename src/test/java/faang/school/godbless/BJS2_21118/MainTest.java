package faang.school.godbless.BJS2_21118;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    RemoteService remoteService = new RemoteService();

    @Test
    @DisplayName("Test successfully called method")
    void withErrorHandlingTest() {
        String param = "success";
        String result = Main.withErrorHandling(() -> remoteService.call(param), exception -> "default result");
        assertEquals(param, result);
    }

    @Test
    @DisplayName("Test handling exception and returning default result")
    void withErrorHandlingTest_shouldHandleException() {
        String param = "error";
        String expect = "default result";
        String result = Main.withErrorHandling(() -> remoteService.call(param), exception -> "default result");

        assertEquals(expect, result);
    }
}