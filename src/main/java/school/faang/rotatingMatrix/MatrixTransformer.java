package school.faang.rotatingMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}