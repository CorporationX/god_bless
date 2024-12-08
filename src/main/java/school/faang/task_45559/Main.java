package school.faang.task_45559;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] newMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                Coordinates newCoordinates = transformer.transform(row, col);
                newMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[row][col];
            }
        }

        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix,
                    (x, y) ->
                            new Coordinates(matrix[0].length - x - 1, y));
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix,
                    (x, y) ->
                            new Coordinates(x, matrix[1].length - 1 - y));
        }
        throw new IllegalArgumentException("flipDirection must be VERTICAL or HORIZONTAL");
    }
}
