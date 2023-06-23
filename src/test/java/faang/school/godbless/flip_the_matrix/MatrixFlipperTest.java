package faang.school.godbless.flip_the_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatrixFlipperTest {

    @Test
    void testFlipMatrix_ShouldThrowException_IfFlipDirectionDoesNotExist() {
        String message = "Invalid flip direction";

        assertThrows(IllegalArgumentException.class, () ->
                new MatrixFlipper().flipMatrix(new int[0][0], FlipDirection.UP), message);
    }

    @Test
    void testFlipMatrix_ShouldTurnArrayVertical_IfFlipDirectionIsVertical(){
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] actualOutput = new MatrixFlipper().flipMatrix(array, FlipDirection.VERTICAL);
        int [][] expectedOutput = {{7,8,9},{4,5,6},{1,2,3}};

        assertArrayEquals(expectedOutput,actualOutput);
    }

    @Test
    void testFlipMatrix_ShouldTurnArrayHorizontal_IfFlipDirectionIsHorizontal(){
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] actualOutput = new MatrixFlipper().flipMatrix(array, FlipDirection.HORIZONTAL);
        int [][] expectedOutput = {{3,2,1},{6,5,4},{9,8,7}};

        assertArrayEquals(expectedOutput,actualOutput);
    }
}
