package sprint3.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint3.lambda.calculator.HandheldCalculator;

import java.util.ArrayList;
import java.util.List;

public class HandheldCalculatorTest {
    private final List<Integer> nums = List.of(1,2,5,11,2,4);

    @Test
    public void shouldReturnSumOfAllNumbers() {
        int expectedNum = 25;
        int actualNum = HandheldCalculator.sum(nums);

        Assertions.assertEquals(expectedNum, actualNum);
    }

    @Test
    public void shouldReturnProductOfAllNumbers() {
        int expectedNum = 880;
        int actualNum = HandheldCalculator.product(nums);

        Assertions.assertEquals(expectedNum, actualNum);
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                HandheldCalculator.sum(new ArrayList<>()));
    }
}
