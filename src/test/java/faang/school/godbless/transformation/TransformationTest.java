package faang.school.godbless.transformation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformationTest {
    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    @Test
    void flipMatrixHorizontalTest() {
        int[][] exceptedMatrix = new int[][]{{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        int[][] flippedMatrix = Transformation.flipMatrix(matrix, Transformation.FlipDirection.HORIZONTAL);
        assertArrayEquals(exceptedMatrix, flippedMatrix);
    }

    @Test
    void flipMatrixVerticalTest() {
        int[][] exceptedMatrix = new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        int[][] flippedMatrix = Transformation.flipMatrix(matrix, Transformation.FlipDirection.VERTICAL);
        assertArrayEquals(exceptedMatrix, flippedMatrix);
    }
}