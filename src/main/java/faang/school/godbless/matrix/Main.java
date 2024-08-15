package faang.school.godbless.matrix;

public class Main {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transformedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates from = new Coordinates(i, j);
                Coordinates to = transformer.flip(from);
                transformedMatrix[to.getX()][to.getY()] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case HORIZONTAL -> transformMatrix(matrix, (coordinates) -> new Coordinates(coordinates.getX(), matrix[0].length-1-coordinates.getY()));
            case VERTICAL -> transformMatrix(matrix, (coordinates) -> new Coordinates(matrix.length - 1 - coordinates.getX(), coordinates.getY()));
        };
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2}, {3, 4}};
//        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Given matrix: ");
        printMatrix(matrix);
        System.out.println();

        int[][] flippedMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);

        System.out.println("Flipped matrix: ");
        printMatrix(flippedMatrix);
    }
}
