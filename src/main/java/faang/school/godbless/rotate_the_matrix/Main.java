package faang.school.godbless.rotate_the_matrix;

public class Main {
    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArr(arr);

        printArr(flipMatrix(arr, FlipDirection.HORIZONTAL));

        printArr(flipMatrix(arr, FlipDirection.VERTICAL));
    }

    private static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {

        MatrixTransformer TRANSHORIZONTEL = Coordinates::new;

        MatrixTransformer TRANSVERTICAL = (x, y) -> new Coordinates(matrix.length - x - 1, matrix.length - y - 1);

        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, TRANSHORIZONTEL);
        } else if (flipDirection.equals(FlipDirection.VERTICAL)) {
            return transformMatrix(matrix, TRANSVERTICAL);
        }
        return new int[0][0];
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

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



