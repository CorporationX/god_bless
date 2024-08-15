package faang.school.godbless.secondsprint.turningmatrix;

public class MatrixUtils {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates newCoords = transformer.transform(i, j);
                newMatrix[newCoords.getX()][newCoords.getY()] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;
        switch (flipDirection) {
            case HORIZONTAL:
                transformer = (x, y) -> new Coordinates(x, matrix[0].length - 1 - y);
                break;
            case VERTICAL:
                transformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
                break;
            default:
                throw new IllegalArgumentException("Unknown FlipDirection: " + flipDirection);
        }

        return transformMatrix(matrix, transformer);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int[][] horizontallyFlipped = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        int[][] verticallyFlipped = flipMatrix(matrix, FlipDirection.VERTICAL);

        System.out.println("Horizontally flipped:");
        for (int[] row : horizontallyFlipped) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Vertically flipped:");
        for (int[] row : verticallyFlipped) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
