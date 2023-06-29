package faang.school.godbless;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int firstIndex, int secondIndex);
}
