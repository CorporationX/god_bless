package calculator;

import faang.school.godbless.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculatorTest {

    @Test
    void testSum() {
        Assertions.assertEquals(5, Calculator.sum(List.of(1, 1, 1, 2)));
    }

    @Test
    void testProduct() {
        Assertions.assertEquals(2, Calculator.product(List.of(1, 1, 1, 2)));
    }
}
