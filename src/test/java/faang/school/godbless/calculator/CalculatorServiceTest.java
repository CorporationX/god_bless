package faang.school.godbless.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private static final List<Integer> NUMS = Arrays.asList(7, 2, 3, 4, 88, 3);
    private static final List<Integer> SINGLE_NUM = Collections.singletonList(7);

    @Nested
    @DisplayName("product test")
    class ProductTest {
        @Test
        void whenListIsNotEmptyThenProduct() {
            int expected = 7 * 2 * 3 * 4 * 88 * 3;
            int actual = CalculatorService.product(NUMS);

            assertEquals(expected, actual);
        }

        @Test
        public void whenSingletonListThenProduct() {
            int expected = 7;
            int actual = CalculatorService.product(SINGLE_NUM);

            assertEquals(expected, actual);
        }

        @Test
        public void whenListIsEmptyThenThrowExc() {
            List<Integer> emptyList = Collections.emptyList();

            assertThrows(IllegalArgumentException.class, () -> CalculatorService.product(emptyList));
        }
    }

    @Nested
    @DisplayName("sum test")
    class SumTest {
        @Test
        void whenListIsNotEmptyThenSum() {
            int expected = 7 + 2 + 3 + 4 + 88 + 3;
            int actual = CalculatorService.sum(NUMS);

            assertEquals(expected, actual);
        }

        @Test
        public void whenSingletonListThenSum() {
            int expected = 7;
            int actual = CalculatorService.sum(SINGLE_NUM);

            assertEquals(expected, actual);
        }

        @Test
        public void whenListIsEmptyThenThrowExc() {
            List<Integer> emptyList = Collections.emptyList();

            assertThrows(IllegalArgumentException.class, () -> CalculatorService.sum(emptyList));
        }
    }
}