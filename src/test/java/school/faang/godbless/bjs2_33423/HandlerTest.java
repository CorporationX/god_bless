package school.faang.godbless.bjs2_33423;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {
    @Test
    void testWithNoException() {
        FromRemote<Integer> supplier = () -> 5;
        Function<Exception, Integer> handler = e -> -1;
        assertEquals(5, Handler.withErrorHandling(supplier, handler));
    }

    @Test
    void testWithException() {
        FromRemote<String> supplier = () -> {
            throw new Exception();
        };
        String returnedWhenException = "Handled";
        Function<Exception, String> handler = e -> "Handled";

        assertEquals(returnedWhenException, Handler.withErrorHandling(supplier, handler));
    }
}