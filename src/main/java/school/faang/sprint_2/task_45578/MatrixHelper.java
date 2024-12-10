package school.faang.sprint_2.task_45578;

import lombok.NonNull;

public class MatrixHelper {

    private static int[][] transformMatrix(@NonNull int[][] matrix, @NonNull MatrixTransformer transformer) {
        validate(matrix);
        int verticalSize = matrix.length;
        int horizontalSize = matrix[0].length;
        int[][] newMatrix = new int[verticalSize][horizontalSize];

        for (int column = 0; column < verticalSize; column++) {
            for (int line = 0; line < horizontalSize; line++) {
                Coordinates coordinates = transformer.map(line, column);
                newMatrix[coordinates.y()][coordinates.x()] = matrix[column][line];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrixColumns(@NonNull int[][] matrix) {
        validate(matrix);
        int horizontalSize = matrix[0].length - 1;
        return transformMatrix(
                matrix,
                (line, column) -> new Coordinates(horizontalSize - line, column)
        );
    }

    public static int[][] flipMatrixLines(@NonNull int[][] matrix) {
        validate(matrix);
        int verticalSize = matrix.length - 1;
        return transformMatrix(
                matrix,
                (line, column) -> new Coordinates(line, verticalSize - column)
        );
    }

    public static int[][] flipMatrixTransposition(@NonNull int[][] matrix) {
        validate(matrix);
        return transformMatrix(
                matrix,
                (line, column) -> new Coordinates(column, line)
        );
    }

    private static void validate(@NonNull int[][] matrix) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix must be fill");
        }
        if (matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix line must be fill");
        }
    }
}
