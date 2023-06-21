package faang.school.godbless.secondSprint.FlipMatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[][] matrix1;
    int[][] matrix2;

    @BeforeEach
    public void setUp() {
        matrix1 = new int[][]{
                {1, 2, 3},
                {9, 8, 7},
                {5, 6, 7}
        };
        matrix2 = new int[][]{
                {1, 2, 3, 4},
                {9, 8, 7, 6}
        };
    }

    @Test
    public void testFlipMatrixHorizontally() {
        int[][] result1 = Main.flipMatrix(matrix1, Main.FlipDirection.HORIZONTAL);
        int[][] result2 = Main.flipMatrix(matrix2, Main.FlipDirection.HORIZONTAL);
        int[][] expected1 = {
                {3, 2, 1},
                {7, 8, 9},
                {7, 6, 5}
        };
        int[][] expected2 = {
                {4, 3, 2, 1},
                {6, 7, 8, 9}
        };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }

    @Test
    public void testFlipMatrixVertically() {
        int[][] result1 = Main.flipMatrix(matrix1, Main.FlipDirection.VERTICAL);
        int[][] result2 = Main.flipMatrix(matrix2, Main.FlipDirection.VERTICAL);
        int[][] expected1 = {
                {5, 6, 7},
                {9, 8, 7},
                {1, 2, 3}
        };
        int[][] expected2 = {
                {9, 8, 7, 6},
                {1, 2, 3, 4}
        };

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }

    @Test
    public void testFlipMatrixWithEmptyMatrix() {
        int[][] result1 = Main.flipMatrix(new int[0][0], Main.FlipDirection.VERTICAL);
        int[][] result2 = Main.flipMatrix(new int[0][0], Main.FlipDirection.HORIZONTAL);

        assertArrayEquals(new int[0][0], result1);
        assertArrayEquals(new int[0][0], result2);
    }
}