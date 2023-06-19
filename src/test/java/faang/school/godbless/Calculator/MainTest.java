package faang.school.godbless.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MainTest {

    private List<Integer> nums;

    @BeforeEach
    void setUp() {
        nums = Arrays.asList(5, 5, 5, 5, 5);
    }

    @Test
    void testProductList() {
        Assertions.assertEquals(3125, Main.product(nums));
    }

    @Test
    void testSumList() {
        Assertions.assertEquals(25, Main.sum(nums));
    }
}