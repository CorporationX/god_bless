package matrixreverse;

import java.util.stream.IntStream;

public class MatrixTransform {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return IntStream.range(0, rows)
                .mapToObj(row -> IntStream.range(0, cols)
                        .map(col -> {
                            Coordinates coordinates = transformer.transform(row, col);
                            return matrix[coordinates.x()][coordinates.y()];
                        })
                        .toArray())
                .toArray(int[][]::new);
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        return switch (flipDirection) {
            case HORIZONTAL -> IntStream.range(0, rows)
                    .mapToObj(row -> IntStream.range(0, columns)
                            .map(column -> matrix[row][columns - 1 - column])
                            .toArray())
                    .toArray(int[][]::new);
            case VERTICAL -> IntStream.range(0, rows)
                    .mapToObj(row -> java.util.Arrays.stream(matrix[rows - 1 - row], 0, columns)
                            .toArray())
                    .toArray(int[][]::new);
        };
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40, 41, 42},
                {43, 44, 45, 46, 47, 48, 49}
        };

        System.out.println("Origin matrix:");
        printMatrix(matrix);

        int[][] horizontalFlip = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("\nHorizontal flip:");
        printMatrix(horizontalFlip);

        int[][] verticalFlip = flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("\nVertical flip:");
        printMatrix(verticalFlip);

        MatrixTransformer transposeTransformer = (row, col) -> new Coordinates(col, row);
        int[][] transposedMatrix = transformMatrix(matrix, transposeTransformer);
        System.out.println("\nTransformed matrix:");
        printMatrix(transposedMatrix);

        int[][] multipliedMatrix = transformMatrix(matrix, Coordinates::new);
        System.out.println("\nMatrix multiply by 2:");
        for (int i = 0; i < multipliedMatrix.length; i++) {
            for (int j = 0; j < multipliedMatrix[i].length; j++) {
                multipliedMatrix[i][j] = matrix[i][j] * 2;
            }
        }
        printMatrix(multipliedMatrix);

        MatrixTransformer reverseRowTransformer = (row, col) -> new Coordinates(row, matrix[row].length - 1 - col);
        int[][] reversedRowsMatrix = transformMatrix(matrix, reverseRowTransformer);
        System.out.println("\nMatrix with flipped strings:");
        printMatrix(reversedRowsMatrix);
    }
}
