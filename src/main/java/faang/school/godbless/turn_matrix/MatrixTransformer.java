package faang.school.godbless.turn_matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}