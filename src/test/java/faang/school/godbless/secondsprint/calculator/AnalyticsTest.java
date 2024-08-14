package faang.school.godbless.secondsprint.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnalyticsTest {
    private List<Integer> nums;
    private int result;

    @Test
    @DisplayName("Should correctly calculate the sum of a list of numbers")
    public void testSum() {
        nums = Arrays.asList(1, 2, 3, 4, 5);
        result = Analytics.sum(nums);
        assertEquals(15, result, "The sum of [1, 2, 3, 4, 5] should be 15");
    }

    @Test
    @DisplayName("Should correctly calculate the product of a list of numbers")
    public void testProduct() {
        nums = Arrays.asList(1, 2, 3, 4);
        result = Analytics.product(nums);
        assertEquals(24, result, "The product of [1, 2, 3, 4] should be 24");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when list is null or empty")
    public void testCalculateWithNullList() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> Analytics.sum(null),
                        "Should throw IllegalArgumentException if list is null"),
                () -> assertThrows(IllegalArgumentException.class, () -> Analytics.sum(Collections.emptyList()),
                        "Should throw IllegalArgumentException if list is empty")
        );
    }

    @Test
    @DisplayName("Should correctly use custom Calculator to calculate (subtraction)")
    public void testCustomCalculator() {
        nums = Arrays.asList(2, 3, 4);
        result = Analytics.calculate(nums, (a, b) -> a - b);
        assertEquals(-5, result, "Custom calculator should correctly subtract the numbers in the list");
    }
}
