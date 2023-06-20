package faang.school.godbless.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.sprint2.calculator.Calculate.product;
import static faang.school.godbless.sprint2.calculator.Calculate.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    List<Integer> nums;

    @BeforeEach
    public void init() {
        nums = List.of(10, 5, 24);
    }

    @Test
    public void sumTest() {
        int result = sum(nums);
        int expected = 39;
        assertEquals(expected, result);
    }

    @Test
    public void productTest() {
        int result = product(nums);
        int expected = 1200;
        assertEquals(expected, result);
    }
}
