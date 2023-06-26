package faang.school.godbless.lambda.calculator;

import faang.school.godbless.lambda.calculator.GoogleCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoogleCalculatorTest {

    @Test
    public void testSumCorrect() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        int result = GoogleCalculator.sum(nums);
        int expected = 15;

        assertEquals(expected, result);
    }

    @Test
    public void testMulCorrect() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        int result = GoogleCalculator.product(nums);
        int expected = 120;

        assertEquals(expected, result);
    }

    @Test
    public void testMulWithOnes() {
        List<Integer> nums = List.of(1, 1, 1, 1, 1);

        int result = GoogleCalculator.product(nums);
        int expected = 1;

        assertEquals(expected, result);
    }

    @Test
    public void testSumWithNegativeNumbers() {
        List<Integer> nums = List.of(1, -1, 2, -2, 10, -15);

        int result = GoogleCalculator.sum(nums);
        int expected = -5;

        assertEquals(expected, result);
    }

    @Test
    public void testSumEmptyList() {
        List<Integer> nums = new ArrayList<>();

        assertThrows(IllegalArgumentException.class,() -> GoogleCalculator.sum(nums), "������ ����� ����� null ��� ����!");
    }

    @Test
    public void testSingletonList() {
        List<Integer> nums = Collections.singletonList(1);

        int result = GoogleCalculator.sum(nums);
        int expected = 1;

        assertEquals(expected, result);
    }
}