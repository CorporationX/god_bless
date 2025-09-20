package school.faang.bjs2_90600;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int coordinateX, int coordinateY);
}