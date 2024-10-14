package faang.school.godbless.lambda.matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        var horizontal = MatrixTransformerUtility.transformMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println(Arrays.deepToString(horizontal));
        var vertical = MatrixTransformerUtility.transformMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println(Arrays.deepToString(vertical));
    }

}
