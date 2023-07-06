package faang.school.godbless.sprint3.lambda.task4;

public class TransformerMatrix {

    public static int[][] transformMatrixHorizontal(int[][] matrix, MatrixTransformer transformer) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                Coordinates coordinates = transformer.transform(matrix[i][j], matrix[i][matrix[i].length - j - 1]);
                matrix[i][j] = coordinates.getX();
                matrix[i][matrix[i].length - j - 1] = coordinates.getY();
            }
        }
        return matrix;
    }

    public static int[][] transformMatrixVertical(int[][] matrix, MatrixTransformer transformer) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                Coordinates coordinates = transformer.transform(matrix[j][i], matrix[matrix.length - j - 1][i]);
                matrix[j][i] = coordinates.getX();
                matrix[matrix.length - j - 1][i] = coordinates.getY();
            }
        }
        return matrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix == null || matrix[0].length == 0 || flipDirection == null) {
            throw new IllegalArgumentException();
        }
        MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(y, x);
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrixHorizontal(matrix, matrixTransformer);
        } else {
            return transformMatrixVertical(matrix, matrixTransformer);
        }
    }


}
