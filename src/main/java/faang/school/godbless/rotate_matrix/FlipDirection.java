package faang.school.godbless.rotate_matrix;

import lombok.Getter;

@Getter
public enum FlipDirection {
    HORIZONTAL((size, x, y) -> new Coordinates(x, size - y - 1)),
    VERTICAL((size, x, y) -> new Coordinates(size - x - 1, y)),
    LEFT_ROTATE((size, x, y) -> new Coordinates(y, size - x - 1)),
    RIGHT_ROTATE(((size, x, y) -> new Coordinates(size - y - 1, x)));

    private final MatrixTransformer matrixTransformer;

    FlipDirection(MatrixTransformer matrixTransformer) {
        this.matrixTransformer = matrixTransformer;
    }
}

