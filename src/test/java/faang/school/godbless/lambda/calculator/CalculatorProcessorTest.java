package faang.school.godbless.lambda.calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorProcessorTest {

    @Test
    void testSum() {
        assertEquals(15, CalculatorProcessor.sum(Arrays.asList(3, 12, 0)));
    }

    @Test
    void testProduct() {
        assertEquals(0, CalculatorProcessor.product(Arrays.asList(3, 12, 0)));
        assertEquals(36, CalculatorProcessor.product(Arrays.asList(3, 12, 1)));
    }

    @Test
    void testCalculateWithEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> CalculatorProcessor.sum(Collections.emptyList()));
    }
}