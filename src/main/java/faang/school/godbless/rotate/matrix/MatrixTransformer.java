package faang.school.godbless.rotate.matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(Integer x, Integer y);
}