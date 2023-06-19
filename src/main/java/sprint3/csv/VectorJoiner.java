package sprint3.csv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);

    static String toCsv(List<String> vector) throws IllegalArgumentException {
        VectorJoiner<String> joiner = (v) -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }
            return String.join(", ", vector);
        };
        return joiner.join(vector);
    }
}
