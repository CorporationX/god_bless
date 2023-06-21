package faang.school.godbless.sprint2.transformMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFlipperTest {
    @Test
    public void matrixFlipperVerticalTest(){
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {3, 4},
                {1, 2}
        };

        int[][] result = MatrixFlipper.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expected, result);
    }
    @Test
    public void matrixFlipperHorizontalTest(){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };

        int[][] result = MatrixFlipper.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, result);
    }


}