package matrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        System.out.println("===Base matrix===");
        printMatrix(matrix);
        FlipDirection flipHorizontal = FlipDirection.HORIZONTAL;
        FlipDirection flipVertical = FlipDirection.VERTICAL;

        System.out.println("\n===Flipped matrix by vertical===");
        printMatrix(flipMatrix(matrix, flipVertical));

        System.out.println("\n===Flipped matrix by horizontal===");
        printMatrix(flipMatrix(matrix, flipHorizontal));

    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer, FlipDirection flipDirection) {
        if (flipDirection.equals(FlipDirection.VERTICAL)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length / 2; j++) {
                    swapElements(matrix, transformer, i, j);
                }
            }
            return matrix;
        }

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length / 2; i++) {
                swapElements(matrix, transformer, i, j);
            }
        }
        return matrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 1) {
            return matrix;
        }
        if (matrix.length == 0) {
            return new int[0][0];
        }

        if (flipDirection.equals(FlipDirection.VERTICAL)) {
            MatrixTransformer horizontalTransformer = ((x, y) -> new Coordinates(x, matrix.length - 1 - y));
            return transformMatrix(matrix, horizontalTransformer, flipDirection);
        }
        MatrixTransformer verticalTransformer = ((x, y) -> new Coordinates(matrix.length - 1 - x, y));
        return transformMatrix(matrix, verticalTransformer, flipDirection);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void swapElements(int[][] matrix, MatrixTransformer transformer, int i, int j) {
        Coordinates coordinates = transformer.transform(i, j);
        int tmp = matrix[coordinates.getX()][coordinates.getY()];
        matrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
        matrix[i][j] = tmp;
    }
}
