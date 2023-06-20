package faang.school.godbless.sprint3.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    Logger LOGGER = LoggerFactory.getLogger(VectorJoiner.class);
    T join(List<T> vector);

    static String toCsv(List<String> vector) {
        VectorJoiner<String> joiner = (v) -> {
            if (vector.isEmpty()) {
                LOGGER.error("Empty list");
            }
            return String.join(", ", vector);
        };
        return joiner.join(vector);
    }
}
