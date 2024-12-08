package school.faang.task_45554;

public class Matrix {

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                transformedMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[x].length - (y + 1)));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - (x + 1), y));
        }
        throw new IllegalArgumentException("Illegal argument flipDirection");
    }
}
