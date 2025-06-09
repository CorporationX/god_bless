package school.faang.bjs2_80252_matrix_flip;

public class Main {
    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original matrix:");
        Matrix.printMatrix(originalMatrix);

        int[][] verticallyFlipped = Matrix.flipMatrix(originalMatrix, FlipDirection.VERTICAL);
        System.out.println("Vertically flipped:");
        Matrix.printMatrix(verticallyFlipped);

        int[][] horizontallyFlipped = Matrix.flipMatrix(originalMatrix, FlipDirection.HORIZONTAL);
        System.out.println("Horizontally flipped:");
        Matrix.printMatrix(horizontallyFlipped);
    }
}
