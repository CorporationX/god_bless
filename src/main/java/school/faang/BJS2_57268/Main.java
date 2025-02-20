package school.faang.BJS2_57268;

public class Main {
    public static void main(String[] args) {
        final int[][] originalMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int[][] horizontalMatrix = MatrixFlipper.flipMatrix(originalMatrix, FlipDirection.HORIZONTAL);
        final int[][] verticalMatrix = MatrixFlipper.flipMatrix(originalMatrix, FlipDirection.VERTICAL);

        System.out.println("Original Matrix:");
        printMatrix(originalMatrix);
        System.out.println("Horizontal Matrix:");
        printMatrix(horizontalMatrix);
        System.out.println("Vertical Matrix:");
        printMatrix(verticalMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder outputBuffer = new StringBuilder();
        for (int[] row : matrix) {
            for (int col : row) {
                outputBuffer.append(col).append(" ");
            }
            outputBuffer.append("\n");
        }
        System.out.println(outputBuffer);
    }
}
