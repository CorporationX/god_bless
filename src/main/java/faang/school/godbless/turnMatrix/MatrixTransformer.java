package faang.school.godbless.turnMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
