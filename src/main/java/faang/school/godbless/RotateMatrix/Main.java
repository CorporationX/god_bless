package faang.school.godbless.RotateMatrix;

public class Main {

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                Coordinates newCoordinates = transformer.transform(row, col);
                transformedMatrix[newCoordinates.getY()][newCoordinates.getX()] = matrix[row][col];
            }
        }
        return transformedMatrix;
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer = (row, col) -> {
            switch (flipDirection) {
                case VERTICAL -> {
                    return new Coordinates(row, col + 1);
                }
                case HORIZONTAL -> {
                    return new Coordinates(row + 1, col);
                }
                default -> {
                    return new Coordinates(row, col);
                }
            }
        };
        return transformMatrix(matrix, transformer);
    }
}

enum FlipDirection {
    HORIZONTAL,
    VERTICAL,
}
