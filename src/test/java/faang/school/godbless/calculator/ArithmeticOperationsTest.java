package faang.school.godbless.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArithmeticOperationsTest {

    @Test
    void testCalculateMethod_ShouldThrowIllegalArgumentException_IfListIsEmpty() {
        List<Integer> nums = new ArrayList<>();

        IllegalArgumentException myException = assertThrows(IllegalArgumentException.class, () ->
                ArithmeticOperations.calculate(nums, Integer::sum));

        assertTrue(myException.getMessage().contains("List can't be empty"));
    }

    @Test
    void testCalculateMethod_ShouldThrowIllegalArgumentException_IfListArgumentIsNull() {
        IllegalArgumentException myException = assertThrows(IllegalArgumentException.class, () ->
                ArithmeticOperations.calculate(null, Integer::sum));

        assertTrue(myException.getMessage().contains("List can't be null"));
    }

    @Test
    void testCalculate() {
        List<Integer> nums = List.of(2, 4, 6, 8);
        int actualOutput = ArithmeticOperations.calculate(nums, Integer::sum);
        int expectedOutput = 20;

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
    void testSum() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int actualOutput = ArithmeticOperations.sum(nums);
        int expectedOutput = 10;

        assertEquals(expectedOutput, actualOutput);
    }
}
