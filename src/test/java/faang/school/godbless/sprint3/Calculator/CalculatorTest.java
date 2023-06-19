package faang.school.godbless.sprint3.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private List<Integer> nums;

    @BeforeEach
    void setUp() {
        nums = List.of(5, 2, 1);
    }

    @Test
    void calculate_shouldReturnSumOfNumbers() {
        int expected = 8;
        assertEquals(expected, Calculator.calculate(nums, Integer::sum));
    }

    @Test
    void calculate_shouldReturnProductOfNumbers() {
        int expected = 10;
        assertEquals(expected, Calculator.calculate(nums, (a, b) -> a * b));
    }

    @Test
    void calculate_shouldReturnDifOfNumbers() {
        int expected = 2;
        assertEquals(expected, Calculator.calculate(nums, (a, b) -> a - b));
    }

    @Test
    void calculate_shouldReturnQuotientOfNumbers() {
        int expected = 2;
        assertEquals(expected, Calculator.calculate(nums, (a, b) -> a / b));
    }

    @Test
    void sum() {
        int a = 5;
        int b = 7;
        int expected = a + b;
        assertEquals(expected, Calculator.sum(List.of(a, b)));
    }

    @Test
    void product() {
        int a = 5;
        int b = 7;
        int c = 13;
        int expected = a * b * c;
        assertEquals(expected, Calculator.product(List.of(a, b, c)));
    }
}