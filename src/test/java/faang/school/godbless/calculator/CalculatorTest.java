package faang.school.godbless.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);

    @Test
    public void sum() {
        assertEquals(45, Calculator.sum(numbers));
    }

    @Test
    public void product() {
        assertEquals(362880, Calculator.product(numbers));
    }
}