package faang.school.godbless.flipMatrix;

public class App {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Initial Matrix --> ");
        printMatrix(matrix);

        System.out.println("\nFlipped Horizontally --> ");
        int[][] flippedHorizontal = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        printMatrix(flippedHorizontal);

        System.out.println("\nFlipped Vertically --> ");
        int[][] flippedVertical = flipMatrix(matrix, FlipDirection.VERTICAL);
        printMatrix(flippedVertical);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            transformer = (x, y) -> new Coordinates(x, matrix[0].length - 1 - y);
        } else {
            transformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
        }

        return transformMatrix(matrix, transformer);
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
