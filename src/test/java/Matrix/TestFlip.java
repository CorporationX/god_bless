package Matrix;

import faang.school.godbless.Matrix.FlipDirection;
import org.junit.jupiter.api.Test;

import static faang.school.godbless.Matrix.Application.flipMatrix;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestFlip {
    @Test
    void flipTest() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] expectedHorizontal = {{3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}};
        int[][] expectedVertical = {{7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}};

        int[][] flippedHorizontal = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        int[][] flippedVertical = flipMatrix(matrix, FlipDirection.VERTICAL);

        assertArrayEquals(expectedHorizontal, flippedHorizontal);
        assertArrayEquals(expectedVertical, flippedVertical);
    }
}
