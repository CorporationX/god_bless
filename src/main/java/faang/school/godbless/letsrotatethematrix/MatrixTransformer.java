package faang.school.godbless.letsrotatethematrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}