package school.faang.task_59726;

import static school.faang.task_59726.MatrixProcess.printMatrix;

public class Main {
    public static void main(String[] args) {
        int[][] originalMatrix = {{1, 2}, {3, 4}};
        System.out.println("Original matrix:");
        printMatrix(originalMatrix);
        System.out.println("Horizontal flip:");
        printMatrix(MatrixProcess.flipMatrix(originalMatrix, FlipDirection.HORIZONTAL));
        System.out.println("Vertical flip:");
        printMatrix(MatrixProcess.flipMatrix(originalMatrix, FlipDirection.VERTICAL));
        System.out.println("Diagonal flip:");
        printMatrix(MatrixProcess.flipMatrix(originalMatrix, FlipDirection.DIAGONAL));

        int[][] originalMatrixTwo = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}};
        System.out.println("Original matrix:");
        printMatrix(originalMatrixTwo);
        System.out.println("Horizontal flip:");
        printMatrix(MatrixProcess.flipMatrix(originalMatrixTwo, FlipDirection.HORIZONTAL));
        System.out.println("Vertical flip:");
        printMatrix(MatrixProcess.flipMatrix(originalMatrixTwo, FlipDirection.VERTICAL));
    }
}
