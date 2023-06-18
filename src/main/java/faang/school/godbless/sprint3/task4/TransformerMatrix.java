package faang.school.godbless.sprint3.task4;

public class TransformerMatrix {

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 3, 5, 6, 7, 8, 0},
                {2, 3, 4, 3, 0, 2, 3}
        };

        int[] stroka= {1, 3, 5, 6, 7, 8, 0};
        System.out.println("длина одномерного массива = " + stroka.length);

        System.out.println("длина строки = " + matrix[1].length); // длина строки
        System.out.println("длина столбца = " + matrix.length); // длина столбца

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                Thread.sleep(2000);
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("________________");
        int[][] ints = flipMatrix(matrix, FlipDirection.HORIZONTAL);

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("________________");
        int[][] intsV = flipMatrix(ints, FlipDirection.VERTICAL);

        for (int i = 0; i < intsV.length; i++) {
            for (int j = 0; j < intsV[i].length; j++) {
                System.out.print(intsV[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] transformMatrixHorizontal(int[][] matrix, MatrixTransformer transformer) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                Coordinates coordinates = transformer.transform(matrix[i][j], matrix[i][matrix[i].length - j - 1]);
                matrix[i][j] = coordinates.getX();
                matrix[i][matrix[i].length - j - 1] = coordinates.getY();
            }
        }
        return matrix;
    }

    static int[][] transformMatrixVertical(int[][] matrix, MatrixTransformer transformer) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                Coordinates coordinates = transformer.transform(matrix[j][i], matrix[matrix.length - j - 1][i]);
                matrix[j][i] = coordinates.getX();
                matrix[matrix.length - j - 1][i] = coordinates.getY();
            }
        }
        return matrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(y, x);
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrixHorizontal(matrix, matrixTransformer);
        } else {
            return transformMatrixVertical(matrix, matrixTransformer);
        }
    }
}
