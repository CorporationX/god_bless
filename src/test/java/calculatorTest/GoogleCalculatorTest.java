package calculatorTest;

import faang.school.godbless.Calculator.function.GooglCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleCalculatorTest {

    List<Integer> list = List.of(2, 3, 4);

    @Test
    public void testProduct() {
        int expected = 24;
        int result = GooglCalculator.product(list);

        assertEquals(expected, result);
    }

    @Test
    public void testSum() {
        int expected = 9;
        int result = GooglCalculator.sum(list);

        assertEquals(expected, result);
    }

    @Test
    public void testProductIllegalArgumentException() {
        List<Integer> list1 = List.of();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GooglCalculator.product(list1);
        });

        String expectedMessage = "empty list";
        String resultMessage = exception.getMessage();
        assertTrue(resultMessage.equals(expectedMessage));
    }
}
