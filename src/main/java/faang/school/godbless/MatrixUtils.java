package faang.school.godbless;

import lombok.val;

public class MatrixUtils {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j%2 !=0 ) continue;
                if(j+1<matrix[i].length) {
                    val coordinates = transformer.transformMatrix(matrix[i][j],  matrix[i][j + 1] );
                    matrix[i][j] = coordinates.getX();
                    matrix[i][j + 1] = coordinates.getY();
                }
            }
            System.out.println();
        }
        return matrix;
    }
    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection ){
        return matrix;
    }
}