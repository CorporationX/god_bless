package transform.matrix;

public class Main {
    public static void main(String[] args) {
        var result = flipMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, FlipDirection.VERTICAL);
        for (int[] row : result) {
            for (int num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        validateMatrix(matrix);
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coords = transformer.getNewCoordinates(j, i);
                result[coords.getY()][coords.getX()] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        validateMatrix(matrix);
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix[0].length - x - 1, y));
        } else {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix.length - y - 1));
        }
    }

    private static void validateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is empty!");
        }
        for (int[] row : matrix) {
            if (row.length == 0) {
                throw new IllegalArgumentException("Row is empty!");
            }
        }
    }

    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }
}