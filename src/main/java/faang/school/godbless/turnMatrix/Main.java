package faang.school.godbless.turnMatrix;

public class Main {

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - y - 1));
        } else if (flipDirection.equals(FlipDirection.VERTICAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - x - 1, y));
        }
        throw new IllegalArgumentException("This direction doesn't exist");
    }
}
