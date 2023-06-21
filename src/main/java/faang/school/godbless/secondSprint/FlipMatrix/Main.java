package faang.school.godbless.secondSprint.FlipMatrix;

import lombok.AllArgsConstructor;

public class Main {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.x][coordinates.y] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] invertedMatrix = new int[matrix.length][matrix[0].length];
        if (flipDirection == FlipDirection.HORIZONTAL) {
            MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(x, matrix[0].length - y - 1);
            invertedMatrix = transformMatrix(matrix, matrixTransformer);
        } else if (flipDirection == FlipDirection.VERTICAL) {
            MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
            invertedMatrix = transformMatrix(matrix, matrixTransformer);
        }
        return invertedMatrix;
    }

    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }

    @AllArgsConstructor
    public static class Coordinates {
        int x;
        int y;
    }

    @FunctionalInterface
    public interface MatrixTransformer {
        Coordinates transform(int x, int y);
    }
}
