package school.faang.task_45592;

import lombok.NonNull;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0x01, 0x02, 0x03, 0x04},
                {0x05, 0x06, 0x07, 0x08},
                {0x09, 0x0A, 0x0B, 0x0C},
                {0x0D, 0x0E, 0x0F, 0x10}
        };

        printMatrix(flipMatrix(matrix, FlipDirection.HORIZONTAL));
        System.out.println();
        printMatrix(flipMatrix(matrix, FlipDirection.VERTICAL));

    }

    private static void printMatrix(@NonNull int[][] matrix) {
        for (int[] vector : matrix) {
            for (int i : vector) {
                System.out.printf("0x%02X ", i);
            }
            System.out.println();
        }
    }


    private static int[][] transformMatrix(@NonNull int[][] matrix, @NonNull MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    private static int[][] flipMatrix(@NonNull int[][] matrix, @NonNull FlipDirection flipDirection) {
        if (FlipDirection.HORIZONTAL.equals(flipDirection)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        } else if (FlipDirection.VERTICAL.equals(flipDirection)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        } else {
            throw new IllegalArgumentException("Invalid flip direction");
        }
    }

}
