package Matrix;

import faang.school.godbless.Matrix.FlipDirection;
import org.junit.jupiter.api.Test;

import static faang.school.godbless.Matrix.Application.flipMatrix;
import static org.junit.jupiter.api.Assertions.*;

public class TestFlip {
    private final int[][] matrix = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

    @Test
    void testHorizontalFlip() {
        int[][] expectedHorizontal = {{3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}};

        int[][] flippedHorizontal = flipMatrix(matrix, FlipDirection.HORIZONTAL);

        assertArrayEquals(expectedHorizontal, flippedHorizontal);
    }

    @Test
    void testVerticalFlip() {
        int[][] expectedVertical = {{7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}};

        int[][] flippedVertical = flipMatrix(matrix, FlipDirection.VERTICAL);

        assertArrayEquals(expectedVertical, flippedVertical);
    }

    @Test
    void borderCases() {
        int[][] oneElement = {{1}};
        int[][] empty = new int[0][0];

        int[][] flippedOneElement = flipMatrix(oneElement, FlipDirection.HORIZONTAL);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> flipMatrix(empty, FlipDirection.HORIZONTAL));

        assertArrayEquals(oneElement, flippedOneElement);
        assertEquals("Empty matrix", illegalArgumentException.getMessage());
    }
}
