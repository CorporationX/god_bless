package school.faang.task_45587;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coordinates {
    private final int x;
    private final int y;

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
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
        }
        return matrix;
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i].length == 0 || matrix[i].length != matrix[i + 1].length) {
                return new int[0][0];
            }
        }

        var rows = matrix.length;
        var columns = matrix[0].length;
        var newMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                var transformedCoordinates = transformer.replaceCoordinates(i, j);
                newMatrix[transformedCoordinates.getX()][transformedCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
