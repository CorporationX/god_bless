package calculator_test;

import calculator.CalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class CalculatorTest {

    @Test
    public void testProduct() {
        List<Integer> numbers = List.of(2, 3, 4, 5);

        int expectedResult = 2 * 3 * 4 * 5;
        int actualResult = CalculatorImpl.product(numbers);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testProductWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();

        int expectedResult = 0;
        int actualResult = CalculatorImpl.product(numbers);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int expectedResult = 1 + 2 + 3 + 4 + 5;
        int actualResult = CalculatorImpl.sum(numbers);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSumWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();

        int expectedResult = 0;
        int actualResult = CalculatorImpl.sum(numbers);

        Assertions.assertEquals(expectedResult,actualResult);
    }
}
