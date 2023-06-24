package faang.school.godbless.rotate.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void flipMatrix_CorrectAnswerHorizontal() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {2, 1},
                {4, 3}
        };
        int[][] result = Martix.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, result);
    }

    @Test
    void flipMatrix_CorrectAnswerVertical() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {3, 4},
                {1, 2}
        };
        int[][] result = Martix.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expected, result);
    }

}