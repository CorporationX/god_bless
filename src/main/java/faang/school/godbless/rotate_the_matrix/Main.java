package faang.school.godbless.rotate_the_matrix;

import javax.print.DocFlavor;

public class Main {
    private static final MatrixTransformer TRANSHORIZONTEL = (x, y) -> new Coordinates(x, y);
    private static final MatrixTransformer TRANSVERTICAL = (x, y) -> new Coordinates(y, x);
    public static void main(String[] args) {



        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int[] ints : arr) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int[][] newArr = flipMatrix(arr, FlipDirection.VERTICAL);

        for (int[] ints : newArr) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection){
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, TRANSHORIZONTEL);
        } else if (flipDirection.equals(FlipDirection.VERTICAL)) {
            return transformMatrix(matrix, TRANSVERTICAL);
        }
        return new int[0][0];
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newArrays = new int[matrix.length][matrix.length];

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                Coordinates newCoordinates = transformer.transform(x, y);
                newArrays[newCoordinates.getX()][newCoordinates.getY()] = matrix[x][matrix.length - y - 1];
            }
        }

        return newArrays;
    }
}



