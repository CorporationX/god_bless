import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.matrix.FlipDirection;
import school.faang.matrix.Matrix;

class MatrixTest {
    @Test
    @DisplayName("Проверка невалидных входных данных (матрица = null)")
    void flipNullMatrixTest() {
        int[][] matrix = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> Matrix.flipMatrix(matrix, FlipDirection.VERTICAL));
    }

    @Test
    @DisplayName("Проверка невалидных входных данных (непредусмотренный тип поворота)")
    void invalidFlipDirectionTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Matrix.flipMatrix(matrix, FlipDirection.DIAGONAL));
    }

    @Test
    @DisplayName("Проверка горизонтального поворота матрицы 3 на 3")
    void flipMatrix3x3HorizontalTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};

        int[][] actual = Matrix.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вертикального поворота матрицы 3 на 3")
    void flipMatrix3x3VerticalTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};

        int[][] actual = Matrix.flipMatrix(matrix, FlipDirection.VERTICAL);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка горизонтального поворота матрицы 4 на 4")
    void flipMatrix4x4HorizontalTest() {
        int[][] matrix = {{5, 6, 7, 8}, {2, 3, 5, 1}, {1, 4, 0, 4}, {0, 5, 6, 7}};
        int[][] expected = {{8, 7, 6, 5}, {1, 5, 3, 2}, {4, 0, 4, 1}, {7, 6, 5, 0}};

        int[][] actual = Matrix.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вертикального поворота матрицы 4 на 4")
    void flipMatrix4x4VerticalTest() {
        int[][] matrix = {{5, 6, 7, 8}, {2, 3, 5, 1}, {1, 4, 0, 4}, {0, 5, 6, 7}};
        int[][] expected = {{0, 5, 6, 7}, {1, 4, 0, 4}, {2, 3, 5, 1}, {5, 6, 7, 8}};

        int[][] actual = Matrix.flipMatrix(matrix, FlipDirection.VERTICAL);
        Assertions.assertArrayEquals(expected, actual);
    }

}