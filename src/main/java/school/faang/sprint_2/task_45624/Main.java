package school.faang.sprint_2.task_45624;


public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Default: ");
        printMatrix(matrix);

        System.out.println(FlipDirection.VERTICAL);
        printMatrix(flipMatrix(matrix, FlipDirection.VERTICAL));

        System.out.println(FlipDirection.HORIZONTAL);
        printMatrix(flipMatrix(matrix, FlipDirection.HORIZONTAL));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] vector : matrix) {
            for (int num : vector) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                Coordinates coordinates = transformer.transform(x, y);
                result[coordinates.y()][coordinates.x()] = matrix[y][x];
            }
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection direction) {
        return switch (direction) {
          case VERTICAL -> transformMatrix(matrix,
                    (x, y) -> new Coordinates(x, matrix.length - y - 1));
          case HORIZONTAL -> transformMatrix(matrix,
                    (x, y) -> new Coordinates(matrix[0].length - x - 1, y));
        };
    }
}
