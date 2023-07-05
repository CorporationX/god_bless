package faang.school.godbless;

public class TransformMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("Исходная матрица");
        printMatrix(matrix);

        int[][] flippedMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("Горизонтально повёрнутая матрица");
        assert flippedMatrix != null;
        printMatrix(flippedMatrix);

        flippedMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("Вертикально повёрнутая матрица");
        assert flippedMatrix != null;
        printMatrix(flippedMatrix);
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {

        MatrixTransformer horizontalTransformer = (x, y) -> new Coordinates(matrix[y].length - x - 1, y);
        MatrixTransformer verticalTransformer = (x, y) -> new Coordinates(x, matrix.length - y - 1);

        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, verticalTransformer);
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, horizontalTransformer);
        }
        return null;
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                Coordinates newCoordinates = transformer.transform(x, y);
                newMatrix[newCoordinates.getY()][newCoordinates.getX()] = matrix[y][x];
            }
        }
        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
