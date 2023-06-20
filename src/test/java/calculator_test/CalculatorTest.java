package calculator_test;

import calculator.CalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculatorTest {
    @Test
    public void testProduct_WithNonEmptyList_ShouldCalculateProduct() {
        // Given
        List<Integer> nums = Arrays.asList(2, 3, 4);

        // When
        int result = CalculatorImpl.product(nums);

        // Then
        int expected = 2 * 3 * 4;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testProduct_WithEmptyList_ShouldThrowIllegalArgumentException() {
        // Given
        List<Integer> nums = Collections.emptyList();

        // When
        Assertions.assertThrows(IllegalArgumentException.class, () -> CalculatorImpl.product(nums));
    }


    @Test
    public void testSum_WithNonEmptyList_ShouldCalculateSum() {
        // Given
        List<Integer> nums = Arrays.asList(1, 2, 3);

        // When
        int result = CalculatorImpl.sum(nums);

        // Then
        int expected = 1 + 2 + 3;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSum_WithEmptyList_ShouldThrowIllegalArgumentException() {
        // Given
        List<Integer> nums = Collections.emptyList();

        // When
        Assertions.assertThrows(IllegalArgumentException.class, () -> CalculatorImpl.sum(nums));
    }
}
