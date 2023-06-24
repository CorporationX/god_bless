package faang.school.godbless.sprint3.HandlingErrorsBeautifully;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void withErrorHandlingTrue() throws Exception {
        Function<Integer, Integer> function = (b) -> b * 2;
        assertEquals(4, Main.withErrorHandling(2, function, (tmp) -> new Exception()));
    }

    @Test
    void withErrorHandlingFalse() throws Exception {
        Function<Integer, Integer> function = (b) -> b * 2;
        Exception err = assertThrows(Exception.class, () -> Main.withErrorHandling("False", function, (tmp) -> new Exception("Err")));
        System.out.println(err);
        assertEquals("Err",err.getMessage());
    }
}