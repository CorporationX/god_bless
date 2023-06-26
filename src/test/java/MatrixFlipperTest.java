import faang.school.godbless.rotateMatrix.FlipDirection;
import faang.school.godbless.rotateMatrix.MatrixFlipper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixFlipperTest {
    @Test
    public void matrixFlipperVerticalTest() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {3, 4},
                {1, 2}
        };

        int[][] test = MatrixFlipper.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expected, test);
    }
    @Test
    public void matrixFlipperHorizontalTest() {
        int [][] matrix = {
                {1, 2},
                {3, 4}
        };

        int [][] expected = {
                {2, 1},
                {4, 3}
        };

        int [][] test = MatrixFlipper.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, test);
    }
}
