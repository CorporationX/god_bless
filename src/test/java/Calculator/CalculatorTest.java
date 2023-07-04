package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculatorTest {
    Calculator calculator;
    List<Integer> numbers;

    @BeforeEach
    void init() {
        numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        calculator = (first, second) -> first + second;
    }

    @Test
    @DisplayName("method test calculateTest")
    void calculateTest() {

        int result = Main.calculate(numbers, calculator);
        int expected = 55;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("empty list test")
    void calculateThrowIAETest() {
        List<Integer> arr = List.of();

        assertThrows(IllegalArgumentException.class, () -> Main.calculate(arr, calculator));
    }

    @Test
    @DisplayName("test method productTest")
    void productTest() {
        int result = Main.product(numbers);
        int expected = 3628800;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("test method sumTest")
    void sumTest() {

        int result = Main.sum(numbers);
        int expected = 55;

        assertEquals(expected, result);
    }
}
