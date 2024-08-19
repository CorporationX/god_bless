package faang.school.godbless;

import lombok.val;

public class MatrixUtils {
    public static int[][] transformMatrixHorizontaly(int[][] matrix, MatrixTransformer transformer) {
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
    public static int[][] transformMatrixVerticaly(int[][] matrix, MatrixTransformer transformer) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i%2 !=0 ) continue;
                if(i+1<matrix.length) {
                    val coordinates = transformer.transformMatrix(matrix[i][j],  matrix[i+1][j] );
                    matrix[i][j] = coordinates.getX();
                    matrix[i+1][j] = coordinates.getY();
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
        if (flipDirection == FlipDirection.HORIZONTAL){
            transformMatrixVerticaly(matrix,(x, y)->{
                return new Coordinates(y,x);
            });
        }else {
            transformMatrixHorizontaly(matrix,(x, y)->{
                return new Coordinates(y,x);
            });
        }
        return matrix;
    }
}