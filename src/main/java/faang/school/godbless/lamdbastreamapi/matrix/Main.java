package faang.school.godbless.lamdbastreamapi.matrix;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<FlipDirection, MatrixTransformer> FLIP_TRANSFORMER = new HashMap<>();

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        prepareFlipTransformer();

        System.out.println("Вывод оригинальной матрицы");
        showMatrix(matrix);

        int[][] transformedHorizontalMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("Вывод преобразованной матрицы " + FlipDirection.HORIZONTAL);
        showMatrix(transformedHorizontalMatrix);

        int[][] transformedVerticalMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("Вывод преобразованной матрицы " + FlipDirection.VERTICAL);
        showMatrix(transformedVerticalMatrix);
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Coordinates coordinates = transformer.transform(matrix.length, new Coordinates(i, j));
                transformedMatrix[coordinates.x()][coordinates.y()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    private static void prepareFlipTransformer() {
        MatrixTransformer transformerHorizontal = (length, coordinates) -> new Coordinates(
                length - 1 - coordinates.x(),
                coordinates.y()
        );
        MatrixTransformer transformerVertical = (length, coordinates) -> new Coordinates(
                coordinates.x(),
                length - 1 - coordinates.y()
        );

        FLIP_TRANSFORMER.put(FlipDirection.HORIZONTAL, transformerHorizontal);
        FLIP_TRANSFORMER.put(FlipDirection.VERTICAL, transformerVertical);
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return transformMatrix(matrix, FLIP_TRANSFORMER.get(flipDirection));
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);

                if(j < matrix.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
