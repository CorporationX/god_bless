package faang.school.godbless.BJS2_20498;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FlipDirectionTest {
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
    };

    @Test
    public void testHorizontalFlip() {
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4}
        };

        int[][] result = FlipDirection.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testVerticalFlip() {
        int[][] expected = {
                {4, 5, 6},
                {1, 2, 3}
        };

        int[][] result = FlipDirection.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expected, result);
    }
}
