package faang.school.godbless.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void product_shouldReturnProductOfNums() {
        var result = Main.product(List.of(1, 2, 3, 4, 5));
        assertEquals(120, result);
    }

    @Test
    public void product_shouldReturnSumOfNums() {
        var result = Main.sum(List.of(1, 2, 3, 4, 5));
        assertEquals(15, result);
    }
}
