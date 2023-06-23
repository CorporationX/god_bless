package faang.school.godbless.flip_the_matrix;

public class MatrixFlipper {

    public int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;

        if (flipDirection == FlipDirection.HORIZONTAL) {
            transformer = (x, y) -> new Coordinates(x, matrix[0].length - 1 - y);
        } else if (flipDirection == FlipDirection.VERTICAL) {
            transformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
        } else {
            throw new IllegalArgumentException("Invalid flip direction");
        }

        return transformMatrix(matrix, transformer);
    }

    private int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                transformedMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }
}
