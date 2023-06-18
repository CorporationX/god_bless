package faang.school.godbless.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private List<Integer> digits;

    @BeforeEach
    public void setUp() {
        this.digits = List.of(2, 5, 85, 74, 96, 6);
    }

    @Test
    void testSum_should_success() {
        assertEquals(268, CalculatorService.sum(digits));
    }

    @Test
    void testMultiply_should_success() {
        assertEquals(36230400, CalculatorService.multiply(digits));
    }

    @Test
    void test_should_sum_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> CalculatorService.sum(new ArrayList<>()));
    }

    @Test
    void test_should_multiply_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> CalculatorService.multiply(new ArrayList<>()));
    }
}