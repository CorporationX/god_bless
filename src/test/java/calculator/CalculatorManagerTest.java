package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorManagerTest {
    private final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5);

    @Test
    void calculate() {
        int result = CalculatorManager.calculate(NUMBERS, (a, b) -> (int) a - (int) b);
        assertEquals(-13, result);
    }

    @Test
    void sum() {
        int result = CalculatorManager.sum(NUMBERS);
        assertEquals(15, result);
    }

    @Test
    void product() {
        int result = CalculatorManager.product(NUMBERS);
        assertEquals(120, result);
    }
}