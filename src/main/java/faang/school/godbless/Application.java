package faang.school.godbless;

import lombok.val;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        int[][] matrix = {
                {1, 2, 3,4},
                { 5, 6,7,8},
                { 9,10,11,12}
        };

        val mat = new MatrixUtils();
        mat.transformMatrix(matrix,(x,y)->{
            return new Coordinates(y,x);
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}