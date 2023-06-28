package faang.school.godbless.lambda_stream.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    List<Integer> nums = List.of(2, 3, 45, 66, 55);

    @Test
    void sumTest() {
        assertEquals(171, Solution.sum(nums));
    }

    @Test
    void productTest() {
        assertEquals(980100, Solution.product(nums));
    }
}