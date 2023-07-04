package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class ResourceAnalyticsTest {
    ResourceAnalytics resourceAnalytics;

    @BeforeEach
    void setUp() {
        resourceAnalytics = new ResourceAnalytics();
    }

    @Test
    void testMultiplication() throws IllegalAccessException {
        int actual = resourceAnalytics.calculate(Arrays.asList(2, 3, 4), (a, b) -> a * b);
        assertEquals(24, actual);
    }

    @Test
    void testAddition() throws IllegalAccessException {
        int actual = resourceAnalytics.calculate(Arrays.asList(0, 2, 3), Integer::sum);
        assertEquals(5, actual);
    }

    @Test
    void testInvalidArgument() {
        List<Integer> nums = new ArrayList<>();
        assertThrowsExactly(IllegalAccessException.class, () -> resourceAnalytics.calculate(nums, Integer::sum));
    }
}