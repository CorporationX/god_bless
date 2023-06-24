package sprint3.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint3.lambda.matrix.FlipDirection;
import sprint3.lambda.matrix.MatrixHandler;

public class MatrixHandlerTest {
    private final int[][] matrix = {
            {1,2,3},
            {2,4,6},
            {3,6,9}
    };
    private final int[][] horizontalFlip = {
            {3,2,1},
            {6,4,2},
            {9,6,3}
    };
    private final int[][] verticalFlip = {
            {3,6,9},
            {2,4,6},
            {1,2,3}
    };


    @Test
    public void shouldReturnCorrectInvertedMatrix() {
        Assertions.assertArrayEquals(horizontalFlip, MatrixHandler.flipMatrix(matrix, FlipDirection.HORIZONTAL));
        Assertions.assertArrayEquals(verticalFlip, MatrixHandler.flipMatrix(matrix, FlipDirection.VERTICAL));
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                MatrixHandler.flipMatrix(matrix, FlipDirection.DIAGONAL));
    }
}
