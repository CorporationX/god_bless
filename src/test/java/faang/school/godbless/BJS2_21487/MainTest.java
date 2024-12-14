package faang.school.godbless.BJS2_21487;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.BJS2_21487.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {

    @Test
    void testProductCorrect() {
        assertEquals(NUMBERS_PRODUCT_CORRECT, Main.product(NUMBERS));
    }

    @Test
    void testProductIncorrect() {
        assertNotEquals(NUMBERS_PRODUCT_INCORRECT, Main.product(NUMBERS));
    }

    @Test
    void testSumCorrect() {
        assertEquals(NUMBERS_SUM_CORRECT, Main.sum(NUMBERS));
    }

    @Test
    void testSumIncorrect() {
        assertNotEquals(NUMBERS_SUM_INCORRECT, Main.sum(NUMBERS));
    }

    @Test
    void testCalculateDifferenceCorrect() {
        assertEquals(NUMBERS_DIFFERENCE_CORRECT, Main.calculate(NUMBERS, (s, n) -> s - n));
    }

    @Test
    void testCalculateDifferenceIncorrect() {
        assertNotEquals(NUMBERS_DIFFERENCE_INCORRECT, Main.calculate(NUMBERS, (s, n) -> s - n));
    }
}