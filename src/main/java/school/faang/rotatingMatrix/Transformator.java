package school.faang.rotatingMatrix;

public class Transformator {

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix.");
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transformedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates transformedCoordinates = transformer.transform(i, j);
                transformedMatrix[transformedCoordinates.getX()][transformedCoordinates.getY()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, Direction direction) {
        if (direction.equals(Direction.HORIZONTAL)) {
            return transformMatrix(matrix, (x, y) -> (new Coordinates(x, matrix[0].length - 1 - y)));
        } else if (direction.equals(Direction.VERTICAL)) {
            return transformMatrix(matrix, (x, y) -> (new Coordinates(matrix.length - 1 - x, y)));
        } else {
            throw new IllegalArgumentException("Invalid direction.");
        }
    }
}
