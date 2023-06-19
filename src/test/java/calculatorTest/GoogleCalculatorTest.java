package calculatorTest;

import faang.school.godbless.Calculator.function.GoogleCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoogleCalculatorTest {

    List<Integer> list = List.of(2, 3, 4);

    @Test
    public void testProduct() {
        int expected = 24;
        int result = GoogleCalculator.product(list);

        assertEquals(expected, result);
    }

    @Test
    public void testSum() {
        int expected = 9;
        int result = GoogleCalculator.sum(list);

        assertEquals(expected, result);
    }

    @Test
    public void testProductIllegalArgumentException() {
        List<Integer> list1 = List.of();

        assertThrows(IllegalArgumentException.class, () -> GoogleCalculator.product(list1), "empty list");
    }
}
