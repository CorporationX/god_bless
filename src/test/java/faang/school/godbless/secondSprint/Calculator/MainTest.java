package faang.school.godbless.secondSprint.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    List<Integer> nums;

    @BeforeEach
    public void setUp() {
        nums = List.of(7, 6, 2);
    }

    @Test
    public void testSumReturnCorrectValue() {
        int result = Main.sum(nums);
        int expected = 0;
        for (Integer num : nums) {
            expected += num;
        }

        assertEquals(expected, result);
    }

    @Test
    public void testProductReturnCorrectValue() {
        int result = Main.product(nums);
        int expected = 1;
        for (Integer num : nums) {
            expected *= num;
        }

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateThrowExc() {
        assertThrows(IllegalArgumentException.class, () -> Main.sum(List.of()));
        assertThrows(IllegalArgumentException.class, () -> Main.product(List.of()));
    }

}