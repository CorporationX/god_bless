package school.faang.task2115.matrix;

import school.faang.task2115.coordinate.Coordinates;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates flip(int firstIndex, int secondIndex);
}
