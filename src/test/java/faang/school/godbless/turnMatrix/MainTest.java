package faang.school.godbless.turnMatrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testFlipMatrix() {
        int[][] matrix = {{1, 2},
                          {3, 4}};
        int[][] horizontalResult = {{2, 1},
                                    {4, 3}};
        int[][] verticalResult = {{3, 4},
                                  {1, 2}};

        Assertions.assertArrayEquals(verticalResult,Main.flipMatrix(matrix, FlipDirection.VERTICAL));
        Assertions.assertArrayEquals(horizontalResult,Main.flipMatrix(matrix, FlipDirection.HORIZONTAL));
    }
}