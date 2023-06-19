package faang.school.godbless.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    void testCalculateMethod_ShouldThrowIllegalArgumentException_IfListIsEmpty() {
        List<Integer> nums = new ArrayList<>();
        String message = "List can't be null";

        assertThrows(IllegalArgumentException.class, () ->
                ArithmeticOperations.calculate(nums, Integer::sum), message);
    }

    @Test
    void testCalculateMethod_ShouldThrowIllegalArgumentException_IfListArgumentIsNull() {
        String message = "List can't be empty";

        assertThrows(IllegalArgumentException.class, () ->
                ArithmeticOperations.calculate(null, Integer::sum), message);
    }

    @Test
    void testCalculate() {
        List<Integer> nums = List.of(2, 4, 6, 8);
        int actualOutput = ArithmeticOperations.calculate(nums, Integer::sum);
        int expectedOutput = 20;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testCalculate_ifListHasOneValue() {
        List<Integer> nums = List.of(2);
        int actualOutput = ArithmeticOperations.calculate(nums, Integer::sum);
        int expectedOutput = 2;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testProduct() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int actualOutput = ArithmeticOperations.product(nums);
        int expectedOutput = 24;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testProduct_ifListHasOneValue() {
        List<Integer> nums = List.of(1);
        int actualOutput = ArithmeticOperations.product(nums);
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSum() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int actualOutput = ArithmeticOperations.sum(nums);
        int expectedOutput = 10;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSum_ifListHasOneValue() {
        List<Integer> nums = List.of(1);
        int actualOutput = ArithmeticOperations.sum(nums);
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }
}
