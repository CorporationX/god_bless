package faang.school.godbless.matrix;

@FunctionalInterface
public interface MatrixTransformer {
  Coordinates transform(Integer x, Integer y);
}