package faang.school.godbless.RotateMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int row, int col);
}
