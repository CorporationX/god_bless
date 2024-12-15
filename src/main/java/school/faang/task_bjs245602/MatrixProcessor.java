package school.faang.task_bjs245602;

public class MatrixProcessor {
    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
          case VERTICAL -> transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
          case HORIZONTAL -> transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
          default -> throw new IllegalArgumentException("Неверный аргумент flipDirection");
        };
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.x()][coordinates.y()] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
