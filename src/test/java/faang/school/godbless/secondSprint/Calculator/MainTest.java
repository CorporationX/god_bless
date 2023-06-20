package faang.school.godbless.secondSprint.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    List<Integer> intNums;
    List<Double> doubleNums;

    @BeforeEach
    public void setUp() {
        intNums = List.of(7, 6, 2);
        doubleNums = List.of(7.0, 6.0, 2.0);
    }

    @Test
    public void testSumIntReturnCorrectValue() {
        int result = Main.sumInt(intNums);
        int expected = 0;
        for (Integer num : intNums) {
            expected += num;
        }

        assertEquals(expected, result);
    }

    @Test
    public void testSumDoubleReturnCorrectValue() {
        double result = Main.sumDouble(doubleNums);
        double expected = 0;
        for (Double num : doubleNums) {
            expected += num;
        }

        assertEquals(expected, result);
    }

    @Test
    public void testProductIntReturnCorrectValue() {
        int result = Main.productInt(intNums);
        int expected = 1;
        for (Integer num : intNums) {
            expected *= num;
        }

        assertEquals(expected, result);
    }

    @Test
    public void testProductDoubleReturnCorrectValue() {
        double result = Main.productDouble(doubleNums);
        double expected = 1;
        for (Double num : doubleNums) {
            expected *= num;
        }

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateThrowExc() {
        assertThrows(IllegalArgumentException.class, () -> Main.productInt(List.of()));
        assertThrows(IllegalArgumentException.class, () -> Main.sumInt(null));
        assertThrows(IllegalArgumentException.class, () -> Main.productDouble(List.of()));
        assertThrows(IllegalArgumentException.class, () -> Main.sumDouble(null));
    }
}