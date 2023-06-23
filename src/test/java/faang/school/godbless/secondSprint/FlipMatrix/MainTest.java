package faang.school.godbless.secondSprint.FlipMatrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testFlipMatrix(int[][] matrix, int[][] expected, FlipDirection direction) {
        int[][] result = Main.flipMatrix(matrix, direction);

        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {9, 8, 7}, {5, 6, 7}}, new int[][]{{3, 2, 1}, {7, 8, 9}, {7, 6, 5}},
                        FlipDirection.HORIZONTAL),
                Arguments.of(new int[][]{{1, 2, 3}, {9, 8, 7}, {5, 6, 7}}, new int[][]{{5, 6, 7}, {9, 8, 7}, {1, 2, 3}},
                        FlipDirection.VERTICAL),
                Arguments.of(new int[][]{{1, 2, 3, 4}, {9, 8, 7, 6}}, new int[][]{{4, 3, 2, 1}, {6, 7, 8, 9}},
                        FlipDirection.HORIZONTAL),
                Arguments.of(new int[][]{{1, 2, 3, 4}, {9, 8, 7, 6}}, new int[][]{{9, 8, 7, 6}, {1, 2, 3, 4}},
                        FlipDirection.VERTICAL)
        );
    }

    @Test
    public void testFlipMatrixWith1x1Matrix() {
        int[][] result = Main.flipMatrix(new int[][]{{1}}, FlipDirection.HORIZONTAL);

        assertArrayEquals(new int[][]{{1}}, result);
    }

    @Test
    public void testFlipMatrixWith2Flip() {
        int[][] array = {{1, 2, 4}, {3, 5, 6}};
        int[][] result = Main.flipMatrix(Main.flipMatrix(array, FlipDirection.HORIZONTAL), FlipDirection.HORIZONTAL);

        assertArrayEquals(array, result);
    }

    @Test
    public void testFlipMatrixWithEmptyMatrix() {
        int[][] result1 = Main.flipMatrix(new int[0][0], FlipDirection.VERTICAL);
        int[][] result2 = Main.flipMatrix(new int[0][0], FlipDirection.HORIZONTAL);

        assertArrayEquals(new int[0][0], result1);
        assertArrayEquals(new int[0][0], result2);
    }
}