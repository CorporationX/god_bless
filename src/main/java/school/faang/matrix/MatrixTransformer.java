package school.faang.matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates execute(int x, int y);
}
