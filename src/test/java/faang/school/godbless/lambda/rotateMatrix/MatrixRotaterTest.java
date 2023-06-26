package faang.school.godbless.lambda.rotateMatrix;

import faang.school.godbless.lambda.rotateMatrix.FlipDirection;
import faang.school.godbless.lambda.rotateMatrix.MatrixRotater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixRotaterTest {
    @Test
    public void testCorrectHorizontalSwap() {
        int[][] matrix = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        int[][] rotatedMatrix = MatrixRotater.flipMatrix(matrix, FlipDirection.HORIZONTAL);

        int[][] expected = new int[][] {{2, 1}, {4, 3}, {6, 5}};
        assertArrayEquals(expected, rotatedMatrix);
    }

    @Test
    public void testCorrectVerticalSwap() {
        int[][] matrix = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        int[][] rotatedMatrix = MatrixRotater.flipMatrix(matrix, FlipDirection.VERTICAL);

        int[][] expected = new int[][] {{5, 6}, {3, 4}, {1, 2}};
        assertArrayEquals(expected, rotatedMatrix);
    }

    @Test
    public void testCorrectHorizontalSwapOfSquareMatrix() {
        int[][] matrix = new int[][] {{1, 2}, {3, 4}};
        int[][] rotatedMatrix = MatrixRotater.flipMatrix(matrix, FlipDirection.HORIZONTAL);

        int[][] expected = new int[][] {{2, 1}, {4, 3}};
        assertArrayEquals(expected, rotatedMatrix);
    }

    @Test
    public void testCorrectVerticalSwapOfSquareMatrix() {
        int[][] matrix = new int[][] {{1, 2}, {3, 4}};
        int[][] rotatedMatrix = MatrixRotater.flipMatrix(matrix, FlipDirection.VERTICAL);

        int[][] expected = new int[][] {{3, 4}, {1, 2}};
        assertArrayEquals(expected, rotatedMatrix);
    }

    @Test
    public void testNotValidMatrix() {
        int[][] matrix = new int[][] {{1, 2}, {3, 4}, {5, 6, 7}};

        assertThrows(IllegalArgumentException.class, () -> MatrixRotater.flipMatrix(matrix, FlipDirection.HORIZONTAL),
                "���������� ������ �� �������� ��������!");
    }
}