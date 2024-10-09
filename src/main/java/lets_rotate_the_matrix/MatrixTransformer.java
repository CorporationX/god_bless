package lets_rotate_the_matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int idxRow, int idxColumn);
}
