package faang.school.godbless.turnMatrix;

public class Main {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {


    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;
        if (flipDirection == FlipDirection.VERTICAL) {
            transformer = (x, y) -> new Coordinates();
        } else {
            transformer = (x, y) -> new Coordinates();
        }
        return transformMatrix(matrix, transformer);
    }
}
