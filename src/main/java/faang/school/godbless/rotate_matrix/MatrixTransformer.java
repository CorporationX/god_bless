package faang.school.godbless.rotate_matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int matrixSize, int x, int y);
}
