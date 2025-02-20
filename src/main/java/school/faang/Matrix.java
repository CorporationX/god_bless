package school.faang;

import lombok.NonNull;

public class Matrix {
    private static int[][] transformMatrix(@NonNull int[][] matrix, MatrixTransformer transformer) {
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        int[][] transformedMatrix = new int[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                Coordinates newCoordinates = transformer.transform(row, column);
                transformedMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[row][column];
            }
        }
        return transformedMatrix;
    }

    public static int[][] flipMatrix(@NonNull int[][] matrix, FlipDirection flipDirection) {
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(numberOfRows - 1 - x, y));
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, numberOfColumns - 1 - y));
        } else {
            throw new IllegalArgumentException("Invalid flip direction: " + flipDirection);
        }
    }
}
