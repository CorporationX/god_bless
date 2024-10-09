package lets_rotate_the_matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};

        int[][] resultMatrixVertical = MatrixTransformProcessor.flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println(Arrays.deepToString(resultMatrixVertical));

        int[][] resultMatrixHorizontal = MatrixTransformProcessor.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println(Arrays.deepToString(resultMatrixHorizontal));

        int[][] resultMatrixTransformed = MatrixTransformProcessor.transformMatrix(matrix, (idxRow, idxColumn) -> new Coordinates(idxColumn, idxRow));
        System.out.println(Arrays.deepToString(resultMatrixTransformed));
    }
}
