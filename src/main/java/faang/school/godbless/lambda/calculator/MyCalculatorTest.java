package faang.school.godbless.lambda.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {
    @Test
    void calculate() {
        assertThrows(IllegalArgumentException.class, () -> MyCalculator.calculate(new ArrayList<>(), (a, b) -> a * b));
    }

    @Test
    void product() {
        int expected = 12;
        int actual = MyCalculator.product(List.of(2, 2, 3));

        assertEquals(expected, actual);
    }

    @Test
    void sum() {
        int expected = 7;
        int actual = MyCalculator.sum(List.of(2, 2, 3));

        assertEquals(expected, actual);
    }
}