package school.faang.sprint_2.task_43526;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        printMatrix(flipMatrix(matrix, FlipDirection.HORIZONTAL));
        printMatrix(flipMatrix(matrix, FlipDirection.VERTICAL));
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] newMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.x()][coordinates.y()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case VERTICAL -> transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
            case HORIZONTAL -> transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
            default -> throw new IllegalArgumentException("Неверное направление переворота");
        };
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
