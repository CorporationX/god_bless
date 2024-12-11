package school.faang.sprint_2.task_45578;

import lombok.NonNull;

public class MatrixHelper {

    private static int[][] transformMatrix(@NonNull int[][] matrix, @NonNull MatrixTransformer transformer) {
        validate(matrix);
        int columnSize = matrix.length;
        int rowSize = matrix[0].length;
        int[][] newMatrix = new int[columnSize][rowSize];

        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                Coordinates coordinates = transformer.map(row, column);
                newMatrix[coordinates.y()][coordinates.x()] = matrix[column][row];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrixColumns(@NonNull int[][] matrix) {
        validate(matrix);
        int rowSize = matrix[0].length - 1;
        return transformMatrix(
                matrix,
                (line, column) -> new Coordinates(rowSize - line, column)
        );
    }

    public static int[][] flipMatrixLines(@NonNull int[][] matrix) {
        validate(matrix);
        int columnSize = matrix.length - 1;
        return transformMatrix(
                matrix,
                (line, column) -> new Coordinates(line, columnSize - column)
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
        int columnLength = matrix.length;
        if (columnLength == 0) {
            throw new IllegalArgumentException("Matrix must be fill");
        }
        int rowLength = matrix[0].length;
        if (rowLength == 0) {
            throw new IllegalArgumentException("Matrix line must be fill");
        }
        if (columnLength != rowLength) {
            throw new IllegalArgumentException("Matrix must be square");
        }
    }
}
