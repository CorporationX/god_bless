package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2, 3}, {4, 5, 6}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transformAndShow(matrix);
    }

    private static void transformAndShow(int[][] matrix) {
        int[][] verticalTransformation = flipMatrix(matrix, FlipDirection.VERTICAL);
        int[][] horizontalTransformation = flipMatrix(matrix, FlipDirection.HORIZONTAL);

        System.out.println("Initial matrix");
        showMatrix(matrix);

        System.out.println("Vertical transformation");
        showMatrix(verticalTransformation);

        System.out.println("Horizontal transformation");
        showMatrix(horizontalTransformation);
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int[][] result = new int[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Coordinates newCoordinates = transformer.transform(row, column, rowCount, columnCount);
                result[newCoordinates.x()][newCoordinates.y()] = matrix[row][column];
            }
        }

        return result;
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer = switch (flipDirection) {
            case VERTICAL -> (x, y, rowCount, columnCount) -> new Coordinates(rowCount - 1 - x, y);
            case HORIZONTAL -> (x, y, rowCount, columnCount) -> new Coordinates(x, columnCount - 1 - y);
            default -> throw new IllegalArgumentException(String.format(
                    "Неизвестное значение flipDirection: %s",
                    flipDirection));
        };

        return transformMatrix(matrix, transformer);
    }

    private static void showMatrix(int[][] matrix) {
        int rowCount = matrix.length;

        for (int[] rowData : matrix) {
            System.out.println(Arrays.toString(rowData));
        }
    }
}
