package school.faang.bjs2_80290;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 8},
        };

        int[][] transformedHorizontalMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        int[][] transformedVerticalMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("Оригинальная матрица: ");
        print(matrix);
        System.out.println("Горизонтальный переворот: ");
        print(transformedHorizontalMatrix);
        System.out.println("Вертикальный переворот: ");
        print(transformedVerticalMatrix);
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates coordinates = transformer.handle(i, j);
                result[coordinates.getCoordinateX()][coordinates.getCoordinateY()] = matrix[i][j];
            }
        }

        return result;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (i, j) -> new Coordinates(i, cols - 1 - j));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (i, j) -> new Coordinates(rows - 1 - i, j));
        }
        throw new IllegalArgumentException("Направление переворота матрицы не определено");
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
