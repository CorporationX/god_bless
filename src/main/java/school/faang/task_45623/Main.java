package school.faang.task_45623;

public class Main {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;

    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        } else {
            throw new IllegalArgumentException("Ivalid directiomn");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int[][] flippedHorizontally = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("\nПосле горизонтального переворота:");
        printMatrix(flippedHorizontally);

        int[][] flippedVertically = flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("\nПосле вертикального переворота:");
        printMatrix(flippedVertically);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
