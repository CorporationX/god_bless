package faang.school.godbless.func.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    @DisplayName("Product method should multiply elements of a given list")
    void testProductShouldMultiply() {
        int result = Calculation.product(List.of(1, 2, 3, 4, 5));

        assertEquals(120, result);
    }

    @Test
    @DisplayName("Product method should throw exception for null numbers")
    void testCalculateWithNullNumbersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Calculation.product(null));
    }

    @Test
    @DisplayName("Sum method should sum elements of a given list")
    void testSumShouldSum() {
        int result = Calculation.sum(List.of(1, 2, 3, 4, 5));

        assertEquals(15, result);
    }

    @Test
    @DisplayName("Sum method should throw exception for null numbers")
    void testSumWithNullNumbersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Calculation.sum(null));
    }
}