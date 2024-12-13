package school.faang.spring2.task_45598;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        printMatrix(flipMatrix(matrix, FlipDirection.VERTICAL));
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix,
                    (x, y) ->
                            new Coordinates(matrix[0].length - x - 1, y));
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix,
                    (x, y) ->
                            new Coordinates(x, matrix[1].length - 1 - y));
        }
        throw new IllegalArgumentException("Illegal flip");
    }
}
