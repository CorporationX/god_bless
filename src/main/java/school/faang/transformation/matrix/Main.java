package school.faang.transformation.matrix;

public class Main {
    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        var horizontalRotation = MatrixService.flipMatrix(originalMatrix, FlipDirection.HORIZONTAL);
        var verticalRotation = MatrixService.flipMatrix(originalMatrix, FlipDirection.VERTICAL);

        System.out.println("Оригинальная матрица");
        MatrixService.printMatrix(originalMatrix);

        System.out.println("Горизонтальный поворот");
        MatrixService.printMatrix(horizontalRotation);

        System.out.println("Вертикальный поворот");
        MatrixService.printMatrix(verticalRotation);
    }
}
