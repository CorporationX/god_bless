package faang.school.godbless.matrix;

public class MatrixManager {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer){
        if(matrix.length == 0) {
            return new int[0][0];
        }
        Coordinates result;
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                result = transformer.transform(i, j);
                newMatrix[result.a][result.b] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (!(flipDirection.equals(FlipDirection.VERTICAL) || flipDirection.equals(FlipDirection.HORIZONTAL))) {
            throw new IllegalArgumentException();
        }
        MatrixTransformer horizontalTransform = (a, b) -> {
            if (b > 0) {
                return new Coordinates(a, b - 1);
            }
            return new Coordinates(a, b + 1);
        };
        MatrixTransformer verticalTransform = (a, b) -> {
            if (a > 0) {
                return new Coordinates(a - 1, b);
            }
            return new Coordinates(a + 1, b);
        };
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, horizontalTransform);
        } else {
            return transformMatrix(matrix, verticalTransform);
        }
    }
}
