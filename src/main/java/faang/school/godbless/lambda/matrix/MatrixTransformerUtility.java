package faang.school.godbless.lambda.matrix;

import lombok.NonNull;

public class MatrixTransformerUtility {
    private MatrixTransformerUtility() {
    }

    public static int[][] transformMatrix(@NonNull int[][] matrix, @NonNull MatrixTransformer transformer) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        var newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                var newCord = transformer.transform(i, j);
                newMatrix[newCord.getX()][newCord.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] transformMatrix(@NonNull int[][] matrix, @NonNull FlipDirection flipDirection) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        }

        throw new UnsupportedOperationException(String.format("Not supported %s flip direction", flipDirection.name()));
    }

}
