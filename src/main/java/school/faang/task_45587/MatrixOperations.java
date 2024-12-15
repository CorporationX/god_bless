package school.faang.task_45587;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MatrixOperations {

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == null) {
            log.error("Некорретное значение поворота матрицы!");
            return new int[0][0];
        }

        switch (flipDirection) {
            case VERTICAL -> {
                return transformMatrix(matrix, (x, y) ->
                        new Coordinates(matrix.length - 1 - x, y)
                );
            }
            case HORIZONTAL -> {
                return transformMatrix(matrix, (x, y) ->
                        new Coordinates(x, matrix[0].length - 1 - y)
                );
            }
            default -> {
                throw new IllegalArgumentException("Некорретное значение поворота матрицы!");
            }
        }
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        var rows = matrix.length;
        if (rows == 0) {
            return new int[0][0];
        }
        for (int i = 0; i < rows - 1; i++) {
            if (matrix[i].length == 0 || matrix[i].length != matrix[i + 1].length) {
                return new int[0][0];
            }
        }

        var columns = matrix[0].length;
        var newMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                var newCoordinates = transformer.replaceCoordinates(i, j);
                newMatrix[newCoordinates.coordinateX()][newCoordinates.coordinateY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
