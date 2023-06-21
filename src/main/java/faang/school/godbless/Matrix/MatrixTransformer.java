package faang.school.godbless.Matrix;

@FunctionalInterface
public interface MatrixTransformer {
        Coordinates transform(int row, int column);
}
