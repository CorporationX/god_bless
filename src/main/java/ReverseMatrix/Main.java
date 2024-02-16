package ReverseMatrix;

public class Main {

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @FunctionalInterface
    interface MatrixTransformer {
        Coordinates transform(int x, int y);
    }

    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int size = matrix.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Coordinates newCoords = transformer.transform(i, j);
                result[newCoords.x][newCoords.y] = matrix[i][j];
            }
        }

        return result;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;

        if (flipDirection == FlipDirection.HORIZONTAL) {
            transformer = (x, y) -> new Coordinates(x, matrix.length - 1 - y);
        } else {
            transformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
        }

        return transformMatrix(matrix, transformer);
    }

    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2},
                {3, 4}
        };

        int[][] flippedMatrixHorizontal = flipMatrix(originalMatrix, FlipDirection.HORIZONTAL);
        printMatrix(flippedMatrixHorizontal);

        int[][] flippedMatrixVertical = flipMatrix(originalMatrix, FlipDirection.VERTICAL);
        printMatrix(flippedMatrixVertical);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
