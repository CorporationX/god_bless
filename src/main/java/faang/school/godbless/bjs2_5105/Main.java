package faang.school.godbless.bjs2_5105;

public class Main {

    public static void main(String[] args) {
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}};

        System.out.println("Horizontal matrix flipping");
        int[][] result = flipMatrix(matrix2, FlipDirection.HORIZONTAL);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

        System.out.println("Vertical matrix flipping");
        result = flipMatrix(matrix2, FlipDirection.VERTICAL);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                var newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {

        MatrixTransformer mt = (x, y) -> {
            Coordinates coordinates = new Coordinates(x, matrix[0].length - 1 - y);
            if (flipDirection.equals(FlipDirection.VERTICAL)) {
                coordinates.setX(matrix.length - 1 - x);
                coordinates.setY(y);
            }
            return coordinates;
        };
        return transformMatrix(matrix, mt);
    }


}
