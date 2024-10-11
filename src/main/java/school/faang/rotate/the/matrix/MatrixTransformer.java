package school.faang.rotate.the.matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
