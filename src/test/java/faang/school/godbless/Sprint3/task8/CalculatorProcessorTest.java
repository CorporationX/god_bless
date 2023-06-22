package faang.school.godbless.Sprint3.task8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorProcessorTest {

    @Test
    void testEmptyListCalculationIsInvalid() {
        List<Integer> emptyList = List.of();

        assertThrows(IllegalArgumentException.class, () -> CalculatorProcessor.calculate(emptyList, (a,b)->0));
    }

    @Test
    void testSum() {
        int expectedSum = 2 + 3 + 5;
        int actualSum = CalculatorProcessor.sum(List.of(2, 3, 5));

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testProduct() {
        int expectProduct = 2 * 3 * 5;
        int actualProduct = CalculatorProcessor.product(List.of(2, 3, 5));

        assertEquals(expectProduct, actualProduct);
    }
}