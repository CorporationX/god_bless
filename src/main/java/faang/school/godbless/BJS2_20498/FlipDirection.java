package faang.school.godbless.BJS2_20498;

public enum FlipDirection {
    HORIZONTAL,
    VERTICAL;

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case HORIZONTAL -> Coordinates.transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
            case VERTICAL -> Coordinates.transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        };
    }
}
