package school.faang.godbless.bjs2_33956;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixManagerTest {

    @Test
    void testVertical() {
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected1 = {
                {3, 4},
                {1, 2}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {3, 5, 6},
                {7, 8, 9}
        };
        int[][] expected2 = {
                {7, 8, 9},
                {3, 5, 6},
                {1, 2, 3}
        };

        assertArrayEquals(expected1, MatrixManager.flipMatrix(matrix1, MatrixManager.FlipDirection.VERTICAL));
        assertArrayEquals(expected2, MatrixManager.flipMatrix(matrix2, MatrixManager.FlipDirection.VERTICAL));
    }

    @Test
    void testHorizontal() {
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected1 = {
                {2, 1},
                {4, 3}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {3, 5, 6},
                {7, 8, 9}
        };
        int[][] expected2 = {
                {3, 2, 1},
                {6, 5, 3},
                {9, 8, 7}
        };

        assertArrayEquals(expected1, MatrixManager.flipMatrix(matrix1, MatrixManager.FlipDirection.HORIZONTAL));
        assertArrayEquals(expected2, MatrixManager.flipMatrix(matrix2, MatrixManager.FlipDirection.HORIZONTAL));
    }
}