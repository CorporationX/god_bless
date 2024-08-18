package faang.school.godbless.task20505;

import lombok.AllArgsConstructor;

public class Matrix {
    enum FlipDirection {
        HORIZONTAL,
        VERTICAL;

        static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
            MatrixTransformer transformer;

            switch (flipDirection) {
                case HORIZONTAL:
                    transformer = (i, j) -> new Coordinates(i, matrix[0].length - 1 - j);
                    break;
                case VERTICAL:
                    transformer = (i, j) -> new Coordinates(matrix.length - 1 - i, j);
                    break;
            }
            return matrix;
        }
    }
    @AllArgsConstructor
    class Coordinates {
        private int x;
        private int y;
    }
}
