package school.faangSprint2.t22;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int idxRow, int idxColumn);
}
