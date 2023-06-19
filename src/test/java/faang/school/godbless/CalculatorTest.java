package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class CalculatorTest {
    List<Integer> nums;

    @BeforeEach
    public void setUp() {
        nums = List.of(1, 4, 2, 3);
    }

    @Test
    public void testProduct() {
        int expectedResult = 24;

        int actualResult = Calculator.product(nums);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSum() {
        int expectedResult = 10;

        int actualResult = Calculator.sum(nums);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateEmptyList() {
        List<Integer> emptyList = Collections.emptyList();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.sum(emptyList));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.product(emptyList));
    }
}
