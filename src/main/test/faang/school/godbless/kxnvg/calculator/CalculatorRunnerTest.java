package faang.school.godbless.kxnvg.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRunnerTest {
    private List<Integer> nums;

    @BeforeEach
    void initList() {
        nums = List.of(1,2,3,4,5);
    }

    @Test
    void calculateProductTest() {
        int actual = CalculatorRunner.product(nums);
        int expected = 120;

        assertEquals(expected, actual);
    }

    @Test
    void calculateSumTest() {
        int actual = CalculatorRunner.sum(nums);
        int expected = 15;

        assertEquals(expected, actual);
    }

    @Test
    void calculateNullList() {
        assertThrows(NullPointerException.class, () -> CalculatorRunner.sum(null));
    }

    @Test
    void calculateEmptyList() {
        List<Integer> list = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> CalculatorRunner.product(list));
    }
}