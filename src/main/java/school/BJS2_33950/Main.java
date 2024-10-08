package school.BJS2_33950;

public class Main {
    public static void main(String[] args) {

        int[][] matrixResult = {{5,7},{2,1}};

        printMatrix(matrixResult);

        printMatrix(flipMatrix(matrixResult,FlipDirection.VERTICAL));

        printMatrix(flipMatrix(matrixResult,FlipDirection.HORIZONTAL));

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] flippedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates x = transformer.matrix(i, j);
                flippedMatrix[i][j] = matrix[x.getX()][x.getY()];
            }
        }
        return flippedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection direction) {
        int[][] flippedMatrixWithDirection = new int[matrix.length][matrix[0].length];
        switch (direction) {
            case VERTICAL:  flippedMatrixWithDirection =  transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[x].length - 1 - y));
            break;
            case HORIZONTAL: flippedMatrixWithDirection =  transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
            break;
        }
        return flippedMatrixWithDirection;
    }

}
