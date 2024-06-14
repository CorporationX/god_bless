package faang.school.godbless.сalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Тестирование суммы")
    void testSum() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int expected = 15;

        int result = calculatorService.sum(nums);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тестирование умножения")
    void testProduct() {
        List<Integer> nums = List.of(3, 5, 10);
        int expected = 150;

        int result = calculatorService.product(nums);

        assertEquals(expected, result);
    }
}